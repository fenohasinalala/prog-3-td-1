package app.prog.controller.response;

import app.prog.model.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class UpdateBookResponse {
    private int id;
    private String author;
    private String title;
    private List<CategoryEntity> categories;
}
