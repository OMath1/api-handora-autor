package br.com.handora.autor.repository;

import br.com.handora.autor.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutorRepository extends JpaRepository<Autor, Long > {
    List<Autor> findByEmail(String email);

}
