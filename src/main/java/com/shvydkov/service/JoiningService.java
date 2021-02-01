package com.shvydkov.service;

import com.shvydkov.domain.Department;
import com.shvydkov.domain.DepartmentUser;
import com.shvydkov.domain.User;
import com.shvydkov.service.joiner.EntitiesJoiner;
import com.shvydkov.service.joiner.OfficeEntitiesJoiner;
import com.shvydkov.utils.DomainUtils;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningService {
    public static void performJoin() throws FileNotFoundException {
        final List<User> users = DeserializationService.deserializeUsers();
        final List<Department> deps = DeserializationService.deserializeDepartments();

        List<DepartmentUser> departmentUsers =
                JoiningService.joinAllEntities(users, DomainUtils.prepareDepartments(deps));

        printJoinedEntities(departmentUsers);
    }

    public static List<DepartmentUser> joinAllEntities(List<User> users, HashMap<String, Department> departmentHashMap) {
        final EntitiesJoiner<User, Department, DepartmentUser> entityJoiner = new OfficeEntitiesJoiner();
        return users
                .stream()
                .filter(x->x.getDepartmentId()!=null)
                .map(x -> entityJoiner.performJoin(x, departmentHashMap.get(x.getDepartmentId())))
                .collect(Collectors.toList());
    }

    public static void printJoinedEntities(List<DepartmentUser> departmentUsers){
        System.out.println(Arrays.toString(departmentUsers.toArray()));
    }
}
