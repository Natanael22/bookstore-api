package br.com.natanael.bookstore.resource;

import br.com.natanael.bookstore.domain.Categoria;
import br.com.natanael.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable int id){
        Categoria obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public void save(Categoria categoria){
        this.service.save(categoria);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteId(@PathVariable int id){
        service.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
}
