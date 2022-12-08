package app.prog.controller.mapper;

import app.prog.controller.create.CreateBook;
import app.prog.controller.create.UpdateBook;
import app.prog.controller.response.BookResponse;
import app.prog.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRestMapper {
    public BookResponse toRest(Book domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public Book createToDomain(CreateBook createBook) {

        return Book.builder()
                .title(createBook.getTitle())
                .author(createBook.getAuthor())
                .pageNumber(0)
                .build();
    }

    public List<Book> createToDomain(List<CreateBook> createBooks) {
        return createBooks.stream().map(createBook -> createToDomain(createBook)).toList();
    }

    public Book toDomain(UpdateBook updateBook) {
        return Book.builder()
                .id(updateBook.getId())
                .title(updateBook.getTitle())
                .author(updateBook.getAuthor())
                .pageNumber(0)
                .build();
    }

    public List<Book> toDomain(List<UpdateBook> updateBooks) {
        return updateBooks.stream().map(updateBook -> toDomain(updateBook)).toList();
    }
}
