package org.makar.randomquotes.common.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Table(name = "quotes")
@Data
public class Quote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(nullable = false, length = 1000)
    private String quote;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
