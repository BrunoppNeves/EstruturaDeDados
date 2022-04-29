package entidades;

public class Livro {
    private String nomeAutor;
    private String titulo;
    private int edicao;
    private Livro proximo;

    public Livro(String nomeAutor, String titulo, int edicao){

    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getTitulo() {
        return titulo;
    }


    public int getEdicao() {
        return edicao;
    }


}
