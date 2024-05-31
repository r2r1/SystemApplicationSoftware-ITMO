package service.dataProviderService;

import model.SpaceMarine;


import java.io.IOException;
import java.util.Collection;

public interface DataProviderInterface {
    void write(Collection<SpaceMarine> spaceMarine) throws IOException;
    Collection<SpaceMarine> parse() throws IOException;


}
