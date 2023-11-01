package Moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class DazzlingGleam extends SpecialMove {
    public DazzlingGleam() {
        super(Type.FAIRY, 80, 100);
    }

    @Override
    public void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
    }

    @Override
    protected String describe() {
        return "использовал атаку Dazzling Gleam и нанес урон противнику ";

    }

}
