package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.exception.BadRequestException;
import app.prog.exception.NotFoundException;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import app.prog.repository.AuthorRepository;
import app.prog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorRepository authorRepository;

    private final CategoryService categoryService;
    public BookResponse toRest(BookEntity domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor()!=null?domain.getAuthor().getName():null)
                .categories(domain.getCategories())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        AuthorEntity author = authorRepository.findByName(rest.getAuthor());
        if(author == null){
            throw new NotFoundException("author with name: "+rest.getAuthor());
        }
        for (CategoryEntity c: rest.getCategories()) {
            CategoryEntity dbCategory = categoryService.getCategoryById(c.getId());
            if (!Objects.equals(dbCategory.getName(), c.getName())){
                throw new BadRequestException("category with id: "+dbCategory.getId()+" don't have, name: "+c.getName()+dbCategory.getName());
            }
        }

       return BookEntity.builder()
                .author(author)
                .title(rest.getTitle())
                .categories(rest.getCategories())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        AuthorEntity author = authorRepository.findByName(rest.getAuthor());
        if(author == null){
            throw new NotFoundException("author with name: "+rest.getAuthor());
        }
        for (CategoryEntity c: rest.getCategories()) {
            CategoryEntity dbCategory = categoryService.getCategoryById(c.getId());
            if (!Objects.equals(dbCategory.getName(), c.getName())){
                throw new BadRequestException("category with id: "+dbCategory.getId()+" don't have, name: "+c.getName()+dbCategory.getName());
            }
        }

        return BookEntity.builder()
                .id(rest.getId())
                .author(author)
                .title(rest.getTitle())
                .categories(rest.getCategories())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
