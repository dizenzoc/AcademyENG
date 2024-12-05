package it.eng.corso.bookservice;

import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.model.Book;
import it.eng.corso.bookservice.repository.BookRepository;
import it.eng.corso.bookservice.service.BookServiceImpl;
import org.hibernate.boot.model.source.spi.AssociationSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class BookServiceMockTest {

    @Mock
    private BookRepository bookRepository;

    //injectmocks permette di mockare gli oggetti
    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testSave() {
        Book bookSaved = Book.builder()
                .title("Titolo del bookSaved")
                .author("Autore del bookSaved")
                .price(9.99)
                .isbn("AJHSGGS98338isbn")
                .build();

        Mockito.when( bookRepository.save( Mockito.any() ) )
                .thenReturn( bookSaved );

        BookDTO bookDTOSaved = bookService.save( BookDTO.builder().build() );

        Assertions.assertEquals( bookSaved.getAuthor(), bookDTOSaved.getAuthor() );

        ArgumentCaptor<Book> uuidCaptor = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookRepository).save( uuidCaptor.capture() );
        Assertions.assertNotNull(uuidCaptor.getValue().getUuid());

        Mockito.verify( bookRepository, Mockito.times( 1 ) )
                .save( Mockito.any() );

    }

}
