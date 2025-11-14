package controller;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

 // GRASP: Controller – esta classe atua como o controlador das operações de filmes.
    // Alta Coesão – inicializa apenas sua própria estrutura interna.
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

      // GRASP: Controller – centraliza a ação de remoção.
    // Baixo acoplamento – a lógica está dentro do controller, sem chamar outras camadas.
    
    public boolean removerFilme(int id) {
        return filmes.removeIf(f -> f.getId() == id);
    }

    // GRASP: Information Expert – o controller conhece a lista e sabe localizar o filme certo.
    // Low Coupling – apenas acessa o filme, não depende de outra classe ou serviço.
    
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

