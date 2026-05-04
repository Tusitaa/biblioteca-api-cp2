package br.com.fiap.biblioteca_cp2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.biblioteca_cp2.model.Livro;
import br.com.fiap.biblioteca_cp2.repository.LivroRepository;

@RestController
@RequestMapping("api/${api.version}/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(livro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
        Optional<Livro> optLivro = repository.findById(id);

        if (optLivro.isPresent()) {
            livro.setId(id);
            Livro livroAlterado = repository.save(livro);
            return ResponseEntity.ok(livroAlterado);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
