package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Corsola extends Pokemon {
    public Corsola(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.ROCK);
        setStats(65, 55, 95, 65, 95, 35);
        setMove(new Facade(), new DoubleTeam(), new IceBeam(), new IronDefense());
    }

}
