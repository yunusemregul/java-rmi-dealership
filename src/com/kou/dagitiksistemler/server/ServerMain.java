package com.kou.dagitiksistemler.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        RMIServer server = new RMIServer();
        Registry registry = LocateRegistry.createRegistry(4141);
        registry.bind("Server", server);
        System.out.println("Server started");
    }
}
