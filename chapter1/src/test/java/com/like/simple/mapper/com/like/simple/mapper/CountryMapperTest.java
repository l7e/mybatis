package com.like.simple.mapper.com.like.simple.mapper;

import com.like.simple.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest
{
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init()
    {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() throws IOException
    {
        System.out.println(sqlSessionFactory.openSession());
        SqlSession openSession = sqlSessionFactory.openSession();
        List<Country> list = openSession.selectList("selectAll");

        openSession.close();
        System.out.println(list);
    }
}
