package com.library.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Publisher {
    @Id
    @GeneratedValue( strategy = IDENTITY )
    private Long id;
    @NotBlank(message = "Publiser name is required")
    @NotNull
    private String name;
    @Lob
    private String description;
    @OneToMany( fetch = LAZY , cascade=CascadeType.ALL)
    private List<Author> authors;


}
