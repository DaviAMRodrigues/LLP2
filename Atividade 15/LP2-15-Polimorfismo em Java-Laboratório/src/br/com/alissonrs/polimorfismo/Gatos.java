package br.com.alissonrs.polimorfismo;

public class Gatos extends Mamifero {

    private static int contar = 0;

    private int numeroRegistro = 0;

    public Gatos() {
    }

    @Override
    public void correr() {
        System.out.println("Correndo como um gato!");
    }

    public Gatos(String novoNome) {
        nome = novoNome;
        numeroRegistro = contar++;
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau, miau, miau!");
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    @Override
    public void mamar() {
        System.out.println("Chic, chic");
    }
    
}
