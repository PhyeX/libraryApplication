package com.library.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Author {
    @Id
    @GeneratedValue( strategy = IDENTITY )
    private Long authorId;
    @NotNull
    private String authorName;
    @Lob
    private String description;
    @ManyToOne ( cascade = CascadeType.MERGE )
    @JoinColumn(name = "id" )
    @JsonIgnore
    private Publisher publisher;
    @OneToMany( fetch = LAZY , cascade=CascadeType.ALL )
    private List<Book> books;
}
