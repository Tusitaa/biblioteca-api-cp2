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

import br.com.fiap.biblioteca_cp2.model.Autor;
import br.com.fiap.biblioteca_cp2.repository.AutorRepository;

@RestController
@RequestMapping("api/${api.version}/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody Autor autor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(autor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Autor>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor autor) {
        Optional<Autor> optAutor = repository.findById(id);

        if (optAutor.isPresent()) {
            autor.setId(id);
            Autor autorAlterado = repository.save(autor);
            return ResponseEntity.ok(autorAlterado);
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
