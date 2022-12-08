package app.prog.controller.create;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter

public class CreateBook {
    private String author;
    private String title;
}
