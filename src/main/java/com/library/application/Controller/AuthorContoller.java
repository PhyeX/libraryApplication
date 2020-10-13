package com.library.application.Controller;

import com.library.application.dto.BooksDto;
import com.library.application.model.Author;
import com.library.application.model.Book;
import com.library.application.repository.AuthorRepository;
import com.library.application.repository.BookRepository;
import com.library.application.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class AuthorContoller {
    private  final AuthorService authorService;

    @GetMapping("/authors")
    public String getAllAuthors(Model model){


        model.addAttribute("authors",authorService.getAllAuthors());
     return  "authors";
    }
    @GetMapping("/delete/author/{id}")
    public String deleteAuthor(@PathVariable("id") long id ){
        // log.info(authorRepository.findById(id).toString());


        authorService.deleteById(id);
        return "redirect:/authors";
    }
    @PostMapping("/update/author")
    public String update(@Valid Author author, BindingResult result, Model model){ ;
        //log.info(author.toString());
        //  BooksDto author = bookService.findById(author.getBookId().toString());
        Author newAuthor = authorService.findById(Long.valueOf(author.getAuthorId()));

        newAuthor.setAuthorName(author.getAuthorName());
        newAuthor.setDescription(author.getDescription());

        authorService.save(newAuthor);
        return "redirect:/authors";
    }

    @PostMapping("/create/author")
    public String  saveAuthor(@Valid Author author, BindingResult result, Model model){
        // log.info(authorRepository.findById(id).toString());


       authorService.save(author);
        return "redirect:/authors";
    }

}
