package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Swablu extends Pokemon {
    public Swablu(String name, int level) {
        super(name, level);
        setType(Type.NORMAL, Type.FLYING);
        setStats(45, 40, 60, 40, 75, 50);
        setMove(new Refresh(), new Sing(), new DazzlingGleam());
    }
}
