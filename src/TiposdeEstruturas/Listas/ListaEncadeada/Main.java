package TiposdeEstruturas.Listas.ListaEncadeada;

public class Main {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        lista.adicionarFinal(1);
        lista.adicionarFinal(2);
        lista.adicionarFinal(3);
        lista.adicionarFinal(4);
        lista.adicionarInicio(5);
        lista.addPosicao(6,5);
        lista.exibir();
        lista.removerInicio();
        lista.exibir();
        lista.removerPosicao(5);
        lista.exibir();
        lista.removerFinal();
        lista.exibir();

    }
}
