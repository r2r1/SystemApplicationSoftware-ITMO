package Moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class DragonRush extends PhysicalMove {
    public DragonRush() {
        super(Type.DRAGON, 100, 75);
    }

    private boolean flag = false;

    @Override
    public void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        final double CHANCE = 0.2;
        if (CHANCE > Math.random()) {
            flag = true;
            Effect.flinch(p);
        }
    }

    @Override
    protected String describe() {
        return flag ? "использовал атаку Dragon Rush и нанес урон противнику, испугав его" :
                "использовал атаку Dragon Rush и нанес урон противнику";
    }
}
