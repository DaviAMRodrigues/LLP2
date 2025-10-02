import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.swing.JFrame;

public class Cliente {

    public IfServer remoteCal;
    
    public Cliente() {
        try {           
        remoteCal = (IfServer) Naming.lookup("rmi:///Server");
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    public Pessoal getPessoa(int id) throws RemoteException{
        String linha;
        linha = remoteCal.getPessoal(id);
        Pessoal pessoa = new Pessoal(linha);
        return pessoa;
    }

    public int getTamanho() throws RemoteException{
        int tamanho;
        tamanho = remoteCal.getTamanhoArray();
        return tamanho;
    }

    public static void main(String[] args) throws RemoteException { new Main();   }
    
    public void Main() throws RemoteException {   

        Cliente client = new Cliente();
        
        //Pessoal pessoa = buscaDadosPessoal(3079);
        Janela janela;
        janela = new Janela();
        janela.mostraDados();

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);        
    }   
}
