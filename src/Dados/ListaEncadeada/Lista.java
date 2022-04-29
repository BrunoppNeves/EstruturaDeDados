package Dados.ListaEncadeada;

public class Lista {
    private No primeiro;
    private int quantidade;

    public void Lista() {
        primeiro = null;
        quantidade = 0;
    }

    public boolean vazia() {
        return quantidade == 0;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarInicio(int elemento) {
        No noAux = new No(elemento);
        noAux.setProximo(primeiro);
        primeiro = noAux;
        quantidade++;
    }

    public void adicionarFinal(int elemento) {
        No novo = new No(elemento);
        No aux;
        if (vazia()) primeiro = novo;

        else {
            aux = primeiro;
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            aux.setProximo(novo);
        }
        quantidade++;
    }

    public void addPosicao(int elemento, int posicao) {
        if (vazia() || posicao < 1)
            adicionarInicio(elemento);
        else {
            No novo = new No(elemento);
            No aux = primeiro;
            for (int i = 1; i < posicao && aux != null; i++) {
                aux = aux.getProximo();
            }
            if (aux == null) {
                adicionarFinal(elemento);
            } else {
                novo.setProximo(aux.getProximo());
                aux.setProximo(novo);
                quantidade++;
            }
        }
    }

    public No removerInicio() throws Exception {
        No removido = null;
        if (vazia()) throw new Exception("Estrutura Vazia!");
        else {
            removido = primeiro;
            primeiro = primeiro.getProximo();
        }
        quantidade--;
        return removido;
    }

    public No removerFinal() throws Exception {
        No removido = null;
        if (vazia()) throw new Exception("A lista está vazia!");
        else {
            No aux = primeiro;
            removido = aux;
            while (removido.getProximo() != null){
                aux = removido;
                removido = removido.getProximo();
            }
            aux.setProximo(null);
        }
        quantidade--;
        return removido;
    }

    public No removerPosicao(int posicao) throws Exception {
        No removido = null;
        if (vazia() || posicao <= 1) removido = removerInicio();
        else {
            No aux = primeiro;
            removido = aux;
            for(int i = 1; i < posicao && removido != null; i++){
                aux = removido;
                removido = removido.getProximo();
            }
            if (removido == null) removido = removerFinal();
            else aux.setProximo(removido.getProximo());
        }
        return removido;
    }

    public void exibir() {
        No atual = primeiro;

        while (atual != null) {
            System.out.print(atual.getDado() + " ");
            atual = atual.getProximo();
        }

        System.out.println();
    }
}
