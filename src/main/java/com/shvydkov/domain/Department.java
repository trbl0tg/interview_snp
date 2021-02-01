package com.shvydkov.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@CsvDataType
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {

    @NotEmpty
    @NotNull
    @CsvField(pos = 1)
    String id;

    @CsvField(pos = 2)
    String   name;

}
