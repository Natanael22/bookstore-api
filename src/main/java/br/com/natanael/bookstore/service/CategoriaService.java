package br.com.natanael.bookstore.service;

import br.com.natanael.bookstore.domain.Categoria;
import br.com.natanael.bookstore.exception.ObjectNotFoundException;
import br.com.natanael.bookstore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(int id){

        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("objeto nao encontrado: id: "+id +
                " tipo: " + Categoria.class.getName()));
    }

    public void save(Categoria categoria){
        System.out.println(categoria.getDescricao());
        System.out.println(categoria.getNome());
        System.out.println(categoria.getId());

        repository.save(categoria);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }
}
