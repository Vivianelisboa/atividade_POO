package controller;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

public class FilmeController {
    private List<Filme> filmes;

    public FilmeController() {
        this.filmes = new ArrayList<>();
    }

    // Criar e adicionar um novo filme (padrão Creator)
    public void adicionarFilme(int id, String titulo, String genero, int ano, int duracao) {
        Filme novoFilme = new Filme(id, titulo, genero, ano, duracao);
        filmes.add(novoFilme);
    }

    // Editar um filme existente
    public boolean editarFilme(int id, String novoTitulo, String novoGenero, int novoAno, int novaDuracao) {
        for (Filme f : filmes) {
            if (f.getId() == id) {
                f.setTitulo(novoTitulo);
                f.setGenero(novoGenero);
                f.setAno(novoAno);
                f.setDuracao(novaDuracao);
                return true;
            }
        }
        return false;
    }

    // Remover um filme pelo ID
    public boolean removerFilme(int id) {
        return filmes.removeIf(f -> f.getId() == id);
    }

    // Listar todos os filmes
    public List<Filme> listarFilmes() {
        return filmes;
    }

    // Buscar um filme específico
    public Filme buscarFilme(int id) {
        for (Filme f : filmes) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }
}
