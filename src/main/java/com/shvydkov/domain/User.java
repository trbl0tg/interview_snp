package com.shvydkov.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

@Data
@CsvDataType
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @CsvField(pos = 1)
    String id;

    @CsvField(pos = 2)
    String   name;

    @CsvField(pos = 3)
    String surname;

    @CsvField(pos = 4)
    String departmentId;
}
