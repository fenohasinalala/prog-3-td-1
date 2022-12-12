package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.exception.NotFoundException;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorRepository authorRepository;
    public BookResponse toRest(BookEntity domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor()!=null?domain.getAuthor().getName():null)
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        AuthorEntity author = authorRepository.findByName(rest.getAuthor());
        if(author == null){
            throw new NotFoundException("author with name: "+rest.getAuthor());
        }
       return BookEntity.builder()
                .author(author)
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        AuthorEntity author = authorRepository.findByName(rest.getAuthor());
        if(author == null){
            throw new NotFoundException("author with name: "+rest.getAuthor());
        }
        return BookEntity.builder()
                .id(rest.getId())
                .author(author)
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
