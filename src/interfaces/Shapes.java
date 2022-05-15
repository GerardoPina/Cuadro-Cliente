package interfaces;

import objects.CuadradoObj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Shapes extends Remote {

    public CuadradoObj getCuadrado(int l1, int l2, int l3, int l4) throws RemoteException;

}
