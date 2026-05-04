package br.com.fiap.biblioteca_cp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.biblioteca_cp2.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
