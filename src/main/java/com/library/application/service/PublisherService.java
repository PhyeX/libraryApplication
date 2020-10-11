package com.library.application.service;

import com.library.application.model.Publisher;
import com.library.application.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PublisherService {
    PublisherRepository publisherRepository;
    AuthorService authorService;

    public List<Publisher> findAll(){

        return publisherRepository.findAll();
    }
    public Publisher findById(Long id){

        return publisherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Publisher Id:" + id ));
    }

    public void save(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void delete(Long id){
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        authorService.getAllAuthors()
                .stream()
                .filter( i -> i.getPublisher().equals(publisher))
                .forEach( i -> authorService.deleteById(i.getAuthorId()) );
         publisherRepository.deleteById(id);
    }

}
