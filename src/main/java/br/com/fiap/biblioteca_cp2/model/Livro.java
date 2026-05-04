package br.com.fiap.biblioteca_cp2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livros")
public class Livro {
    @Id
    private Long id;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "autor", length = 100, nullable = false)
    private String autor;

    @Column(name = "ano_publicacao", length = 100, nullable = false)
    private Double anoPublicacao;

    @Column(name = "editora", length = 100, nullable = true)
    private String editora;
    
}
