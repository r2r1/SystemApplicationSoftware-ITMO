import Pokemons.*;
import ru.ifmo.se.pokemon.*;


public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();

        Corsola corsola = new Corsola("Corsola", 1);
        Swablu swablu = new Swablu("Swablu", 1);
        Altaria altaria = new Altaria("Altaria", 1);
        Deino deino = new Deino("Deino", 1);
        Zweilous zweilous = new Zweilous("Zweilous", 1);
        Hydreigon hydreigon = new Hydreigon("Hydreigon", 1);

        b.addAlly(corsola);
        b.addAlly(swablu);
        b.addAlly(altaria);

        b.addFoe(deino);
        b.addFoe(zweilous);
        b.addFoe(hydreigon);

        b.go();

    }
}
