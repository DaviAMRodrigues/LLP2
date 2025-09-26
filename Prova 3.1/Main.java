import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        ArrayList<Conta> contas = new ArrayList<>();
        File f = new File(".");
        System.out.println(f.getAbsolutePath());
        
        String caminho = "contas.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                  
                try{
                    Conta conta = lerLinha(linha);
                    contas.add(conta);  
                }catch (Exception e){
                    System.out.println(linha);
                }
                
            }
        } catch (Exception e) {
            //System.out.println("Erro ao abrir o arquivo");
            System.out.println(e);
        }
        System.out.println("\n\nNumero de contas carregadas: " + contas.size());
        System.out.println("Memória usada (bytes): " + (runtime.totalMemory() - runtime.freeMemory()));
    }
        
    public static Conta lerLinha(String linha) throws LinhaIncorreta{
        String[] campos = linha.split(",");
        if(campos[5].length() >1){
            throw new LinhaIncorreta();
        }
        Conta conta = new Conta(Integer.parseInt(campos[0]), campos[1], Float.parseFloat(campos[2]), Float.parseFloat(campos[3]), Float.parseFloat(campos[4]), campos[5].charAt(0));
        return conta;
    }
}
