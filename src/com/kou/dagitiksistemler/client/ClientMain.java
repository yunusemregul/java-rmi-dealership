package com.kou.dagitiksistemler.client;

import com.kou.dagitiksistemler.shared.Car;
import com.kou.dagitiksistemler.shared.DealershipServer;
import com.kou.dagitiksistemler.shared.Receipt;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {
    private static DealershipServer server;

    public static void main(String[] args) throws NotBoundException, RemoteException {
        Registry registry = LocateRegistry.getRegistry("localhost", 4141);
        server = (DealershipServer)registry.lookup("Server");

        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("\nIslem seciniz:");
            System.out.println("1. Yeni arac olustur");
            System.out.println("2. Yeni fatura olustur");
            System.out.println("3. Seri numarasindan arac sorgula");
            System.out.println("4. Markadan arac sorgula");
            System.out.println("5. ID ile fatura sorgula");
            System.out.println("6. Satici adi ile fatura sorgula");
            System.out.println("0. Kapat");

            Integer input = Integer.parseInt(in.nextLine());

            switch (input)
            {
                case 1:
                    System.out.println("Seri numarasi giriniz: ");
                    Integer serialNumber = Integer.parseInt(in.nextLine());
                    System.out.println("Marka giriniz: ");
                    String brand = in.nextLine();
                    System.out.println("Model giriniz: ");
                    String model = in.nextLine();
                    System.out.println("Renk giriniz: ");
                    String color = in.nextLine();
                    System.out.println("Yil giriniz: ");
                    Integer year = Integer.parseInt(in.nextLine());
                    System.out.println("Agirlik giriniz: ");
                    Integer weight = Integer.parseInt(in.nextLine());
                    System.out.println("Fiyat giriniz: ");
                    Integer price = Integer.parseInt(in.nextLine());

                    server.addCar(new Car(serialNumber, brand, model, color, year, weight, price));

                    System.out.println("Arac eklendi!");

                    break;
                case 2:
                    System.out.println("Fatura id giriniz: ");
                    Integer id = Integer.parseInt(in.nextLine());
                    System.out.println("Satici adi giriniz: ");
                    String vendorName = in.nextLine();
                    System.out.println("Satilan aracin seri numarasini giriniz: ");
                    Integer carSerialNumber = Integer.parseInt(in.nextLine());

                    server.addReceipt(new Receipt(id, vendorName, carSerialNumber));

                    System.out.println("Fatura eklendi!");

                    break;
                case 3:
                    System.out.println("Arac seri numarasi giriniz: ");
                    Integer carSerialNumberToFind = Integer.parseInt(in.nextLine());

                    System.out.println(server.getCar(carSerialNumberToFind));

                    break;
                case 4:
                    System.out.println("Arac marka giriniz: ");
                    String carBrandToFind = in.nextLine();

                    System.out.println(server.getCar(carBrandToFind));

                    break;
                case 5:
                    System.out.println("Fatura ID giriniz: ");
                    Integer receiptIdToFind = Integer.parseInt(in.nextLine());

                    System.out.println(server.getReceipt(receiptIdToFind));

                    break;
                case 6:
                    System.out.println("Fatura satici adi giriniz: ");
                    String vendorNameToFind = in.nextLine();

                    System.out.println(server.getReceipt(vendorNameToFind));

                    break;
                case 0:
                    System.out.println("Cikis yapildi!");
                    System.exit(0);

                    break;
            }
        }
    }
}
