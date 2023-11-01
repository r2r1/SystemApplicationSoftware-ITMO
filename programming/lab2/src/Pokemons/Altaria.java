package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Altaria extends Swablu {
    public Altaria(String name, int level) {
        super(name, level);
        setType(Type.DRAGON, Type.FLYING);
        setStats(75, 70, 90, 70, 105, 80);
        setMove(new DragonBreath());
    }
}
