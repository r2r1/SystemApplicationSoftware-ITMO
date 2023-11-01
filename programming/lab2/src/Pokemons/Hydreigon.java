package Pokemons;

import Moves.HyperVoice;
import ru.ifmo.se.pokemon.Type;

public class Hydreigon extends Zweilous {
    public Hydreigon(String name, int level) {
        super(name, level);
        setType(Type.DRAGON, Type.DARK);
        setStats(92, 105, 90, 125, 90, 98);
        setMove(new HyperVoice());
    }
}
