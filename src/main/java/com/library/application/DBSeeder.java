package com.library.application;

import com.library.application.model.Author;
import com.library.application.model.Book;
import com.library.application.model.Publisher;
import com.library.application.repository.AuthorRepository;
import com.library.application.repository.BookRepository;
import com.library.application.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DBSeeder implements CommandLineRunner {

     private BookRepository bookRepository;
     private AuthorRepository authorRepository;
     private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        for(int i = 0 ; i < 3 ; i++){
            Publisher publisherFake = new Publisher().builder().name(generateRandomString()).description(generateRandomString()).build();
            List<Author> authors = new ArrayList<Author>();
            this.publisherRepository.save(publisherFake);
            for( int k = 0 ; k < 3 ; k++){
                Author author = new Author().builder().authorName(generateRandomString()).description(generateRandomString()).build();
                author.setPublisher(publisherFake);
                authors.add(author);
                this.authorRepository.save(author);
                List<Book> books= new ArrayList<Book>();
                for( int j = 0 ; j <  3 ; j++){
                    Book book = new Book().builder().subOfBook("").nameOfBook(generateRandomString()).seriesOfBook("").ISBN(generateRandomISBN()).description(generateRandomString()).build();
                    book.setAuthor(author);
                  //  System.out.println(author.getAuthorName());
                    books.add(book);
                    this.bookRepository.save(book);
                }
               // author.setBooks(books);
              //  this.authorRepository.save(author);

            }
           // publisherFake.setAuthors(authors);
           // this.publisherRepository.save(publisherFake);
        }




        Publisher publisher = new Publisher();
        publisher.setDescription("Altın Işık Yayınları 1920'tan beri hizmetinizde.");
        publisher.setName("Altın Işık Yayınları");
        this.publisherRepository.save(publisher);

        Author authorDelete = new Author();
        authorDelete.setAuthorName("SİL BENİ SİL");
        authorDelete.setPublisher(publisher);
        authorRepository.save(authorDelete);
        Book bookSil =  new Book().builder()
                .author(authorDelete)
                .ISBN(generateRandomISBN())
                .nameOfBook("Harry Potter ve Sırlar Odası")
                .seriesOfBook("Harry Potter")
                .subOfBook("")
                .description(generateRandomString())
                .build();
        bookRepository.save(bookSil);
       // authorRepository.save(authorDelete);

        Author author = new Author();
        author.setAuthorName("J. K. Rowling");
        author.setDescription("Bu adam harika");
        author.setPublisher(publisher);
        this.authorRepository.save(author);
      //  publisher.setAuthors(Arrays.asList(author));
        this.authorRepository.save(author);
    //    this.publisherRepository.save(publisher);

        Book book = new Book().builder()
                .author(author)
                .ISBN(generateRandomISBN())
                .nameOfBook("Harry Potter ve Sırlar Odası")
                .seriesOfBook("Harry Potter")
                .subOfBook("")
                .description(generateRandomString())
                .build();


        Book book1 =  new Book().builder()
                .author(author)
                .ISBN(generateRandomISBN())
                .nameOfBook("Harry Potter ve Felsefe Taşı")
                .seriesOfBook("Harry Potter")
                .subOfBook("")
                .description(generateRandomString())
                .build();
        Book book2 = new Book().builder()
                .author(author)
                .ISBN(generateRandomISBN())
                .nameOfBook("Harry Potter ve Azkaban Tutsağı")
                .seriesOfBook("Harry Potter")
                .subOfBook("")
                .description(generateRandomString())
                .build();

        Book book3 = new Book().builder()
                .author(author)
                .ISBN(generateRandomISBN())
                .nameOfBook("Harry Potter ve Ateş Kadehi")
                .seriesOfBook("Harry Potter")
                .subOfBook("")
                .description(generateRandomString())
                .build();

        Book book4 = new Book().builder()
                .author(author)
                .ISBN(generateRandomISBN())
                .nameOfBook("Çok uzun bir ismi olan bir kitap")
                .seriesOfBook("")
                .description(generateRandomString())
                .subOfBook("Ejderhalar Diyarı")
                .build();
     //   System.out.println(author.getAuthorName());
        this.bookRepository.saveAll(Arrays.asList(book,book1,book2,book3,book4));
        //author.setBooks(Arrays.asList(book,book1,book2,book3,book4));
     //   this.authorRepository.save(author);



    }

    public DBSeeder(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }
    public String generateRandomISBN(){
        char [] arr = "0123456789".toCharArray();
        Random random = new Random();
        String result ="";
        for( int i = 0 ; i < 13 ; i++){
            result += arr[random.nextInt(10)];
        }
        return result;
    }

    public String generateRandomString(){

        return UUID.randomUUID().toString();
    }
}
