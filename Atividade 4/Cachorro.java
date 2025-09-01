package zoo;

public class Cachorro extends Mamifero {
    
    private static int contar = 0;

    private int numeroRegistro = 0;

    private String nome;
    
    public Cachorro() {
        super();
        this.nome = "Cachorro sem nome";
        this.numeroRegistro = ++contar;
    }

    public Cachorro(String nome) {
        super();
        this.nome = nome;
        this.numeroRegistro = ++contar;
    }
    
    public void mamar() {
        System.out.println("xuc, xuc, xuc");
    }

    public void emitirSom() {
        System.out.println("Au, au, rrrrrr!");
    }
    
    public String getNome() {
        return this.nome;
    }   

    public int getNumeroRegistro() {
        return this.numeroRegistro;
    }
}
