package com.oc01.springbootlibrarymanagementsystem.controller;

import com.oc01.springbootlibrarymanagementsystem.entity.Author;
import com.oc01.springbootlibrarymanagementsystem.entity.AwardAndRecognition;
import com.oc01.springbootlibrarymanagementsystem.entity.Book;
import com.oc01.springbootlibrarymanagementsystem.service.AuthorService;
import com.oc01.springbootlibrarymanagementsystem.service.AwardAndRecognitionService;
import com.oc01.springbootlibrarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/list")
    private String authorsList(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);

        return "author/authors-list";
    }

    @GetMapping("/{authorId}")
    private String authorDetails(@PathVariable("authorId") int authorId, Model model) {
        Author author = authorService.findById(authorId);
        String authorFullName = author.getFullName();
        List<AwardAndRecognition> awardsAndRecognitions = author.getAwardsAndRecognitions();
        model.addAttribute("author", author);
        model.addAttribute("authorFullName", authorFullName);
        model.addAttribute("awardsAndRecognitions", awardsAndRecognitions);

        return "author/author-details";
    }

    @GetMapping("/create-author-form")
    private String createAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);

        return "author/author-form";
    }

    @GetMapping("/update-author-form")
    private String updateAuthorForm(@RequestParam("authorId") int authorId, Model model) {
        Author author = authorService.findById(authorId);
        model.addAttribute("author", author);

        return "author/author-form";
    }

    @GetMapping("/update-author-details-form")
    private String updateAuthorDetailsForm(@RequestParam("authorId") int authorId, Model model) {
        Author author = authorService.findById(authorId);
        List<Book> booksList = bookService.findAll();
        model.addAttribute("author", author);
        model.addAttribute("booksList", booksList);

        return "author/author-details-form";
    }

    @GetMapping("/delete")
    private String deleteAuthor(@RequestParam("authorId") int authorId) {
        authorService.deleteById(authorId);

        return "redirect:/authors/list";
    }


    @PostMapping("/save")
    private String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.save(author);

        return "redirect:/authors/list";
    }
}
