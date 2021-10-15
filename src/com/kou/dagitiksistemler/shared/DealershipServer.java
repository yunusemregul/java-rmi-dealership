package com.kou.dagitiksistemler.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DealershipServer extends Remote {
    void addCar(Car car) throws RemoteException;
    void addReceipt(Receipt receipt) throws RemoteException;
    Car getCar(Integer serialNumber) throws RemoteException;
    ArrayList<Car> getCar(String brand) throws RemoteException;
    Receipt getReceipt(Integer id) throws RemoteException;
    ArrayList<Receipt> getReceipt(String vendorName) throws RemoteException;
}
