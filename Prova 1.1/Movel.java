import java.util.*;
public class Movel {

    protected int numeroRodas;
    protected String fabricante;
    protected int ano;
    private int velocidade;

    @Override
    public String toString() {
        return "Movel [numeroRodas=" + numeroRodas + ", fabricante=" + fabricante + ", ano=" + ano + ", velocidade="
                + velocidade + "]";
    }

    public Movel(int numeroRodas, String fabricante, int ano) {
        if (numeroRodas>0) {
            this.numeroRodas = numeroRodas;
        }else{
            System.out.println("Em Numero Rodas: So é aceitor campos não negativos, não nulos e não vazios");
        }
        if(fabricante.isEmpty()){
            System.out.println("Em Fabricante: So é aceitor campos não negativos, não nulos e não vazios");
        }else{
            this.fabricante = fabricante;
        }
        if (ano>0) {
            this.ano = ano;
        }else{
            System.out.println("Em Ano:So é aceitor campos não negativos, não nulos e não vazios");
        }
    }

    public Movel(String numeroRodas, String fabricante, String ano) {
        if (Integer.parseInt(numeroRodas)>0) {
            this.numeroRodas = Integer.parseInt(numeroRodas);
        }else{
            System.out.println("Em Numero Rodas: So é aceitor campos não negativos, não nulos e não vazios");
        }
        if(fabricante.isEmpty()){
            System.out.println("Em Fabricante: So é aceitor campos não negativos, não nulos e não vazios");
        }else{
            this.fabricante = fabricante;
        }
        if (Integer.parseInt(ano)>0) {
            this.ano = Integer.parseInt(ano);
        }else{
            System.out.println("Em Ano:So é aceitor campos não negativos, não nulos e não vazios");
        }
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        if (velocidade>0) {
            this.velocidade = velocidade;
        }else{
            System.out.println("Em Velocidade: So é aceitor campos não negativos, não nulos e não vazios");
        }
        
    }
    public void setVelocidade(String velocidade) {
        if (Integer.parseInt(velocidade)>0) {
            this.velocidade = Integer.parseInt(velocidade);
        }else{
            System.out.println("Em Velocidade: So é aceitor campos não negativos, não nulos e não vazios");
        }
        
    }
}