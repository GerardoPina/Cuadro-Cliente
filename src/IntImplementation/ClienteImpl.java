package IntImplementation;

import interfaces.Shapes;
import objects.CuadradoObj;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteImpl {
    public void connectServer() {
        try {
            /* Vareables */
            CuadradoObj cuadrado;
            float area;
            float perimeter;

            // Puerto conectado al cliente y servidor
            Registry registro = LocateRegistry.getRegistry("172.20.10.8", 9090);
            Shapes interfaz = (Shapes) registro.lookup("RMIShapes");
            // Toma de valores de los lados
            cuadrado = (CuadradoObj) interfaz.getCuadrado(4, 8, 5, 7);

            // Formula del area del cuadrado
            area = (float) (cuadrado.getLado1() * cuadrado.getLado2());

            // Formula del perimetro del cuadrado
            perimeter = (float) cuadrado.getLado1() + cuadrado.getLado2() + cuadrado.getLado3() + cuadrado.getlado4();

            // Salida de los resultados de las formulas.
            System.out.println("El perimetro  es: " + perimeter);
            System.out.println("El area  es: " + area);

            // Mensaje de error
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}
