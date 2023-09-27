package com.universe.demo.mapper;


import com.universe.demo.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Person2Mapper {

    @Select("select * from t_person t where t.name = #{name}")
    List<Person> select(Person person);

    List<Person> selectAll();

    List<Person> selectByName(String name);

    List<Person> selectByName2(String name, String address);

    List<Person> selectByName3(String name);

    List<Person> selectByName4(String name, Person p, String address);

    List<Person> selectByName5(Person p);
}
