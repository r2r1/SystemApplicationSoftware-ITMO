package Moves;

import ru.ifmo.se.pokemon.*;

public class IceBeam extends SpecialMove {
    public IceBeam() {
        super(Type.ICE, 90, 100);
    }

    private boolean flag = false;

    @Override
    public void applySelfEffects(Pokemon p) {
        super.applyOppEffects(p);
        final double CHANCE = 0.1;
        if (Math.random() < CHANCE) {
            flag = true;
            Effect.freeze(p);
        }
    }

    @Override
    protected String describe() {
        return flag ? "повезло! Покемон использует атаку Ice Beam нанося урон и замораживая противника" :
                "использует атаку Ice Beam и наносит урон"
                ;
    }
}