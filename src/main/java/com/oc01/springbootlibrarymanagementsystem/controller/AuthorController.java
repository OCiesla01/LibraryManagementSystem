package com.oc01.springbootlibrarymanagementsystem.controller;

import com.oc01.springbootlibrarymanagementsystem.entity.Author;
import com.oc01.springbootlibrarymanagementsystem.entity.Award;
import com.oc01.springbootlibrarymanagementsystem.entity.Book;
import com.oc01.springbootlibrarymanagementsystem.service.AuthorService;
import com.oc01.springbootlibrarymanagementsystem.service.AwardService;
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
    private AwardService awardService;

    @Autowired
    public AuthorController(
            AuthorService authorService,
            BookService bookService,
            AwardService awardService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.awardService = awardService;
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
        List<Award> awards = author.getAwards();
        model.addAttribute("author", author);
        model.addAttribute("authorFullName", authorFullName);
        model.addAttribute("awards", awards);

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

    @GetMapping("/award-form")
    private String addAwardToAuthor(@RequestParam("authorId") int authorId, Model model) {
        Award award = new Award();
        Author author = authorService.findById(authorId);
        model.addAttribute("award", award);
        model.addAttribute("author", author);

        return "author/author-award-form";
    }

    @PostMapping("/save-author-award")
    private String saveAwardToAuthor(
            @ModelAttribute("award") Award award,
            @RequestParam("authorId") int authorId) {
        Author author = authorService.findById(authorId);
        author.addAward(award);
        authorService.save(author);

        return "redirect:/authors/list";
    }
}