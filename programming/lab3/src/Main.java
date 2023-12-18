import object.Goat;
import object.Residents;
import object.SanKonaric;
import object.Scuperfild;

public class Main {
    public static void main(String[] args) {
        Goat goat = new Goat();
        Residents residents = new Residents();
        Scuperfild scuperfild = new Scuperfild();
        SanKonaric sanKonaric = new SanKonaric();

        goat.inCondition( "радость"  );

        String event1 = scuperfild.visitToSity("приезд Скуперфильда");
        String event2 = scuperfild.selectWorkers("отбор рабочих на макаронную фабрику");

        residents.tellRumor(event1 + " и " + event2);
        residents.inCondition("радость");
        residents.inCondition("потеря надежды получить постоянную работу на фабрике ");
        scuperfild.visitToSity("приезжает в город");
        sanKonaric.setSityName("Сан-комарик");
        }
    }
