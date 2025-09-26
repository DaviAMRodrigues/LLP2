import java.rmi.* ;
import java.util.Scanner;
public interface iChat  extends Remote{

    String getMessage(String message) throws RemoteException;
    
}
