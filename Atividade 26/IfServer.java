import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IfServer extends Remote{

    String getPessoal(int id) throws RemoteException;

    int getTamanhoArray() throws RemoteException;
} 
