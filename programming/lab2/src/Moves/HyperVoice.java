package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class HyperVoice extends SpecialMove {
    public HyperVoice() {
        super(Type.NORMAL, 90, 100);
    }

    public void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
    }

    @Override
    protected String describe() {
        return "использовал атаку HyperVoice и нанес урон противнику ";

    }
}
