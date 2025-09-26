public class Carga extends Movel{
    private int volumeMaximo;
    private int pesoMaximo;

    @Override
    public String toString() {
        return super.toString() + "Carga [volumeMaximo=" + volumeMaximo + ", pesoMaximo=" + pesoMaximo + "]";
    }

    public Carga(int numeroRodas, String fabricante, int ano) {
        super(numeroRodas, fabricante, ano);
    }
    public Carga(String numeroRodas, String fabricante, String ano) {
        super(numeroRodas, fabricante, ano);
    }

    public int getVolumeMaximo() {
        return volumeMaximo;
    }

    public void setVolumeMaximo(int volumeMaximo) {
        if (volumeMaximo>0) {
            this.volumeMaximo = volumeMaximo;
        }else{
            System.out.println("Em VolumeMaximo: So é aceitor campos não negativos, não nulos e não vazios");
        }
        
    }
    public void setVolumeMaximo(String volumeMaximo) {
        if (Integer.parseInt(volumeMaximo)>0) {
            this.volumeMaximo = Integer.parseInt(volumeMaximo);
        }else{
            System.out.println("Em VolumeMaximo: So é aceitor campos não negativos, não nulos e não vazios");
        }
        
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        if (pesoMaximo>0) {
            this.pesoMaximo = pesoMaximo;
        }else{
            System.out.println("Em PesoMaximo: So é aceitor campos não negativos, não nulos e não vazios");
        }
        
    }
    public void setPesoMaximo(String pesoMaximo) {
        
        if (Integer.parseInt(pesoMaximo) > 0 ) {
            this.pesoMaximo = Integer.parseInt(pesoMaximo);
        }else{
            System.out.println("Em PesoMaximo: So é aceitor campos não negativos, não nulos e não vazios");
        }
        
    }

    

    
}
