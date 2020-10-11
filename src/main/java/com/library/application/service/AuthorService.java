package com.library.application.service;


import com.library.application.model.Author;
import com.library.application.repository.AuthorRepository;
import com.library.application.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sun.net.www.protocol.http.AuthenticationHeader;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    public void deleteById(Long id){
        Author author = authorRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Invalid Author Id:" + id ));

        if(author != null ){
            bookRepository.findAll().stream().filter( i -> i.getAuthor().equals(author)).forEach( book  -> bookRepository.delete(book));
        }
        authorRepository.deleteById(id);
    }
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
    public Author findById(Long id){

       return authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Author Id:" + id ));
    }
    public void save(Author author){
        authorRepository.save(author);
    }

}
