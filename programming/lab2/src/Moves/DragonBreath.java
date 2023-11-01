package Moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class DragonBreath extends SpecialMove {
    public DragonBreath() {
        super(Type.DRAGON, 60, 100);
    }

    private boolean flag = false;

    public void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        final double CHANCE = 0.3;
        if (CHANCE > Math.random()) {
            flag = true;
            Effect.paralyze(p);
        }
    }

    @Override
    protected String describe() {
        return flag ? "повезло! Покемон использует атаку Dragon Breath и наносит урон, парализуя врага" :
                "использовал атаку Dragon Breath и нанес урон противнику ";

    }

}
