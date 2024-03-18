package service.dataProviderService;

import model.SpaceMarine;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
public class JSONProvider implements DataProviderInterface{
    private final Path FILEPATH ;
    private final ObjectMapper mapper = new ObjectMapper();

    public JSONProvider(String filePath) {
        FILEPATH = Path.of(filePath);
    }


    @Override
    public void write(Collection<SpaceMarine> spaceMarines) {
        try {
            mapper.writeValue(FILEPATH.toFile(), spaceMarines);
        } catch (IOException e){
            System.out.println("Ошибка файла");
        }
    }
    @Override
    public Collection<SpaceMarine> parse() throws IOException {
        return mapper.readValue(FILEPATH.toFile(), new TypeReference<>() {});

    }
    public  static LinkedHashMap<Long, String> empty = new LinkedHashMap<>();
    public void  clear () throws IOException {
        empty.clear();
        mapper.writeValue(FILEPATH.toFile(), empty);
    }

}