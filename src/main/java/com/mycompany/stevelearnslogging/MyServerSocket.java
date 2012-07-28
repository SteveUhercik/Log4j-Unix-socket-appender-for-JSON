/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stevelearnslogging;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Stefan
 */
public class MyServerSocket {
    
    public static void main(String[] args) throws Exception{
        MyServerSocket myServerSocket = new MyServerSocket();
        myServerSocket.run();
    }
    
    public void run() throws Exception{   
        //String path = "C:\\Users\\Stefan\\Desktop\\Eclipse\\JsonProjects\\SteveLearnsLogging\\src\\main\\java\\com\\mycompany\\stevelearnslogging\\jsonFile.json";
        String path = "/home/steve/NetBeansProjects/Log4j-Unix-socket-appender-for-JSON/src/main/java/com/mycompany/stevelearnslogging/jsonFile.json";
        
        ServerSocket servSocket = new ServerSocket(5001);
        Socket socket = servSocket.accept();
        
        InputStreamReader iSReader = new InputStreamReader(socket.getInputStream());
        BufferedReader buffReader = new BufferedReader(iSReader);
       
        String message = buffReader.readLine();        
        FileWriter fw = new FileWriter(path,true);    
        if(message!=null) fw.write(message+"\n");        
        fw.close();
        
    }
    
}
