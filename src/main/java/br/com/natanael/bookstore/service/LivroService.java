package br.com.natanael.bookstore.service;

import br.com.natanael.bookstore.domain.Categoria;
import br.com.natanael.bookstore.domain.Livro;
import br.com.natanael.bookstore.exception.ObjectNotFoundException;
import br.com.natanael.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro save(Livro livro){
        livro.setId(0);
        return repository.save(livro);
    }

    public List<Livro> findAdll(){
        return repository.findAll();
    }

    public Livro findById(int id) {

        Optional<Livro> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("objeto nao encontrado: id: " + id +
                "tipo: " + Livro.class.getName()));
    }

    public void deleteById(int id){
        findById(id);

        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new br.com.natanael.bookstore.resource.exception.DataIntegrityViolationException("constraint violada");
        }
    }

    public Livro update(int id, Livro livro){
        Livro existente = findById(id);
        livro.setNomeAutor(existente.getNomeAutor());
        livro.setTexto(existente.getTexto());
        livro.setTitulo(existente.getTitulo());
        return repository.save(livro);
    }
}
