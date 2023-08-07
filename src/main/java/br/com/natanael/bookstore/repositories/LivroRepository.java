package br.com.natanael.bookstore.repositories;

import br.com.natanael.bookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    public List<Livro> findAllWhereCategoriaByid(int id);
}