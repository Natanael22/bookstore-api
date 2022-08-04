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
public class BookstoreApplication{


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}
