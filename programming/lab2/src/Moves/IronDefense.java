package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class IronDefense extends StatusMove {
    public IronDefense() {
        super(Type.STEEL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, +2);
    }

    @Override
    protected String describe() {
        return "повезло, покемон использует Iron Defence: увеличивает свою защиту на 2  и атакует";
    }
}

