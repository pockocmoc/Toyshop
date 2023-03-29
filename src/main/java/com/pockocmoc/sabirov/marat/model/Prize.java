package com.pockocmoc.sabirov.marat.model;

//public class Prize {
//    private int id;
//    private Buyer buyer;
//    private Toy toy;
//
//    public Prize(int id, Buyer buyer, Toy toy) {
//        this.id = id;
//        this.buyer = buyer;
//        this.toy = toy;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Buyer getBuyer() {
//        return buyer;
//    }
//
//    public void setBuyer(Buyer buyer) {
//        this.buyer = buyer;
//    }
//
//    public Toy getToy() {
//        return toy;
//    }
//
//    public void setToy(Toy toy) {
//        this.toy = toy;
//    }
//
//    @Override
//    public String toString() {
//        return "Приз " +
//                "№ " + id +
//                ", " + buyer +
//                ", " + toy;
//    }

//}

public class Prize extends Toy {


    public Prize(int id, String name) {
        super(id, name);

    }

    @Override
    public String toString() {
        return "\nНомер: " + getId() + ","+ " Название: " + "\"" + getName() + "\"";
    }

}
