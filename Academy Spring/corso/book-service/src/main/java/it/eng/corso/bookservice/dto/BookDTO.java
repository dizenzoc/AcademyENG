package it.eng.corso.bookservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @Null
    private String uuid;

    @NotNull( message = "Attenzione, la lunghezza deve essere compresa tra 5 e 50 caratteri" )
    @Size( min = 5, max = 50 )
    private String title;

    @NotNull
    private String author;

    @NotNull
    @Positive
    private Double price;

    @Positive
    private Double stars;

    @NotNull
    private String isbn;
}
