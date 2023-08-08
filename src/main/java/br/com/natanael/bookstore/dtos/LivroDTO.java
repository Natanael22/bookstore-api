package br.com.natanael.bookstore.dtos;

import br.com.natanael.bookstore.domain.Categoria;
import br.com.natanael.bookstore.domain.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {

    private int id;
    private String titulo;
    private String nomeAutor;
    private String texto;

    public LivroDTO(){super();}

    public LivroDTO(Livro livro){
        super();
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.nomeAutor = livro.getNomeAutor();
        this.texto = livro.getTexto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
