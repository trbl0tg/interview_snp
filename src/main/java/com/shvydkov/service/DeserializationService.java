package com.shvydkov.service;

import com.shvydkov.deserializer.EntityDeserializer;
import com.shvydkov.domain.Department;
import com.shvydkov.domain.User;

import java.io.FileNotFoundException;
import java.util.List;

public class DeserializationService {

    private final static String USERS_TABLE = "users.csv";
    private final static String DEPARTMENTS_TABLE = "departments.csv";

    public static List<User> deserializeUsers(EntityDeserializer deserializer) throws FileNotFoundException {
        return deserializer.deserialize(USERS_TABLE, User.class);
    }

    public static List<Department> deserializeDepartments(EntityDeserializer deserializer) throws FileNotFoundException {
         return deserializer.deserialize(DEPARTMENTS_TABLE, Department.class);
    }
}
