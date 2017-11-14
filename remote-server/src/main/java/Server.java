import interfaces.ComputingService;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Vlad on 13-Nov-17.
 */
public class Server extends ComputingServiceImpl {
    public static void main(String[] args) {
        try {
            ComputingServiceImpl service = new ComputingServiceImpl();

            ComputingService stub = (ComputingService) UnicastRemoteObject.exportObject(service,0);

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("compute",stub);

            System.out.println("Server ready!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
