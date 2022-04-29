package TiposdeEstruturas.Pilhas;

public class PilhaCaracteres {
    private String vetor[];
    private int quantidade;
    private int tamanho;

    public PilhaCaracteres() {
        tamanho = 10;
        vetor = new String[tamanho];
        quantidade = 0;
    }

    public PilhaCaracteres(int tamanho) {
        this.tamanho = tamanho;
        vetor = new String[tamanho];
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

    public String peek() {
        return vetor[quantidade - 1];
    }

    public void push(String elemento) throws Exception {
        if (estaCheia())
            throw new Exception("A Pilha está cheia!");
        else
            vetor[quantidade] = elemento;
        quantidade++;
    }

    public String pop() {
        String elementoRemovido = vetor[quantidade - 1];
        quantidade--;
        return elementoRemovido;
    }


    public boolean palindrome(String palavra) throws Exception {
        char[] arr = palavra.toCharArray();
        Pilha original = new Pilha(arr.length);
        Pilha aux = new Pilha(arr.length);
        Pilha aux2 = new Pilha(arr.length);
        for (int i = 0; i < arr.length; i++) {
            original.push(arr[i]);
            aux.push(arr[i]);
        }
        while (!aux.estaVazia()) {
            aux2.push(aux.pop());
        }
        while (!false && !original.estaVazia()) {
            if (original.pop() != aux2.pop()) {
                return false;
            }
        }
        return true;
    }

    public boolean Expressão(String expressao) throws Exception {
        Pilha pilha = new Pilha(expressao.length());
        for (int i = 0; i < expressao.length(); i++) {
            if (expressao.charAt(i) == '(') {
                pilha.push(')');
            } else if (expressao.charAt(i) == '[') {
                pilha.push(']');
            } else if (expressao.charAt(i) == '{') {
                pilha.push('}');
            } else if (expressao.charAt(i) == ')') {
                if (pilha.estaVazia() || pilha.pop() != ')') {
                    return false;
                }
            } else if (expressao.charAt(i) == ']') {
                if (pilha.estaVazia() || pilha.pop() != ']')
                    return false;
            }else if (expressao.charAt(i) == '}'){
                if (pilha.estaVazia() || pilha.pop() != '}')
                    return false;
            }
        }
        return pilha.estaVazia();
    } //loading


    public void print() {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(vetor[i]);
            System.out.print(", ");
        }
        System.out.println("\n");
    }
}
