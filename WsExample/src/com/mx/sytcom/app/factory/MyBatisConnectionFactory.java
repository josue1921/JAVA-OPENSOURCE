package com.mx.sytcom.app.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	public MyBatisConnectionFactory()
    {
    }
	
	public static SqlSessionFactory getSqlSessionFactory()
    {
        return sqlSessionFactory;
    }

    private static SqlSessionFactory sqlSessionFactory;
    
    static 
    {
        try
        {
            java.io.Reader reader = Resources.getResourceAsReader("com/mx/sytcom/app/resources/mybatis-config.xml");
            sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(reader);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
        catch(IOException iOException)
        {
            iOException.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
