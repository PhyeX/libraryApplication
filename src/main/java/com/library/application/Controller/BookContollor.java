package com.library.application.Controller;

import com.library.application.Mapper.BookMapper;
import com.library.application.dto.BooksDto;
import com.library.application.model.Author;
import com.library.application.model.Book;
import com.library.application.model.Publisher;
import com.library.application.repository.AuthorRepository;
import com.library.application.repository.BookRepository;
import com.library.application.repository.PublisherRepository;
import com.library.application.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@AllArgsConstructor
@Slf4j
public class BookContollor {

    private final BookService bookService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;
    private final PublisherRepository publisherRepository;


    @GetMapping("/")
        public String goIndex(){
            return "redirect:/index";
    }
    @GetMapping("/index")
    public String  getAllBooks(Model model , String searchText , String select){
    //    log.info(select);
        if( searchText != null ){
            if(searchText.trim().equals("")){
                model.addAttribute("books", bookService.getAll());
            }else{
                if( select.equals("bookName"))
                model.addAttribute("books", bookService.findByNameOfBookIsLike(searchText));
                else if( select.equals("series")){
                    model.addAttribute("books", bookService.findBySeries(searchText));
                }else if(select.equals("authorName")){
                    model.addAttribute("books", bookService.findByNameOfAuthor(searchText));
                } else {
                    model.addAttribute("books", bookService.findByISBN(searchText));
                }

            }

        }else {
            model.addAttribute("books", bookService.getAll());
        }
        return "index";
    }

    @PostMapping("/create")
    public String create(@Valid BooksDto booksDto, BindingResult result, Model model){
        if(result.hasErrors()){
                return "create";
        }

        Book book = bookMapper.map(booksDto);
        bookRepository.save(book);
        log.info(book.getNameOfBook());

        // Get Author if there is no author which is given input then crate a new one.
        String authorName = booksDto.getAuthorName();
        Author author = authorRepository.findByAuthorName(authorName);

            if(author == null){
                author = new Author().builder().authorName(authorName).description("").build();
                authorRepository.save(author);
            }
        book.setAuthor(author);


        // Get Publisher if there is no publisher which is given input then crate a new one and register author to publisher.
        String publisherName = booksDto.getNameOfPublisher();
        Publisher publisher = publisherRepository.findByName(publisherName);

            if(publisher == null){
                publisher = new Publisher().builder().name(publisherName).description("").build();
                publisherRepository.save(publisher);
            }

            author.setPublisher(publisher);
    //        bookRepository.save(book);
    //        authorRepository.save(author);
           bookRepository.save(book);
          //  publisherRepository.save(publisher);
          /*  book.setAuthor(author);

            bookRepository.save(book);
            authorRepository.save(author);*/

        return "redirect:index";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable String id){
;
        Book book = bookRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        bookRepository.delete(book);

        return "redirect:/index";
    }

    @PostMapping("/update")
    public String update(@Valid BooksDto booksDto, BindingResult result, Model model){ ;
        log.info(booksDto.toString());
      //  BooksDto book = bookService.findById(booksDto.getBookId().toString());
        Book book = bookRepository.findById(Long.valueOf(booksDto.getBookId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + booksDto.getBookId()));
        /*
        if( authorRepository.findByAuthorName(booksDto.getAuthorName()) == null ){
            Author author = new Author().builder().authorName(booksDto.getAuthorName()).build();
            book.setAuthor(author); // TODO
            authorRepository.save(author);
        }

        if( publisherRepository.findByName(booksDto.getNameOfPublisher())== null ){
            Publisher publisher = new Publisher().builder().name(booksDto.getNameOfPublisher()).build();
        } */
        book.setSubOfBook(booksDto.getSubOfBook());
        book.setSeriesOfBook(booksDto.getSeriesOfBook());
        book.getAuthor().setAuthorName(booksDto.getAuthorName());
        book.getAuthor().getPublisher().setName(booksDto.getNameOfPublisher());
        bookRepository.save(book);
        return "redirect:/index";
    }



}
