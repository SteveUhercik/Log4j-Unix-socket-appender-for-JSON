/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stevelearnslogging;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.newsclub.net.unix.AFUNIXSocket;
import org.newsclub.net.unix.AFUNIXSocketAddress;
import org.newsclub.net.unix.AFUNIXSocketException;

/**
 *
 * @author Stefan
 */
public class MySocketAppender extends AppenderSkeleton {

    private Socket socket;
    private PrintStream ps;
    private String host;
    private int port;
    
    public MySocketAppender(String host, int port, Layout layout) {
        this.host = host;
        this.port = port;
        this.layout = layout;
        
        try {
            socket = new Socket(host,port);
            ps = new PrintStream(socket.getOutputStream());
        } catch (Exception ex) {
            System.out.println("something went wrong");
        }      
        
    }
    
    @Override
    protected void append(LoggingEvent event) {  
              
        
        ps.println(this.layout.format(event));        
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("problem while closing");
        }
        ps.close();
    }

    public boolean requiresLayout() {
        return false;
    }
    
}
