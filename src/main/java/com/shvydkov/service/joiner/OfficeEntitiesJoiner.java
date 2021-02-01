package com.shvydkov.service.joiner;

import com.shvydkov.domain.Department;
import com.shvydkov.domain.User;

public class OfficeEntitiesJoiner implements EntitiesJoiner<User, Department> {
    @Override
    public void printJoin(User user, Department department) {
        if (user!=null && department!=null) {
            System.out.println(user.getName() + " " + user.getSurname() + " " + department.getName());
        }
    }
}
