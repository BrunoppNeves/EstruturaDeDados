package TiposdeEstruturas.Listas.ListaEstatica;

public class lista {

    private int vetor[];
    private int quantidade;

    public lista() {
        this.vetor = new int[0];
        this.quantidade = 0;
    }

    public lista(int tamanho) {
        this.vetor = new int[tamanho];
        this.quantidade = 0;
    }

    public boolean estaVazia() {
        if (this.quantidade == 0) return true;
        else return false;

    }

    public boolean estaCheia() {
        if (this.quantidade > this.vetor.length) return true;
        else return false;
    }

    public void adicionarNoFinal(int novoElemento) throws Exception {
        if (estaCheia()) throw new Exception("Estrutura esta cheia!");
        else {
            int indice = this.quantidade;
            this.vetor[indice] = novoElemento;
            this.quantidade++;
        }
    }

    public int removerFinal() throws Exception {
        if (estaVazia()) throw new Exception("Estrutura esta vazia!");
        else {
            int indice = this.quantidade - 1;
            int elementoRemovido = this.vetor[indice];
            this.quantidade = indice;
            return elementoRemovido;
        }
    }

    public void adicionarInicio(int novoElemento) throws Exception {
        if (estaCheia()) throw new Exception("Estrutura cheia!");
        else {
            for (int indice = quantidade; indice > 0; indice--) {
                this.vetor[indice] = this.vetor[indice - 1];
            }
            vetor[0] = novoElemento;
            quantidade++;
        }
    }

    public int removerInicio() throws Exception {
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

    public void adicionarPosicao(int elemento, int posicao) throws Exception {
        if (estaCheia()) throw new Exception("Estrutura cheia!");
        else {
            if (posicao <= 0) adicionarInicio(elemento);
            else if (posicao >= quantidade) adicionarNoFinal(elemento);
            else {
                for (int indice = quantidade; quantidade > posicao; indice--) {
                    vetor[indice] = vetor[indice - 1];
                }
                vetor[posicao] = elemento;
                quantidade++;
            }
        }
    }

    public int removerPosicao(int posicao) throws Exception {
        if (estaVazia()) throw new Exception("Estrutura vazia!");
        else if (posicao <= 0) return removerInicio();
        else if (posicao >= quantidade) return removerFinal();
        else {
            int elementoRemovido = vetor[posicao];
            for (int indice = (posicao); indice < quantidade - 1; indice++) {
                vetor[indice] = vetor[indice + 1];
            }
            quantidade--;
            return elementoRemovido;
        }
    }

    public int meio() throws Exception { //OK
        if (quantidade % 2 == 0) throw new Exception("A lista precisa ser impar!");
        else {
            int aux = (quantidade - 1) / 2;
            return vetor[aux];
        }
    }

    public void trocaPosicao() { // OK
        int aux = vetor[0];
        vetor[0] = vetor[quantidade - 1];
        vetor[quantidade - 1] = aux;
    }

    public int posIndice(int x) throws Exception { //OK
        int aux = 0;
        for (int i = 0; i < quantidade; i++) {
            if (x == vetor[i]) aux = i;
        }
        return aux;
    }

    public void inversor() { //OK
        int tamanho = vetor.length;
        int vetorB[] = new int[tamanho];
        int tamanhoReal = tamanho - 1;

        for (int i = 0; i < tamanho; i++) {
            vetorB[i] = vetor[tamanhoReal - i];
            System.out.print(vetorB[i] + ", ");
        }
    }

    public void eliminaRepetido() throws Exception { //OK
        for (int j = 0; j < quantidade; j++) {
            for (int i = 0; i < quantidade; i++) {
                if (j == 0 && i == 0) {

                } else if (j == (quantidade - 1) && i == (quantidade - 1)) {
                    for (int x = 0; x < quantidade - 1; x++) {
                        if (vetor[quantidade - 1] == vetor[x]) {
                            removerPosicao(quantidade - 1);
                        }
                    }
                } else if (vetor[j] == vetor[i]) {
                    removerPosicao(i);
                }
            }
        }
    }

    public void exibe() {
        for (int i = 0; i < (quantidade); i++) {
            System.out.print(vetor[i] + ", ");
        }
    }
}