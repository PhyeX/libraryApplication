package com.library.application.Controller;

import com.library.application.model.Author;
import com.library.application.model.Publisher;
import com.library.application.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/")
@CrossOrigin
public class RestControllerPublisher {
    PublisherService publisherService;
    @GetMapping("/find/publisher/{id}")
    public ResponseEntity<Publisher> find (@PathVariable("id") Long id ){
        try{
            return  new ResponseEntity<Publisher>(publisherService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Publisher>(HttpStatus.BAD_REQUEST);
        }
    }
}
