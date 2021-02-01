package com.shvydkov.service.joiner;

import com.shvydkov.domain.Department;
import com.shvydkov.domain.DepartmentUser;
import com.shvydkov.domain.User;

public class OfficeEntitiesJoiner implements EntitiesJoiner<User, Department, DepartmentUser> {
    @Override
    public DepartmentUser performJoin(User user, Department dep) {
        return new DepartmentUser(user.getName(), user.getSurname(), dep.getName());
    }

    @Override
    public void printJoin(User user, Department department) {
        if (user!=null && department!=null) {
            System.out.println(user.getName() + " " + user.getSurname() + " " + department.getName());
        }
    }
}
