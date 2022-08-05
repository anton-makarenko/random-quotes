package org.makar.spring3training.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Quote> quotes;
}
