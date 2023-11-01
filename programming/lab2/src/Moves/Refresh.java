package Moves;

import ru.ifmo.se.pokemon.*;

public class Refresh extends StatusMove {
    public Refresh() {
        super(Type.NORMAL, 0, 0);
    }


    @Override
    protected String describe() {
        return "использовал атаку Refresh и вылечился от паралича, отравления и ожогов ";

    }
}


