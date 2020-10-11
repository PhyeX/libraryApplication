package com.library.application.Controller;

import com.library.application.dto.BooksDto;
import com.library.application.model.Author;
import com.library.application.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/")
@CrossOrigin
public class RestControllerAuthor {
    AuthorService authorService;
    @GetMapping("/find/author/{id}")
    public ResponseEntity<Author> find (@PathVariable("id") Long id ){
        try{
            return  new ResponseEntity<Author>(authorService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);
        }
    }

}
