package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService service;
    private final AuthorRestMapper mapper;

    @GetMapping("/authors")
    public List<AuthorResponse> getBooks() {
        return service.getAuthors().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/authors")
    public ResponseEntity<List<AuthorResponse>> createBooks(@RequestBody List<CreateAuthorResponse> toCreate) {
        List<AuthorEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        List<AuthorResponse> response = service.createAuthors(domain).stream()
                .map(mapper::toRest)
                .toList();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/authors")
    public List<AuthorResponse> updateBooks(@RequestBody List<UpdateAuthorResponse> toUpdate) {
        List<AuthorEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updateAuthors(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/authors/{authorId}")
    public AuthorResponse deleteBook(@PathVariable int authorId) {
        return mapper.toRest(service.deleteAuthor(authorId));
    }
}
