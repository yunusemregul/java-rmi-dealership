package com.kou.dagitiksistemler.shared;

import java.io.Serializable;

public class Receipt implements Serializable {
    public Integer id;
    public String vendorName;
    public Integer carSerialNumber;

    public Receipt(Integer id, String vendorName, Integer carSerialNumber) {
        this.id = id;
        this.vendorName = vendorName;
        this.carSerialNumber = carSerialNumber;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", vendorName='" + vendorName + '\'' +
                ", carSerialNumber=" + carSerialNumber +
                '}';
    }
}
