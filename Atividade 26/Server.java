import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Server extends UnicastRemoteObject implements IfServer{

    //private Scanner scan;
    static ArrayList<Pessoal> pessoas = new ArrayList<>();

    public Server() throws RemoteException {
        //scan = new Scanner(System.in);
        
	}

    public int getTamanhoArray() throws RemoteException{
        return pessoas.size();
    }

    public String getPessoal(int id) throws RemoteException{
        return pessoas.get(id).toString();
    }

    public static void main(String[] args) {
        try {
            pessoas = lerSequencial("pessoal.csv");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(pessoas.get(0).toString());

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

    public static ArrayList<Pessoal> lerSequencial(String caminho) throws IOException {
        String separador = ";"; 
        ArrayList<Pessoal> pessoas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                
                Pessoal pessoa = new Pessoal(linha);
                pessoas.add(pessoa);
            }
        }
        
        return pessoas;
    }
}
