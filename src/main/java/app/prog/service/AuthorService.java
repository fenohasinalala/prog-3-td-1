package app.prog.service;

import app.prog.exception.ResourceNotFoundException;
import app.prog.model.Author;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public List<Author> createAuthors(List<Author> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Author> updateAuthors(List<Author> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    //TODO-3: should I use Integer here or int ? Why ?
    public Author deleteAuthor(int AuthorId) {
        Optional<Author> optional = repository.findById(String.valueOf(AuthorId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResourceNotFoundException("Author." + AuthorId + " not found");
        }
    }
}
