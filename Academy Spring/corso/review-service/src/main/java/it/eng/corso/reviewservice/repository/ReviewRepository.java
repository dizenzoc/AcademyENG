package it.eng.corso.reviewservice.repository;

import it.eng.corso.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUuid(String uuid );

    List<Review> findByBookUuid(String bookUuid );

}
