package it.eng.corso.bookservice;

import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.repository.BookRepository;
import it.eng.corso.bookservice.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceApplicationTests {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testSave(){
		bookRepository.deleteAll();

		BookDTO bookToSave = BookDTO.builder()
                .title("Titolo del libro di test")
				.author("Autore del libro di test")
				.price(9.99)
				.isbn("AJHSGGS98338isbn")
				.build();

		BookDTO bookSaved = bookService.save(bookToSave);

		Assertions.assertNotNull(bookSaved.getUuid());
	}

	@Test
	void testModelToDTO(){
		BookDTO bookToSave = BookDTO.builder()
				.title("Titolo del libro di test")
				.author("Autore del libro di test")
				.price(9.99)
				.isbn("AJHSGGS98338isbn")
				.build();

		BookDTO bookSaved = bookService.save(bookToSave);

		Assertions.assertEquals(bookToSave.getAuthor(), bookSaved.getAuthor());
	}

	@Test
	void testStars(){
		BookDTO bookToSave = BookDTO.builder()
				.title("Titolo del libro di test")
				.author("Autore del libro di test")
				.price(9.99)
				.isbn("AJHSGGS98338isbn")
				.build();

		BookDTO bookSaved = bookService.save(bookToSave);

		BookDTO book = bookService.findByUuid(bookSaved.getUuid());
		Assertions.assertNotNull(book.getStars());
	}

}
