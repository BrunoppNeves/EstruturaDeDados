package Dados.Filas;

import Dados.Pilhas.Pilha;

public class Fila {
    private int vetor[];
    private int quantidade;

    public Fila() {
        this.vetor = new int[0];
        this.quantidade = 0;
    }

    public Fila(int tamanho) {
        this.vetor = new int[tamanho];
        this.quantidade = 0;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean estaVazia() {
        if (this.quantidade == 0) return true;
        else return false;

    }

    public boolean estaCheia() {
        if (this.quantidade > this.vetor.length) return true;
        else return false;
    }

    public int retornaElemento() throws Exception {
        if (estaVazia())
            throw new Exception("Lista Vazia");
        else
            return vetor[0];
    }

    public void enfileirar(int novoElemento) throws Exception {
        if (estaCheia()) throw new Exception("Estrutura esta cheia!");
        else {
            int indice = this.quantidade;
            this.vetor[indice] = novoElemento;
            this.quantidade++;
        }
    }

    public int desenfileirar() throws Exception {
        if (estaVazia()) throw new Exception("Estrutura vazia!");
        else {
            int elementoRemovido = vetor[0];
            for (int indice = 1; indice < quantidade; indice++) {
                vetor[indice - 1] = vetor[indice];
            }
            quantidade--;
            return elementoRemovido;
        }
    }

    public int removeCauda(Fila fila) throws Exception { //ok
        int removeu = fila.getQuantidade() - 1;
        Fila aux = new Fila(fila.getQuantidade());
        while (!fila.estaVazia()) {
            aux.enfileirar(fila.desenfileirar());
        }
        for (int i = 0; i < removeu; i++) {
            fila.enfileirar(aux.desenfileirar());
        }
        return removeu;
    }

    public void exibeInverso() throws Exception {
        for (int i = 1; i <= (quantidade); i++) {
            System.out.print(vetor[quantidade - i] + ", ");
        }
        System.out.println("\n");
    }

    public void inverteComFila(Fila fila) throws Exception {
        int tamanhoOriginal = fila.getQuantidade();
        Fila aux1 = new Fila(fila.getQuantidade());
        Fila aux2 = new Fila(fila.getQuantidade());
        while (fila.getQuantidade() > 1) {
            aux1.enfileirar(fila.desenfileirar());
        }
        while (true) {
            while (aux1.getQuantidade() > 1) {
                aux2.enfileirar(aux1.desenfileirar());
            }
            fila.enfileirar(aux1.desenfileirar());
            if (fila.getQuantidade() == tamanhoOriginal) {
                break;
            }
            while (aux2.getQuantidade() > 1) {
                aux1.enfileirar(aux2.desenfileirar());
            }
            fila.enfileirar(aux2.desenfileirar());
            if (fila.getQuantidade() == tamanhoOriginal) {
                break;
            }
        }
    }

    public void inverterComPilha(Fila fila) throws Exception {
        int contador = fila.getQuantidade();
        Pilha aux = new Pilha(fila.getQuantidade());
        for (int i = 1; i <= contador; i++){
            aux.push(fila.desenfileirar());
        }
        for (int i = 1; i <= contador; i++){
            fila.enfileirar(aux.pop());
        }
    }

    public void exibe() {
        for (int i = 0; i < (quantidade); i++) {
            System.out.print(vetor[i] + ", ");
        }
        System.out.println("\n");
    }
}

