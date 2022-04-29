package Dados.ListaEncadeada;

public class No {
    private int dado;
    private No proximo;

    public No (int dado){
        this.dado = dado;
        this.proximo = null;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
