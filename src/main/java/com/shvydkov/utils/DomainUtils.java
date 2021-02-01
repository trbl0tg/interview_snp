package com.shvydkov.utils;

import com.shvydkov.domain.Department;

import java.util.HashMap;
import java.util.List;

public class DomainUtils {
    public static HashMap<String, Department> prepareDepartments(List<Department> departments) {
        final HashMap<String, Department> departmentsMap = new HashMap<>();
        for (Department department : departments) {
            departmentsMap.put(department.getId(), department);
        }
        return departmentsMap;
    }
}
