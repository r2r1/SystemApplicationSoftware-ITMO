package Pokemons;

import Moves.Bite;
import Moves.DragonRush;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Deino extends Pokemon {
    public Deino(String name, int level) {
        super(name, level);
        setType(Type.DRAGON, Type.DARK);
        setStats(52, 65, 50, 45, 50, 38);
        setMove(new Bite(), new DragonRush());
    }
}
