package com.shvydkov.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentUser {

    String name;
    String surname;
    String department;

    @Override
    public String toString() {
        return name + " " + surname + " " + department + "\n";
    }
}
