/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stevelearnslogging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import org.apache.log4j.net.SocketAppender;

/**
 *
 * @author Stefan
 */
public class MyClientSocket {
    public static void main(String[] args) throws IOException{
        MyClientSocket myClientSocket = new MyClientSocket();
        myClientSocket.run();
    }
    
    public void run() throws IOException{
        
        Socket socket = new Socket("localhost",5000);
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("client socket is greeting you");
        
        InputStreamReader iSReader = new InputStreamReader(socket.getInputStream());
        BufferedReader buffReader = new BufferedReader(iSReader);
        
        System.out.println("The message is: " +  buffReader.readLine());
        
    }
}
