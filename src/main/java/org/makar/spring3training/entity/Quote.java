package org.makar.spring3training.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "quotes")
@Data
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(nullable = false)
    private String quote;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
