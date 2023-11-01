package Moves;

import ru.ifmo.se.pokemon.*;


public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.EVASION, +1);
    }

    @Override
    protected String describe() {
        return "повезло, покемон использует Double Team: увеличивает свою уклончивость на 1 и атакует";
    }

}
