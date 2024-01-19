package object;

import abstractClass.Hero;
import interfaces.HeroPhraseInterface;

public class Neznayka extends Hero {
    public Neznayka(String name) {
        this.name = name;
    };
    String name;
    @Override
    public String fantasticHero() {
        return "Фантастический герой " + name;
    }

    //Анонимный класс: Незнайка говорит фразу
    public HeroPhraseInterface HeroPhrase = new HeroPhraseInterface() {
        @Override
        public void said(String hero, String Phrase) {
            System.out.println(hero + " сказал: " + Phrase);
        }
    };
}
