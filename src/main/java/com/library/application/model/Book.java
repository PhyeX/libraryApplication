package com.library.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
     @Id
     @GeneratedValue( strategy = IDENTITY )
     private Long bookId;
     @NotBlank(message = "Name of the book cannot be empty")
     @NotNull
     private String nameOfBook;
     private String subOfBook;
     private String seriesOfBook;
     @ManyToOne ( cascade = CascadeType.MERGE)
     @JsonIgnore
     private Author author;
     @Pattern(regexp = "^\\d{13}", message = "The ISBN number must be 13 digit long.") // A regex check the ISBN number is 13 length of digit.
     private String ISBN;
     @Lob
    private String description;

}
