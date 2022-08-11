package org.makar.randomquotes.common.repository;

import org.makar.randomquotes.common.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Long> {
    @Query(value = "SELECT * FROM quotes OFFSET floor(random() * (SELECT COUNT(*) FROM quotes)) LIMIT 1", nativeQuery = true)
    Optional<Quote> findRandom();
}
