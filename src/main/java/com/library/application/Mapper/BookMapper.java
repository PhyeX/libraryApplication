package com.library.application.Mapper;

import com.library.application.dto.BooksDto;
import com.library.application.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping( target = "nameOfPublisher" , expression = "java(book.getAuthor().getPublisher().getName())")
    @Mapping( target = "authorName" , expression = "java(book.getAuthor().getAuthorName())")
    BooksDto mapToDto(Book book);
    @Mapping( target = "author" , ignore = true)
    Book map (BooksDto booksDto);
}
