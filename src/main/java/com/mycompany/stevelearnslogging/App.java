package com.mycompany.stevelearnslogging;

import java.io.*;
import org.apache.log4j.*;
import org.apache.log4j.net.SocketAppender;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.xml.DOMConfigurator;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;


public class App 
{    
    public static void main( String[] args ) throws IOException
    {
        String path ="C:\\Users\\Stefan\\Desktop\\Eclipse\\JsonProjects\\SteveLearnsLogging\\src\\main\\java\\com\\mycompany\\stevelearnslogging\\jsonFile.json";
       
        BasicConfigurator.configure();
      
        MyJsonLayout layout = new MyJsonLayout();   
        
        //MySocketAppender appender = new MySocketAppender("localhost",5001,layout);
        MyUnixSocketAppender appender = new MyUnixSocketAppender(new File(new File(System.getProperty("java.io.tmpdir")), "junixsocket-test.sock"),layout);
        
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.addAppender(appender);
        rootLogger.fatal("message 2");     
        
    }
}
