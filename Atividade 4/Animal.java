package zoo;

public class Animal {
    protected int idade;
    protected String nome;

    public Animal() {
        this.idade = 0;
        this.nome = "Animal sem nome";
    }
    
    public void reclamar() {
        System.out.println("Animal reclamando!");
    }
}
