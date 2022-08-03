package br.com.natanael.bookstore;

import br.com.natanael.bookstore.domain.Categoria;
import br.com.natanael.bookstore.domain.Livro;
import br.com.natanael.bookstore.repositories.CategoriaRepository;
import br.com.natanael.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat = new Categoria (0,"cozinha", "livro para iniciantes");
		Livro livro = new Livro(0, "cozinha for dummies", "zacarias", "aprendendo cozinhar do zero", cat);

		cat.getLivros().addAll(Arrays.asList(livro));

		this.categoriaRepository.saveAll(Arrays.asList(cat));
		this.livroRepository.saveAll(Arrays.asList(livro));
	}
}
