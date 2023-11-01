package Moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class DoubleHit extends PhysicalMove {
    public DoubleHit() {
        super(Type.NORMAL, 35, 90);
    }

    @Override
    public void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        super.applyOppEffects(p);
    }

    @Override
    protected String describe() {
        return "использовал атаку Double Hit и нанес двойной урон противнику ";

    }
}
