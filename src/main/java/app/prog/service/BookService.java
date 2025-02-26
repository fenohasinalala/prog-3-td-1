package app.prog.service;

import app.prog.exception.NotFoundException;
import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<BookEntity> getBooks() {
        return repository.findAll();
    }

    public List<BookEntity> createBooks(List<BookEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<BookEntity> updateBooks(List<BookEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    //TODO-3: should I use Integer here or int ? Why ?
    public BookEntity deleteBook(Integer id) {
        /*
        TIPS: From the API, the Class Optional<T> is :
        A container object which may or may not contain a non-null value.
        If a value is present, isPresent() returns true.
        If no value is present, the object is considered empty and isPresent() returns false.

        T is the type of the value, for example : here the class type is BookEntity
         */
        Optional<BookEntity> optional = repository.findById(id);
        BookEntity toDelete;
        List<CategoryEntity> categories = new ArrayList<>();
        if (optional.isPresent()) {
            for (CategoryEntity c:optional.get().getCategories()) {
                categories.add(c);
            }
            toDelete = BookEntity.builder()
                    .id(optional.get().getId())
                    .title(optional.get().getTitle())
                    .author(optional.get().getAuthor())
                    .categories(categories)
                    .build();
            repository.delete(optional.get());
            return toDelete;
        } else {
        /*
        TODO-5 : The exception appears as an internal server error, status 500.
        We all know that the appropriate error status is the 404 Not Found.
        Any solution to do this ?
        These links may help you :
        Link 1 : https://www.baeldung.com/spring-response-entity
        Link 2 : https://www.baeldung.com/exception-handling-for-rest-with-spring
         */
            throw new NotFoundException("BookEntity." + id + " not found");
        }
    }
}
