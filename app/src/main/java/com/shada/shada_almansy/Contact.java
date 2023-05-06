package com.shada.shada_almansy;

public class Contact {
    public String getName() {
        return Name;
    }


    public void setName(String name) {

        Name = name;
    }

    public int getPrice() {

        return Price;
    }

    public void setPrice(int price) {

        Price = price;
    }

    public String Name;
    public  int Price;
    public  int id;

    public Contact(String Name,int Price,int id){
        this.Name=Name;
        this.Price=Price;
        this.id=id;
    }

}
