package com.shvydkov.stub;

import com.shvydkov.deserializer.EntityDeserializer;
import net.sf.jsefa.Deserializer;
import net.sf.jsefa.csv.CsvIOFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StubEntityDeserializer implements EntityDeserializer {
    @Override
    public <T> List<T> deserialize(String filename, Class<T> typeOf) throws FileNotFoundException {
        final Deserializer deserializer = CsvIOFactory.createFactory(typeOf).createDeserializer();
        final ArrayList<T> deserializeObjectsList = new ArrayList<>();
        deserializer.open(new FileReader(TEST_RECOURSE_PATH + filename));
        deserializer.next(); // skip column names row
        while (deserializer.hasNext()) {
            deserializeObjectsList.add(deserializer.next());
        }
        return deserializeObjectsList;
    }
}
