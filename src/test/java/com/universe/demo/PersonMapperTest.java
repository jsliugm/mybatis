package com.universe.demo;

import com.universe.demo.mapper.Person2Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class PersonMapperTest {


    private final static SqlSessionFactory sqlSessionFactory;

    static {
        // 加载 MyBatis 配置文件
        InputStream inputStream = MyBatisExample.class.getResourceAsStream("/mybatis-config.xml");
        // 创建 SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void test() {
        // 创建 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 执行数据库操作
            Person person = new Person();
            person.setName("zhangsan");
            List list = sqlSession.selectList("com.universe.demo.PersonMapper.selectForSqlTest", person);
            System.out.println("");
            // ...
        }
    }

    @Test
    public void test2() {
        // 创建 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 执行数据库操作
            Person person = new Person();
            person.setName("zhangsan");
            Person2Mapper person2Mapper = sqlSession.getMapper(Person2Mapper.class);
            List list = person2Mapper.select(person);
            System.out.println("");
            // ...
        }
    }

    @Test
    public void test2_1() {
        // 创建 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Person2Mapper person2Mapper = sqlSession.getMapper(Person2Mapper.class);
            List list = person2Mapper.selectAll();
            System.out.println("");
            // ...
        }
    }

    @Test
    public void test2_2() {
        // 创建 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Person2Mapper person2Mapper = sqlSession.getMapper(Person2Mapper.class);
            List list = person2Mapper.selectByName("zhangsan");
            System.out.println("");
            // ...
        }
    }

    @Test
    public void test2_3() {
        // 创建 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Person2Mapper person2Mapper = sqlSession.getMapper(Person2Mapper.class);
            List list = person2Mapper.selectByName2("zhangsan", "shanghai");
            System.out.println("");
            // ...
        }
    }

    @Test
    public void test2_4() {
        // 创建 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Person2Mapper person2Mapper = sqlSession.getMapper(Person2Mapper.class);
            List list = person2Mapper.selectByName3("zhangsan");
            System.out.println("");
            // ...
        }
    }

    @Test
    public void testSelectByName4() {
        // 创建 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Person2Mapper person2Mapper = sqlSession.getMapper(Person2Mapper.class);
            List list = person2Mapper.selectByName4("zhangsan", new Person(), "shanghai");
            System.out.println(list);
            // ...
        }
    }

    @Test
    public void testSelectByName5() {
        // 创建 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Person2Mapper person2Mapper = sqlSession.getMapper(Person2Mapper.class);
            List list = person2Mapper.selectByName5(new Person("zhangsan", null));
            System.out.println(list);
            // ...
        }
    }
}
