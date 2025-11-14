package model;

//A classe Filme armazena e gerencia seus próprios dados, sendo a especialista em fornecer informações sobre si mesma.
//Isso segue o princípio GRASP de Information Expert, pois a responsabilidade fica com a classe que realmente possui os dados.


//Low Coupling + High Cohesion: baixo acoplamento e alta coesão, pois é independente e 
//possui apenas responsabilidades internas ao seu próprio domínio

public class Filme {
    private int id;
    private String titulo;
    private String genero;
    private int ano;
    private int duracao;

    // Construtor: GRASP: Creator – o próprio Modelo cria seus objetos corretamente.
    public Filme(int id, String titulo, String genero, int ano, int duracao) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.duracao = duracao;
    }

    // Getters e Setters: (alta coesão – classe só cuida dos seus próprios dados)
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Filme [id=" + id + ", título=" + titulo + ", gênero=" + genero +
                ", ano=" + ano + ", duração=" + duracao + " min]";
    }
}

