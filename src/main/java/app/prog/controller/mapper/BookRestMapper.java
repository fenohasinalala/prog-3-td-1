package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    public BookResponse toRest(Book domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .authors_id(domain.getAuthorBook().stream().map(authorBook->authorBook.getAuthor().getId()).toList())
                .hasAuthor(domain.hasAuthor())
                .build();
    }
}
