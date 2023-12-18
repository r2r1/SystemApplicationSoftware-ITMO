package object;

import abstractClass.Hero;

public class Scuperfild extends Hero {

    @Override
    public boolean fantasticHero(String name) {
        return true;
    }
    public String selectWorkersEvent (String event){
        return  "отбор рабочих" + event;
    }
    public String arriveInFuture (String place){
        return  ("Скуперфильд приедет в " + place);
    };
    public void arriveInCity (String place){
        System.out.println("Скуперфильд приехал в " + place);
        };
    public void selectWorkers (String worker,String leavingPlace ){
        System.out.println("Скуперфильд отобрал жителей, теперь они завербованные "+ worker + " из " + leavingPlace);
    };






    }



