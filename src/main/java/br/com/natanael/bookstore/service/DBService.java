package br.com.natanael.bookstore.service;

import br.com.natanael.bookstore.domain.Categoria;
import br.com.natanael.bookstore.domain.Livro;
import br.com.natanael.bookstore.repositories.CategoriaRepository;
import br.com.natanael.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    LivroRepository livroRepository;

    public void instanciaBaseDados(){

        Categoria catcoz = new Categoria (0,"cozinha", "livro para iniciantes");
        Livro livrocoz = new Livro(0, "cozinha for dummies", "zacarias", "aprendendo cozinhar do zero", catcoz);

        Categoria catned = new Categoria (0,"TI", "livro para nerds");
        Livro livroned = new Livro(0, "java for dummies", "zacarias", "aprendendo java do zero", catned);

        catcoz.getLivros().addAll(Arrays.asList(livrocoz));
        catned.getLivros().addAll(Arrays.asList(livroned));

        //this.categoriaRepository.saveAll(Arrays.asList(catcoz));
        //this.livroRepository.saveAll(Arrays.asList(livrocoz));

        //this.categoriaRepository.saveAll(Arrays.asList(catned));
        //this.livroRepository.saveAll(Arrays.asList(livroned));
    }
}
