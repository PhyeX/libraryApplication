package com.library.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BooksDto {
    private Long bookId;
    private String nameOfBook;
    private String subOfBook;
    private String seriesOfBook;
    private String authorName;
    private String nameOfPublisher;
    private String ISBN;
    private String description;
}
