package br.com.natanael.bookstore.resource;

import br.com.natanael.bookstore.domain.Categoria;
import br.com.natanael.bookstore.dtos.CategoriaDTO;
import br.com.natanael.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){

        categoria = service.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable int id){

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = service.findAll();
        List<CategoriaDTO> listdto = list.stream().map(xpto -> new CategoriaDTO(xpto)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listdto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable int id, @RequestBody Categoria categoria){
        Categoria newCategoria = service.update(id, categoria);
        return ResponseEntity.ok().body(new CategoriaDTO(newCategoria));
    }
}
