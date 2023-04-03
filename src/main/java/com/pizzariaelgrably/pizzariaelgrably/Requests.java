package com.pizzariaelgrably.pizzariaelgrably;

public class Requests {
    private String clientName; // nome do cliente
    private String flavor; //sabor
    private String address; // endereço
    private String size; // tamanho
    private int amount; // endereço

    public Requests(String clientName, String address, String flavor,String size, int amount) {
        this.clientName = clientName;
        this.flavor = flavor;
        this.address = address;
        this.size = size;
        this.amount = amount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Requests{" +
                "clientName='" + clientName + '\'' +
                ", flavor='" + flavor + '\'' +
                ", address='" + address + '\'' +
                ", size='" + size + '\'' +
                ", amount=" + amount +
                '}';
    }
}
