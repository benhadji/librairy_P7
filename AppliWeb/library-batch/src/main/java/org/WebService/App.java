package org.WebService;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        //Create the application context
        new ClassPathXmlApplicationContext("/bootstrapContext.xml");
    }
}
