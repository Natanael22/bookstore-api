package br.com.natanael.bookstore.resource;

import br.com.natanael.bookstore.domain.Livro;
import br.com.natanael.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro){
        service.save(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable int id){
        Livro livro = service.findById(id);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll(){
        return null;
    }

    @PutMapping
    public ResponseEntity<Livro> update(@PathVariable int id, @RequestBody Livro livro){
        Livro newlivro = service.update(id,livro);
        return ResponseEntity.ok().body(newlivro);
    }

    @DeleteMapping
    public ResponseEntity<Livro> deleteById(@PathVariable int id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
