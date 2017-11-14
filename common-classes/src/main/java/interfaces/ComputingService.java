package interfaces;

import entities.Car;
import entities.ComputedData;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Vlad on 13-Nov-17.
 */
public interface ComputingService extends Remote {
    ComputedData computeData(Car car) throws RemoteException;
}
