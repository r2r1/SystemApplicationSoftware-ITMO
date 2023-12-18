package enumeration;
import java.util.Objects;


public enum Place {
    SAN_KOMARIK ("город" , "Сан-Комарик"),
    FLOPHOUSE ("ночлежка" , "Тупичок"),
    PASTA_FACTORY("фабрика" , "Макаронная"),
    BREHENVILE("город" , "Брехенвиль"),
    ;

    final  String name;
    final   String type;
    Place(String type, String name) {
        this.type = type;
        this.name = name;
    }


    @Override
    public String toString() {
        return  type + ' ' + name ;
    }
}
