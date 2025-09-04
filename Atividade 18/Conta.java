public class Conta {
    private int saldo;
    private int maxSaque;

    public Conta() {
        this.saldo = 0;
        this.maxSaque = 10000;
    }

    public void deposita (int x){
        saldo = saldo + x;
        System.out.println(" Valor Depositado");
    }
    public void setLimite(int x){
        maxSaque = x;
        System.out.println(" Novo limite colocado");
    }
    public void saca(int x){
        try {
                if (x > maxSaque){
                    throw new ContaExcecao(x);
                }
                saldo = saldo - x;
                System.out.println(" Valor Sacado");
        } catch (ContaExcecao e){
            System.out.println(e);
        } 

    }
    
}
