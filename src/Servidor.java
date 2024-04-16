import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    
    public static void main (String[] args){
        try {
            int puerto = 9090;
            String servidor = "192.168.128.4";

            System.out.println("Iniciando servidor en: ");
            System.out.println("hostname: " + servidor);
            System.out.println("puerto: " + puerto);

            Registry registro = LocateRegistry.createRegistry(puerto);
            System.setProperty("java.rmi.server.hostname", servidor);
            registro.rebind("Calculadora", new CalcRMI());

            System.out.println("El servidor esta en servicio.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
