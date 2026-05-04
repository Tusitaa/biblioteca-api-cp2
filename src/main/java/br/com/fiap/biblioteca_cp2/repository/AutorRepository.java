package br.com.fiap.biblioteca_cp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.biblioteca_cp2.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
