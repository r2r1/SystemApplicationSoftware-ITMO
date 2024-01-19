package object;

import abstractClass.Hero;
import exception.MyRuntimeException;
import interfaces.PersonalConditionInterface;
import interfaces.RumorInterface;

public class Residents implements PersonalConditionInterface, RumorInterface {
    static int residentsQuantity;

    public Residents(int residentsQuantity) {
        Residents.residentsQuantity = residentsQuantity;
    }

    // вложенный класс рабочих
    public static class Workers {
        private static int workersQuantity;

        // checked exception: проверка на то, что рабочих меньше, чем жителей
        public Workers(int workersQuantity) {
            if (workersQuantity > residentsQuantity) {
                throw new MyRuntimeException(
                        "Рабочих не может быть больше, чем жителей. Рабочих: " + workersQuantity + ", Жителей: " + residentsQuantity);
            }
            Workers.workersQuantity = workersQuantity;
        }

        public static int getWorkersQuantity() {
            return workersQuantity;
        }
    }

    // метод который выводит состояние жителей какого-то места
    public void inCondition(String residentsPlace, String condition) {
        System.out.println("Жители " + residentsPlace + " испытывают " + condition);
    }

    public void tellRumor(String residentsPlace, String event) {
        System.out.println("Жители " + residentsPlace + " пустили слух о том, что " + event);
    }
}
