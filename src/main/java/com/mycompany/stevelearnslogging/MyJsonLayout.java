/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stevelearnslogging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

/**
 *
 * @author Stefan
 */
public class MyJsonLayout extends Layout {
    
    @Override
    public String format(LoggingEvent event) {
        StringWriter writer= new StringWriter();
        try{
            
            JsonFactory factory = new JsonFactory();
            JsonGenerator gen = factory.createJsonGenerator(writer);
            gen.writeStartObject();
            gen.writeStringField("level",event.getLevel().toString());
            gen.writeNumberField("time",event.getTimeStamp());
            gen.writeStringField("message",event.getRenderedMessage());
            gen.writeEndObject();
            gen.close();
            writer.append((CharSequence)"\n");
        }
        catch(Exception e){
            System.out.print("error");
        }
        return writer.toString();        
        
    }

    @Override
    public boolean ignoresThrowable() {
        return true;
    }

    public void activateOptions() {
        
    }
    
}
