package object;

import exception.MyRuntimeException;
import java.util.Objects;

public class Truck {
    int quantity;

    public Truck(int quantity) {
        this.quantity = quantity;
    }

    public void come(String place) {
        System.out.println(quantity + " фургонов приехали в " + place);
    }
    public void leave(String place, String comingCity) {
        System.out.println(quantity + " фургонов уехали на " + place + " "
                + "в " + comingCity);
    }
    public void in(String a, String place) {
        System.out.println(a + " находятся в " + place);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Truck van = (Truck) o;
        return quantity == van.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    public String paintColor(String color) {
        return "Фургоны, раскрашенные в " + color + " цвет,";
    }

    public class Seat {
        public void sitOnSeat(int passengersQuantity) {
            int seatQuantity = 24;
            if (passengersQuantity > quantity * seatQuantity) {
                throw new MyRuntimeException(
                        "Пассажиров не может быть больше, чем мест." +
                                " Пассажиров: " + passengersQuantity +
                                ", мест в " + quantity + " фургонах : " + quantity * seatQuantity);
            }
            System.out.println("Рабочие расселись и поехаил на завод");
        }
    }
}
