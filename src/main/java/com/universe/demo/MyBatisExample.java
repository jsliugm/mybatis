package com.universe.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisExample {
    private final static SqlSessionFactory sqlSessionFactory;

    static {
        // 加载 MyBatis 配置文件
        InputStream inputStream = MyBatisExample.class.getResourceAsStream("/mybatis-config.xml");
        // 创建 SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void main(String[] args) {
        // 加载 MyBatis 配置文件
        InputStream inputStream = MyBatisExample.class.getResourceAsStream("/mybatis-config.xml");
        // 创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
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
}
