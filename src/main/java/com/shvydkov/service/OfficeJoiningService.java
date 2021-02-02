package com.shvydkov.service;

import com.shvydkov.deserializer.EntityDeserializer;
import com.shvydkov.deserializer.OfficeEntityDeserializer;
import com.shvydkov.domain.Department;
import com.shvydkov.domain.DepartmentUser;
import com.shvydkov.domain.User;
import com.shvydkov.service.joiner.EntitiesJoiner;
import com.shvydkov.service.joiner.OfficeEntitiesJoiner;
import com.shvydkov.utils.DomainUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor
public class OfficeJoiningService {

    private static final EntityDeserializer deserializer = new OfficeEntityDeserializer();
    private static final EntitiesJoiner<User, Department, DepartmentUser> joiner = new OfficeEntitiesJoiner();

    public static void performJoin() throws FileNotFoundException {
        final List<User> users = DeserializationService.deserializeUsers(deserializer);
        final List<Department> deps = DeserializationService.deserializeDepartments(deserializer);

        List<DepartmentUser> departmentUsers =
                OfficeJoiningService.joinAllEntities(users, DomainUtils.prepareDepartments(deps));

        printJoinedEntities(departmentUsers);
    }

    private static List<DepartmentUser> joinAllEntities(List<User> users, HashMap<String, Department> departmentHashMap) {
        return users
                .stream()
                .filter(x->x.getDepartmentId()!=null)
                .map(x -> joiner.performJoin(x, departmentHashMap.get(x.getDepartmentId())))
                .collect(Collectors.toList());
    }

    private static void printJoinedEntities(List<DepartmentUser> departmentUsers){
        System.out.println(Arrays.toString(departmentUsers.toArray()));
    }
}
