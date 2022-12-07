package app.prog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private Long id;
    private String title;
    @OneToMany(mappedBy = "book")
    private List<AuthorBook> authorBook;

    public boolean hasAuthor() {
        return authorBook != null;
    }

}
