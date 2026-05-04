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
@Table(name = "autores")
public class Autor {
    @Id
    private Long id;

    @Column(name = "nome_autor", length = 100, nullable = false)
    private String nome;

    @Column(name = "nacionalidade", length = 100, nullable = false)
    private String nacionalidade;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "biografia", length = 100, nullable = true)
    private String biografia;


}
