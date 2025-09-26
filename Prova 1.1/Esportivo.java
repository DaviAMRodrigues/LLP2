public class Esportivo extends Movel{
    private int cilindradas;
    private int numPassageiros;
    @Override
    public String toString() {
        return super.toString() + "Esportivo [cilindradas=" + cilindradas + ", numPassageiros=" + numPassageiros + "]";
    }
    
    public Esportivo(int numeroRodas, String fabricante, int ano) {
        super(numeroRodas, fabricante, ano);
    }
    public Esportivo(String numeroRodas, String fabricante, String ano) {
        super(numeroRodas, fabricante, ano);
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
        if (cilindradas > 0) {
            this.cilindradas = cilindradas;
        }else{
            System.out.println("Em Cilindradas: So é aceitor campos não negativos, não nulos e não vazios");
        }
    }
    public void setCilindradas(String cilindradas) {
        if (Integer.parseInt(cilindradas) > 0) {
            this.cilindradas = Integer.parseInt(cilindradas);
        }else{
            System.out.println("Em Cilindradas: So é aceitor campos não negativos, não nulos e não vazios");
        }
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        if (numPassageiros > 0 && numPassageiros < 5) {
            this.numPassageiros = numPassageiros;
        } else{
            System.out.println("So e aceito o numero de passageiros igual a 1, 2, 3 ou 4");
        }
        
        
    }
    public void setNumPassageiros(String numPassageiros) {
        if (Integer.parseInt(numPassageiros) > 0 && Integer.parseInt(numPassageiros) < 5) {
            this.numPassageiros = Integer.parseInt(numPassageiros);
        } else{
            System.out.println("So e aceito o numero de passageiros igual a 1, 2, 3 ou 4");
        }
        
        
    }
    
    
}
