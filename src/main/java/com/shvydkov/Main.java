package com.shvydkov;

import com.shvydkov.domain.Department;
import com.shvydkov.domain.User;
import com.shvydkov.deserializer.EntityDeserializer;
import com.shvydkov.deserializer.OfficeEntityDeserializer;
import com.shvydkov.service.joiner.EntitiesJoiner;
import com.shvydkov.service.joiner.OfficeEntitiesJoiner;
import com.shvydkov.utils.DomainUtils;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        final EntityDeserializer deserializer = new OfficeEntityDeserializer();
        final EntitiesJoiner entityJoiner = new OfficeEntitiesJoiner();

        final List<User> users = deserializer.deserialize("table1.csv", User.class);
        final List<Department> departments = deserializer.deserialize("table2.csv", Department.class);

        final HashMap<String, Department> departmentMap = DomainUtils.prepareDepartments(departments);

        for (User user : users) {
            entityJoiner.printJoin(user, departmentMap.get(user.getDepartmentId()));
        }
    }


}
