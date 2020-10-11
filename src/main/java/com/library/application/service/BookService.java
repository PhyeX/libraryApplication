package com.library.application.service;

import com.library.application.Mapper.BookMapper;
import com.library.application.dto.BooksDto;
import com.library.application.model.Book;
import com.library.application.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BooksDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::mapToDto).collect(toList());
    }

    public BooksDto findById( String id ){
         Book book = bookRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        return bookMapper.mapToDto(book);
    }

   public List<BooksDto> findByNameOfBookIsLike( String nameOfBook){
        return bookRepository.findByNameOfBookIsLike(nameOfBook)
                .stream()
                .map(bookMapper::mapToDto).collect(toList());
   }

   public List<BooksDto> findByNameOfAuthor( String nameOfAuthor ){
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::mapToDto)
                .filter( i -> i.getAuthorName().equals(nameOfAuthor) )
                .collect(toList());
   }

    public List<BooksDto> findByISBN( String ISBN ) {
    return bookRepository.
            findByISBN(ISBN)
            .stream()
            .map(bookMapper::mapToDto)
        .collect(toList());
    }
    public List<BooksDto> findBySeries(String publisherName){
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::mapToDto)
                .filter( i ->i.getSeriesOfBook().equals(publisherName))
                .collect(toList());
    }
       /* return bookRepository.findAll()
                .stream()
                .map(bookMapper::mapToDto)
                .filter( i -> i.getAuthorName().equals(nameOfAuthor) )
                .collect(toList());
    } */

}
