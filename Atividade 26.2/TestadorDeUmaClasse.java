class UmaClasse {
    static int contador = 0;
    private static UmaClasse instancia = null;
    private UmaClasse(){
        contador++;
    }

    public static UmaClasse getUmaClasse(){
        if(instancia == null){
            instancia = new UmaClasse();
        }
        return instancia;
    }
}
public class TestadorDeUmaClasse {

    public static void main(String[] args) {
        UmaClasse uma;
        for(int i = 0; i<4; i++) {
            uma = UmaClasse.getUmaClasse();
        }
        System.out.println("Total de instancia Criadas: " + UmaClasse.contador);
    }
}