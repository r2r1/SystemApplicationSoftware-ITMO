package Pokemons;

import Moves.Bite;
import Moves.DoubleHit;
import Moves.DragonRush;
import ru.ifmo.se.pokemon.Type;

public class Zweilous extends Deino {
    public Zweilous(String name, int level) {
        super(name, level);
        setType(Type.DRAGON, Type.DARK);
        setStats(72, 85, 70, 65, 70, 58);
        setMove(new DoubleHit());
    }
}
