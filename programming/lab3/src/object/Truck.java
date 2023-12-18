package object;

import java.util.Objects;

public class Truck {
    int quantity;

    public Truck(int quantity) {
        this.quantity = quantity;
    }

    public void vanCome(String place){
        System.out.println(quantity + " фургонов приехали в " + place);
    }
    public void vanLeave(String place, String comingCity){
        System.out.println(quantity + " фургонов уехали на "  + place + " " + "в "  + comingCity );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck van = (Truck) o;
        return quantity == van.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
