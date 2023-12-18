package object;

import interfaces.PersonalCondition;
import interfaces.PersonalCondition;
import interfaces.Rumor;


public class Residents implements PersonalCondition, Rumor {
    public  void inCondition(String condition) {
        System.out.println("Жители 'Тупичка' испытывают " + condition);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void tellRumor(String event) {
        System.out.println("Жители 'Тупичка' рассказали про "  + event );


    }
}
