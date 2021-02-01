package com.shvydkov.service.joiner;

public interface  EntitiesJoiner<T,P,R> {

    R performJoin(T a, P b);

    void printJoin(T a, P b);

}
