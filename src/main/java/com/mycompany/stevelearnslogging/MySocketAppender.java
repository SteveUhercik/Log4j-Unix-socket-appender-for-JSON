/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stevelearnslogging;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

/**
 *
 * @author Stefan
 */
public class MySocketAppender extends AppenderSkeleton {

    private Socket socket;
    private PrintStream ps;
    private String host;
    private int port;
    
    public MySocketAppender(String host,int port, Layout layout){
        this.host = host;
        this.port = port;
        this.layout = layout;
    }
    
    @Override
    protected void append(LoggingEvent event) {  
        try {
            socket = new Socket(host,port);
            ps = new PrintStream(socket.getOutputStream());
        } catch (Exception ex) {
            System.out.println("something went wrong");
        }            
        
        ps.println(this.layout.format(event));        
    }

    public void close() {
        
    }

    public boolean requiresLayout() {
        return false;
    }
    
}
