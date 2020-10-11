package com.library.application.Controller;

import com.library.application.dto.BooksDto;
import com.library.application.repository.AuthorRepository;
import com.library.application.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/")
@CrossOrigin
public class RestControllerBook {
    private final BookService bookService;

    @GetMapping("/find/{id}")
    public ResponseEntity<BooksDto> find (@PathVariable("id") String id ){
        try{
            return  new ResponseEntity<BooksDto>(bookService.findById(id),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<BooksDto>(HttpStatus.BAD_REQUEST);

        }
    }


}
