package object;

import interfaces.PersonalCondition;

public class Goat implements PersonalCondition {

    String condition;

    public void inCondition(String condition) {
        System.out.println("Козлик испытывает " + condition);

    }

}
