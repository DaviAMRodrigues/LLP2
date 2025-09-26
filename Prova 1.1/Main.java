public class Main {
    public static void main(String[] args) {
        Esportivo moto = new Esportivo(2, "Yamaha", 2008);
        moto.setVelocidade(145);
        moto.setCilindradas(0);
        moto.setNumPassageiros(20);
        System.out.println(moto.toString());
        //GerenciadorDeContas teste = new GerenciadorDeContas(); <-- Nao esta funcionando, seria questao 3
        //teste.colocaNoArray();
    }
}
