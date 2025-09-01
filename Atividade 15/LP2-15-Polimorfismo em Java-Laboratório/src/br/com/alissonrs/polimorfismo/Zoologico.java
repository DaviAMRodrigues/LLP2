package br.com.alissonrs.polimorfismo;


import java.util.ArrayList;

public class Zoologico {

    public static void main(String[] args) {
        Mamifero mama;
        Cachorro cachorro;
        Vaca vaca;
        Gatos gato;

        mama = new Mamifero() {
            @Override
            public void mamar() {
                System.out.println("Xuc xuc");
            }

			@Override
			public void correr() {
				System.out.println("correndo");
			}
        };
        cachorro = new Cachorro("Snoopy");
        vaca = new Vaca();
        gato = new Gatos();

        mama.mamar();
        cachorro.mamar();
        vaca.mamar();
		gato.mamar();

        mama.emitirSom();
        cachorro.emitirSom();
        vaca.emitirSom();
		gato.emitirSom();

        ArrayList<Mamifero> lista = new ArrayList<Mamifero>();
        lista.add(mama);
        lista.add(cachorro);
        lista.add(vaca);
        lista.add(gato);

        for (Mamifero mamifero : lista) {
            mamifero.emitirSom();
            mamifero.mamar();
        }
    }
}