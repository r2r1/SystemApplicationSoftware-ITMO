package object;

import abstractClass.Hero;
import interfaces.PersonalConditionInterface;
import interfaces.RumorInterface;


public class Residents extends Hero implements PersonalConditionInterface, RumorInterface {

    @Override
    public boolean fantasticHero(String name) {
        return true;
    }

    // метод который выводит состояние жителей какого-то места
    public  void inCondition(String residentsPlace , String condition) {

        System.out.println("Жители "+ residentsPlace + " испытывают " + condition);
    }

    public void tellRumor(String residentsPlace, String event) {
        System.out.println("Жители " + residentsPlace +  " пустили слух о том, что " + event );
    }
    public String worker(){

        return "рабочие";
    }
}
