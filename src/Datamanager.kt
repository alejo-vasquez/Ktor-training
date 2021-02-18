package com.training

class Datamanager {
    var books = ArrayList<Book>()

    fun gimmeId(): String {

        return books.size.toString()
    }

    init {

        books.add(Book(gimmeId(), "How to grow apples", "mr appleton", 100.0f))
        books.add(Book(gimmeId(), "How to grow pineapples", "mr orangton", 100.0f))
        books.add(Book(gimmeId(), "How to grow oranges", "mr pineapple", 100.0f))
        books.add(Book(gimmeId(), "How to grow pears", "mr Pears", 100.0f))
        books.add(Book(gimmeId(), "How to grow coconuts", "mr coconut", 100.0f))
        books.add(Book(gimmeId(), "How to grow lemons", "mr lrmon", 100.0f))

    }

    fun newBook(book: Book): Book {
        books.add(book)
        return book!!
    }

    fun updateBook(book: Book): Book? {
        val foundbook = books.find {
            it.id == book.id
        }

        foundbook?.title = book.title
        foundbook?.author = book.author
        foundbook?.price = book.price

        return foundbook

    }

    fun deleteBook(bookId: String): Book {
        val bookFound = books.find {
            it.id == bookId
        }
        books.remove(bookFound)

        return bookFound!!
    }

    fun allBooks(): List<Book> {
        return books;
    }

}