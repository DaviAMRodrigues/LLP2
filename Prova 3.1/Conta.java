public class Conta {
    private int conta;
    private String nome;
    private float saldo;
    private float credito;
    private float juros;
    private char genero;


    public Conta(int conta, String nome, float saldo, float credito, float juros, char genero) {
        this.conta = conta;
        this.nome = nome;
        this.saldo = saldo;
        this.credito = credito;
        this.juros = juros;
        this.genero = genero;
    }

    
    public int getConta() {
        return conta;
    }
    public void setConta(int conta) {
        this.conta = conta;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public float getCredito() {
        return credito;
    }
    public void setCredito(float credito) {
        this.credito = credito;
    }
    public float getJuros() {
        return juros;
    }
    public void setJuros(float juros) {
        this.juros = juros;
    }
    public char getGenero() {
        return genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }


    @Override
    public String toString() {
        return conta + "," + nome + "," + saldo + "," + credito + ","
                + juros + "," + genero ;
    }
    
}
