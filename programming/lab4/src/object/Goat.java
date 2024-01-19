package object;

import interfaces.PersonalConditionInterface;

public class Goat implements PersonalConditionInterface {
    public void inCondition(String residentsPlace, String condition) {
        System.out.println("Козлик испытал " + condition);
    }
}
