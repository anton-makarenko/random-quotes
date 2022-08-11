package org.makar.randomquotes.common.repository;

import org.makar.randomquotes.common.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT * FROM authors OFFSET floor(random() * (SELECT COUNT(*) FROM authors)) LIMIT 1", nativeQuery = true)
    Optional<Author> findRandom();
}
