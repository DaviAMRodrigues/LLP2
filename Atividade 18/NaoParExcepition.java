public class NaoParExcepition  extends Exception{

    private int valor;

    public NaoParExcepition(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "O numero " + valor + " nao e par";
    }
    
}
