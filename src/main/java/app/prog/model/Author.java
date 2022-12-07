package app.prog.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    private Long id;
    @Nonnull
    private String name;

}
