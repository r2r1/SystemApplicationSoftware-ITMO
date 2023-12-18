/*
Козлик понемногу развеселился, а к вечеру по ночлежке разнесся слух, что завтра ожидается приезд известного богача Скуперфильда,
который будет набирать рабочих для своей макаронной фабрики. Все обитатели дрянингского "Тупичка" обрадовались.
Многие из них уже давно потеряли надежду получить постоянную работу на фабрике.
Ходили слухи, что Скуперфильд решил увеличить выпуск макаронных изделий, и поэтому ему понадобитесь больше рабочих,
а так как было известно, что по количеству безработных Сан-Комарик стоит на первом месте, то он и решил приехать сюда.
Никто не знал, откуда в ночлежку проникли такие сведения, но известно, что на следующий день Скуперфильд действительно появился в Сан-Комарике.
Вместе с ним появились сто двадцать семь больших автофургонов, служивших для перевозки макаронных изделий.
Теперь эти фургоны должны были перевезти завербованных Скуперфильдом рабочих на макаронную фабрику в Брехенвиль.
 */

import enumeration.Place;
import object.*;

public class Main {
    public static void main(String[] args) {
        Goat goat = new Goat(); // Козел

        Residents residents = new Residents(); // Жители
        Scuperfild scuperfild = new Scuperfild(); // Скуперфильд

        String sanKomaric = Place.SAN_KOMARIK.toString(); // Сан-Комарик
        String flophouse = Place.FLOPHOUSE.toString(); // Тупичок
        String pastaFactory = Place.PASTA_FACTORY.toString();// Макаронная фабрика
        String brehenvile = Place.BREHENVILE.toString(); // Брехевиль
        String noPlace = "";
        Truck truck = new Truck(127); //127 фургонов

        // состояния персонажей
        String happy = "радость";
        String loss = "потеря надежды получить постоянную работу";

        // Добавим козлику радость
        goat.inCondition(noPlace , happy  );

        // Создадим события, которые должен совершить Скуперфильд
        String event1 = scuperfild.arriveInFuture( sanKomaric);
        String event2 = scuperfild.selectWorkersEvent(" на " + pastaFactory);

        // Обратимся к жителями "Тупичка" и методу "пустить слух", чтобы эти жители ночлежки пустили слух о Скупервильде
        residents.tellRumor( flophouse ,  event1 + " и будет проводить " + event2);

        // Обратимся к состоянию жителей Тупичка и всего города Сан-Комарика и их единому методу "испытать состояние"
        residents.inCondition( flophouse ,  happy);
        residents.inCondition( sanKomaric ,  loss);

        // Обратимся к методу Скуперфильда, где он уже приезжает куда-то, в данном случае в Сан-Комарик
        scuperfild.arriveInCity(sanKomaric);

        // Приезд фургонов в город Сан-Комарик
        truck.vanCome(sanKomaric);

        // Рабочие
        String worker = residents.worker();
        //Обратимся к методу Скуперфильда, где он набирает жителей города Сан-Комарик и вербует их в рабочих
        scuperfild.selectWorkers(worker, sanKomaric );

        // Фургоны уехали на Макаронную фабрику в Брехенвиль
        truck.vanLeave( pastaFactory, brehenvile);

    }



}
