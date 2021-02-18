package com.training

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.books() {

    route("/book") {

        val datamanager = Datamanager()

        get("/") {

            call.respond(datamanager.allBooks())

        }

        post("/") {
            val book = call.receive(Book::class)
            val newBook = datamanager.newBook(book)
            call.respond(newBook)

        }

        put("/") {
            val book = call.receive(Book::class)
            val updatedBook = datamanager.updateBook(book)
            call.respondText { "El libro que se modificó es $updatedBook" }

        }

        delete("/{id}") {
            val id = call.parameters.get("id").toString()
            val deletedBook = datamanager.deleteBook(id)
            call.respond(deletedBook)


        }


    }


}