/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.uni.rmi.rmiclient;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.uni.rmi.rmiinterface.RmiInterface;

/**
 *
 * @author David
 */
public class RmiClient { 
    public static void main(String[] args) {
        RmiInterface serverInterface;
        String ipServer = "192.168.1.12";
        int portServer = 3232;
        try {
            Registry registry = LocateRegistry.getRegistry(ipServer, portServer);
            serverInterface = (RmiInterface) (registry.lookup("operation"));
            int resultado = serverInterface.calcularSuma(3,4);
            System.out.println("Suma: "+ resultado);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
