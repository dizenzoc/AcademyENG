package it.eng.corso.reviewservice.service;

import it.eng.corso.reviewservice.dto.ReviewDTO;
import it.eng.corso.reviewservice.model.Review;
import it.eng.corso.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewDTO save(ReviewDTO review) {
        review.setUuid( String.valueOf(UUID.randomUUID()) );
        return modelToDTO( reviewRepository.save( dtoToModel( review ) ) );
    }

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll()
                .stream()
                .map(this::modelToDTO)
                .toList();
    }

    @Override
    public ReviewDTO findByUuid(String uuid) {
        return modelToDTO( reviewRepository.findByUuid(uuid)
                .orElseThrow() );
    }

    @Override
    public List<ReviewDTO> findByBookUuid(String bookUuid) {
        return reviewRepository.findByBookUuid( bookUuid )
                .stream()
                .map(this::modelToDTO)
                .toList();
    }


    @Override
    public void delete(String uuid) {
        Review reviewToDelete = reviewRepository.findByUuid(uuid)
                .orElseThrow();
        reviewRepository.delete(reviewToDelete);

    }

    @Override
    public ReviewDTO update(String uuid, ReviewDTO review) {
        Review reviewToUpdate = reviewRepository.findByUuid(uuid).get();

        reviewToUpdate.setStars(review.getStars());

        return modelToDTO( reviewRepository.save( reviewToUpdate ) );
    }

    @Override
    public Double average(String bookUuid) {
        return reviewRepository.findByBookUuid(bookUuid)
                .stream()
                .map(Review::getStars)
                .mapToDouble( Double::doubleValue )
                .average()
                .orElse( 0D );
    }


    private Review dtoToModel(ReviewDTO book ){
        return Review.builder()
                .uuid(book.getUuid())
                .stars(book.getStars())
                .bookUuid(book.getBookUuid())
                .createdAt(book.getCreatedAt())
                .build();
    }

    private ReviewDTO modelToDTO( Review book ){
        return ReviewDTO.builder()
                .uuid(book.getUuid())
                .stars(book.getStars())
                .bookUuid(book.getBookUuid())
                .createdAt(book.getCreatedAt())
                .build();
    }
}
