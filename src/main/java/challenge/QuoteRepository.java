package challenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Integer> {

    @Query(value = "SELECT * FROM scripts ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote getQuote();

    @Query(value = "SELECT * FROM scripts WHERE actor = ?1 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote getQuoteByActor(String actor);

}