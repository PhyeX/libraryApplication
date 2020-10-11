package com.library.application.repository;

import com.library.application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    List<Book> findAll();

    @Override
    void deleteById(Long aLong);

   List<Book> findByNameOfBookIsLike(String bookName);

   List<Book> findByISBN(String ISBN);



}
