package Moves;

import ru.ifmo.se.pokemon.*;

public class Bite extends SpecialMove {
    public Bite() {
        super(Type.FAIRY, 60, 100);
    }

    private boolean flag = false;

    @Override
    public void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        final double CHANCE = 0.3;
        if (CHANCE > Math.random()) {
            flag = true;
            Effect.flinch(p);
        }
    }

    @Override
    protected String describe() {
        return flag ? "использовал атаку Bite и нанес урон противнику, испугав его" :
                "использовал атаку Bite и нанес урон противнику";
    }
}
