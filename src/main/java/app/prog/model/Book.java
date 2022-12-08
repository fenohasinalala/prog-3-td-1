package app.prog.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    /*
    TODO-4-a: Note that i use serial type for ID in database. What does serial do ?
    TODO-4-b: Should I map it with int ? Fix it if there is a problem
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private Integer pageNumber;
    private LocalDate releaseDate;

    public Boolean hasAuthor() {
        return author != null;
    }

}
