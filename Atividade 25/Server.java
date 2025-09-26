import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Server extends UnicastRemoteObject implements iChat{

    private Scanner scan;
    

    public Server() throws RemoteException {
        scan = new Scanner(System.in);
        
	}

    public String getMessage(String message) throws RemoteException{
        
        System.out.println("Mensagem Cliente:");
        System.out.println(message);
        System.out.println("Digite uma mensagem:");
        String mensagemServidor = scan.nextLine();
        return mensagemServidor;
    }

    public static void main(String[] args) {
        Server server;
		try {
			server = new Server();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///Server", server);			
			System.out.println("Servidor rodando!");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}