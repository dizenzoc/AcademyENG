package it.eng.corso.reviewservice.service;

import it.eng.corso.reviewservice.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    ReviewDTO save(ReviewDTO review);

    List<ReviewDTO> findAll();

    ReviewDTO findByUuid(String uuid);

    List<ReviewDTO> findByBookUuid( String bookUuid);

    void delete(String uuid);

    ReviewDTO update(String uuid, ReviewDTO review);

    //ReviewDTO partialUpdate(String uuid, ReviewDTO review);

    Double average( String bookUuid );
}
