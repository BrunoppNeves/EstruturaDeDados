package Dados.Pilhas;

public class Pilha {
    private int vetor[];
    private int quantidade;
    private int tamanho;

    public Pilha() {
        tamanho = 10;
        vetor = new int[tamanho];
        quantidade = 0;
    }

    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        vetor = new int[tamanho];
        quantidade = 0;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public boolean estaVazia() {
        if (quantidade != 0) return false;
        else return true;
    }

    public boolean estaCheia() {
        if (quantidade < this.vetor.length) return false;
        else return true;

    }

    public int peek() {
        return vetor[quantidade - 1];
    }

    public void push(int elemento) throws Exception {
        if (estaCheia()) throw new Exception("A Pilha está cheia!");
        else vetor[quantidade] = elemento;
        quantidade++;
    }

    public int pop() {
        int elementoRemovido = vetor[quantidade - 1];
        quantidade--;
        return elementoRemovido;
    }

    public void inverter(Pilha pilha) throws Exception {
        Pilha aux = new Pilha(pilha.getQuantidade());
        Pilha aux2 = new Pilha(pilha.getQuantidade());
        while (!pilha.estaVazia()) {
            aux.push(pilha.pop());
        }
        while (!aux.estaVazia()) {
            aux2.push(aux.pop());
        }
        while (!aux2.estaVazia()) {
            pilha.push(aux2.pop());
        }
    } //ok

    public void ordenar(Pilha pilha) throws Exception {
        Pilha sorted = new Pilha(quantidade);
        Pilha aux = new Pilha(quantidade);
        while (sorted.estaCheia() == false) {
            int maior = pilha.pop();
            while (!pilha.estaVazia()) {
                if (maior < pilha.peek()) {
                    aux.push(maior);
                    maior = pilha.peek();
                    pilha.pop();
                } else {
                    aux.push(pilha.pop());
                }
            }
            sorted.push(maior);
            if (aux.getQuantidade() == 1) {
                sorted.push(aux.pop());
                break;
            }
            maior = aux.pop();
            while (aux.getQuantidade() > 0) {
                if (maior < aux.peek()) {
                    pilha.push(maior);
                    maior = aux.peek();
                    aux.pop();
                } else {
                    pilha.push(aux.pop());
                }
            }
            sorted.push(maior);
            if (pilha.getQuantidade() == 1) {
                sorted.push(pilha.pop());
                break;
            }
        }
        while (!sorted.estaVazia()) {
            pilha.push(sorted.pop());
        }
    } //ok

    public void eliminarMaior(Pilha pilha) throws Exception {
        Pilha aux = new Pilha(pilha.getQuantidade());
        int maior = pilha.pop();
        while (!pilha.estaVazia()) {
            if (maior < pilha.peek()) {
                aux.push(maior);
                maior = pilha.peek();
                pilha.pop();
            } else {
                aux.push(pilha.pop());
            }
        }
        while (!aux.estaVazia()) {
            pilha.push(aux.pop());
        }
    } //ok

    public void eliminaMenor(Pilha pilha) throws Exception {
        Pilha aux = new Pilha(pilha.getQuantidade());
        int menor = pilha.pop();
        while (!pilha.estaVazia()) {
            if (menor > pilha.peek()) {
                aux.push(menor);
                menor = pilha.peek();
                pilha.pop();
            } else {
                aux.push(pilha.pop());
            }
        }
        while (!aux.estaVazia()) {
            pilha.push(aux.pop());
        }
    } //ok

    public void print() {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(vetor[i]);
            System.out.print(", ");
        }
        System.out.println("\n");
    }
}
