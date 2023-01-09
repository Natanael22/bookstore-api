package br.com.natanael.bookstore.resource;

import br.com.natanael.bookstore.domain.Livro;
import br.com.natanael.bookstore.dtos.LivroDTO;
import br.com.natanael.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<Livro> save(@RequestParam(value = "categoria", defaultValue = "0") int idCat, @RequestBody Livro livro){
        Livro obj = service.save(idCat, livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable int id){
        Livro livro = service.findById(id);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(){
        List<Livro> list = service.findAdll();
        List<LivroDTO> listDto = list.stream().map(xpto -> new LivroDTO(xpto)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable int id, @RequestBody Livro livro){
        Livro newlivro = service.update(id,livro);
        return ResponseEntity.ok().body(new LivroDTO(newlivro));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> updatePatch(@PathVariable int id, @RequestBody Livro livro){
        Livro newlivro = service.update(id,livro);
        return ResponseEntity.ok().body(new LivroDTO(newlivro));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Livro> deleteById(@PathVariable int id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
