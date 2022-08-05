package br.com.natanael.bookstore.service;

import br.com.natanael.bookstore.domain.Categoria;
import br.com.natanael.bookstore.exception.ObjectNotFoundException;
import br.com.natanael.bookstore.repositories.CategoriaRepository;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Categoria save(Categoria categoria){
        categoria.setId(0);
        return repository.save(categoria);
    }
    public Categoria update(int id, Categoria newCategoria){

        //System.out.println("chegou esse id " + id);
        Categoria categoria = findById(id);
        //System.out.println("id existente " +categoria.getId());
        //System.out.println("nome existente " +categoria.getNome());
        categoria.setNome(newCategoria.getNome());
        categoria.setDescricao(newCategoria.getDescricao());
        //System.out.println("novo nome " +newCategoria.getNome());
        //System.out.println("id " +categoria.getId());

        return repository.save(categoria);
    }
    public void deleteById(int id) {
        findById(id);

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new br.com.natanael.bookstore.resource.exception.DataIntegrityViolationException(
                    "existem livros associoados a essa categoria");
        }
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }
}
