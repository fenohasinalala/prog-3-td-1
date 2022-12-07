package app.prog.controller;

import app.prog.controller.mapper.BookRestMapper;
import app.prog.controller.response.BookResponse;
import app.prog.model.Book;
import app.prog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService service;
    private final BookRestMapper mapper;

    @GetMapping("/books")
    public List<BookResponse> getBooks() {
        return service.getBooks().stream()
                .map(mapper::toRest)
                .toList();
    }
}
