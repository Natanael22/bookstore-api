package br.com.natanael.bookstore.repositories;

import br.com.natanael.bookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :categoria_id ORDER BY titulo")
    public List<Livro> findAllByCategoria(@Param(value = "categoria_id") int categoria_id);
}