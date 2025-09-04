/**
 * ContaExcecao
 */
public class ContaExcecao extends Exception{

    private int valor;

    public ContaExcecao(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "O valor de saque ("+ valor +") excede o limite";
    }

    
}