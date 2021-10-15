package com.kou.dagitiksistemler.server;

import com.kou.dagitiksistemler.shared.Car;
import com.kou.dagitiksistemler.shared.DealershipServer;
import com.kou.dagitiksistemler.shared.Receipt;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class RMIServer implements DealershipServer {
    public RMIServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    public HashMap<Integer, Car> getCars()
    {
        File carsFile = new File("cars.dat");

        if (carsFile.exists())
        {
            try
            {
                FileInputStream fileIn = new FileInputStream("cars.dat");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                HashMap<Integer, Car> cars = (HashMap<Integer, Car>) objectIn.readObject();
                objectIn.close();
                fileIn.close();

                return cars;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return new HashMap<>();
    }

    public HashMap<Integer, Receipt> getReceipts()
    {
        File carsFile = new File("receipts.dat");

        if (carsFile.exists())
        {
            try
            {
                FileInputStream fileIn = new FileInputStream("receipts.dat");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                HashMap<Integer, Receipt> receipts = (HashMap<Integer, Receipt>) objectIn.readObject();
                objectIn.close();
                fileIn.close();

                return receipts;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return new HashMap<>();
    }

    public void setCars(HashMap<Integer, Car> cars)
    {
        try {
            FileOutputStream fileOut = new FileOutputStream("cars.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(cars);
            objectOut.close();
            fileOut.close();
            System.out.println("Araclar kaydedildi!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setReceipts(HashMap<Integer, Receipt> receipts)
    {
        try {
            FileOutputStream fileOut = new FileOutputStream("receipts.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(receipts);
            objectOut.close();
            fileOut.close();
            System.out.println("Faturalar kaydedildi!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void addCar(Car car) throws RemoteException {
        HashMap<Integer, Car> cars = getCars();
        cars.put(car.serialNumber, car);
        System.out.printf("Yeni bir arac eklendi: %s\n",car);
        setCars(cars);
    }

    @Override
    public void addReceipt(Receipt receipt) throws RemoteException {
        HashMap<Integer, Receipt> receipts = getReceipts();
        receipts.put(receipt.id, receipt);
        System.out.printf("Yeni bir fatura eklendi: %s\n",receipt);
        setReceipts(receipts);
    }

    @Override
    public Car getCar(Integer serialNumber) throws RemoteException {
        return getCars().get(serialNumber);
    }

    @Override
    public ArrayList<Car> getCar(String brand) throws RemoteException {
        ArrayList<Car> carsToReturn = new ArrayList<>();

        for (Car car : getCars().values())
        {
            if (car.brand.equals(brand))
            {
                carsToReturn.add(car);
            }
        }

        return carsToReturn;
    }

    @Override
    public Receipt getReceipt(Integer id) throws RemoteException {
        return getReceipts().get(id);
    }

    @Override
    public ArrayList<Receipt> getReceipt(String vendorName) throws RemoteException {
        ArrayList<Receipt> receiptsToReturn = new ArrayList<>();

        for (Receipt receipt : getReceipts().values())
        {
            if (receipt.vendorName.equals(vendorName))
            {
                receiptsToReturn.add(receipt);
            }
        }

        return receiptsToReturn;
    }
}
