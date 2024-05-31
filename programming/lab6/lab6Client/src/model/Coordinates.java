package model;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private float x; //Значение поля должно быть больше -194, Поле не может быть null
    private float y; //Значение поля должно быть больше -854

    public Coordinates(long x, Integer y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates(){

    }

    public float getX() {
        return x;
    }


    public float getY() {
        return y;
    }

}