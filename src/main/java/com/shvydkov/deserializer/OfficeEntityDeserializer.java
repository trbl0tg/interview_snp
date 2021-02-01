package com.shvydkov.deserializer;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.csv.CsvIOFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class OfficeEntityDeserializer implements EntityDeserializer {
    @Override
    public <T> List<T> deserialize(String filename, Class<T> typeOf) throws FileNotFoundException {
        final Deserializer deserializer = CsvIOFactory.createFactory(typeOf).createDeserializer();
        final ArrayList<T> deserializeObjectsList = new ArrayList<>();
        deserializer.open(new FileReader(filename));
        deserializer.next(); // skip column names row
        while (deserializer.hasNext()) {
            deserializeObjectsList.add(deserializer.next());
        }
        return deserializeObjectsList;
    }
}
