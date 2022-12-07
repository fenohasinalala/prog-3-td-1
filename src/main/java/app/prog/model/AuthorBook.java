package app.prog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "author_book")
@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorBook {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
