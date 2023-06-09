package com.oc01.springbootlibrarymanagementsystem.controller;

import com.oc01.springbootlibrarymanagementsystem.entity.Author;
import com.oc01.springbootlibrarymanagementsystem.entity.Book;
import com.oc01.springbootlibrarymanagementsystem.service.AuthorService;
import com.oc01.springbootlibrarymanagementsystem.service.BookService;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/list")
    private String booksList(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/books-list";
    }

    @GetMapping("/{bookId}")
    private String bookDetails(@PathVariable("bookId") int bookId, Model model) {
        Book book = bookService.findById(bookId);
        List<Author> authors = book.getAuthors();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);

        return "book/book-details";
    }

    @GetMapping("/create-book")
    private String createBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        return "book/book-form";
    }

    @GetMapping("/update-book")
    private String updateBook(@RequestParam("bookId") int bookId, Model model) {
        Book book = bookService.findById(bookId);
        model.addAttribute("book", book);

        return "book/book-form";
    }

    @GetMapping("/delete")
    private String deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteById(bookId);

        return "redirect:/books/list";
    }

    @PostMapping("/save")
    private String saveBook(@ModelAttribute("book") Book book) {
        if (book.getCopiesInLibrary() > 0) {
            book.setAvailable(true);
        } else {
            book.setAvailable(false);
        }
        bookService.save(book);

        return "redirect:/books/list";
    }

    @GetMapping("/author-form")
    private String addAuthorToBook(@RequestParam("bookId") int bookId, Model model) {
        Book book = bookService.findById(bookId);
        List<Author> authors = authorService.findAll();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);

        return "book/book-author-form";
    }

    @PostMapping("/save-book-author")
    private String saveAuthorToBook(
            @ModelAttribute("book") Book book,
            @RequestParam("authorId") int authorId) {
        Author author = authorService.findById(authorId);
        book.addAuthor(author);
        bookService.save(book);

        return "redirect:/books/list";
    }
}
