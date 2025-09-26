import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

    public Client() {

    }

    public static void main(String[] args) {
        iChat remoteCal;
        String mensagem = null;
        String mensagemServidor = null;
        
        Scanner scan = new Scanner(System.in);
        try {
            remoteCal = (iChat) Naming.lookup("rmi:///Server");

            while (true) {
                System.out.println("Digite uma mensagem:");
                mensagem = scan.nextLine();

                if (mensagem.equals("!exit")) {
                    break;
                }
                
                mensagemServidor = remoteCal.getMessage(mensagem);

                System.out.println("Mensagem Servidor:");
                System.out.println(mensagemServidor);
                if (mensagemServidor.equals("!exit")) {
                    break;
                }
            }
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
    
  }
}
    
