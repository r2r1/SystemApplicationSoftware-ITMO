import static object.Residents.Workers.*;

import enumeration.Place;
import exception.StartStoryException;
import java.util.Scanner;
import object.*;

public class Story {
    public static void main(String[] args) throws StartStoryException {
        // Локальный класс в котором checked exception: исключение в тот момент,
        // когда соглашаемся с тем, чтобы почитать историю
        class StartStory {
            public void start() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Хочешь почитать историю? ( да \\ нет )");
                while (true) {
                    String massage = scanner.nextLine().toLowerCase();
                    if (massage.equals("да"))
                        try {
                            throw new StartStoryException("бл");
                        } catch (StartStoryException e) {
                            break;
                        }
                    System.out.println(
                            "Твоего мнения никто не спрашивает! Напиши: \"да\" !!!!");
                }
            }
        }

        Goat goat = new Goat(); // Козел
        Residents residents = new Residents(1000); // Жители
        Residents.Workers workers = new Residents.Workers(150); // Рабочие
        Scuperfild scuperfild = new Scuperfild(); // Скуперфильд
        Neznayka neznayka = new Neznayka("Незнайка"); // Незнайка

        int workersQuantity = getWorkersQuantity(); // Количество жителей

        String sanKomaric = Place.SAN_KOMARIK.toString(); // Сан-Комарик
        String flophouse = Place.FLOPHOUSE.toString(); // Тупичок
        String pastaFactory = Place.PASTA_FACTORY.toString(); // Макаронная фабрика
        String brehenvile = Place.BREHENVILE.toString(); // Брехевиль
        String street = Place.STREET.toString(); // Улица
        String alleyway = Place.ALLEYWAY.toString(); // Переулок

        String noPlace = "";
        Truck truck = new Truck(10); // Фургоны
        Truck.Seat seat = truck.new Seat();
        seat.sitOnSeat(workersQuantity);
        StartStory startStory = new StartStory();
        startStory.start();

        // состояния персонажей
        String happy = "радость";
        String loss = "потеря надежды получить постоянную работу";

        // Незнайка говорит фразу
        neznayka.HeroPhrase.said(neznayka.fantasticHero(),
                "Не беда! Я лично ничуточки не жалею, что не встречусь больше с этой противной Миногой. А работу какую-нибудь мы найдем. Не расстраивайся!");

        // Добавим козлику радость
        goat.inCondition(noPlace, happy);

        // Создадим события, которые должен совершить Скуперфильд
        String event1 = scuperfild.arriveInFuture(sanKomaric);
        String event2 = scuperfild.selectWorkersEvent(" на " + pastaFactory);

        // Обратимся к жителями "Тупичка" и методу "пустить слух", чтобы эти жители
        // ночлежки пустили слух о Скупервильде
        residents.tellRumor(flophouse, event1 + " и будет проводить " + event2);

        // Обратимся к состоянию жителей Тупичка и всего города Сан-Комарика и их
        // единому методу "испытать состояние"
        residents.inCondition(flophouse, happy);
        residents.inCondition(sanKomaric, loss);

        // Обратимся к методу Скуперфильда, где он уже приезжает куда-то, в данном
        // случае в Сан-Комарик
        scuperfild.arriveInCity(sanKomaric);

        // Приезд фургонов в город Сан-Комарик
        truck.come(sanKomaric);

        // Рабочие
        String worker = workers.toString();
        //Обратимся к методу Скуперфильда, где он набирает жителей города
        //Сан-Комарик и вербует их в рабочих
        scuperfild.selectWorkers(worker, sanKomaric);

        truck.in(truck.paintColor("оранжевый"), street);
        // Фургоны уехали на Макаронную фабрику в Брехенвиль
        truck.leave(pastaFactory, brehenvile);
    }
}
