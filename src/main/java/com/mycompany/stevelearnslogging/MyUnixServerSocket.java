/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stevelearnslogging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.Socket;
import org.newsclub.net.unix.AFUNIXServerSocket;
import org.newsclub.net.unix.AFUNIXSocketAddress;

/**
 *
 * @author steve
 */
public class MyUnixServerSocket {
    public static void main(String[] args) throws Exception{
        
        
        String path = "/home/steve/NetBeansProjects/Log4j-Unix-socket-appender-for-JSON/src/main/java/com/mycompany/stevelearnslogging/jsonFile.json";
        
        
        final File socketFile = new File(new File(System
                .getProperty("java.io.tmpdir")), "junixsocket-test.sock");

        AFUNIXServerSocket server = AFUNIXServerSocket.newInstance();
        server.bind(new AFUNIXSocketAddress(socketFile));
        System.out.println("server: " + server);

        Socket sock = server.accept();
        System.out.println("Connected: " + sock);

        InputStreamReader reader = new InputStreamReader(sock.getInputStream());
        BufferedReader buffReader = new BufferedReader(reader);
        
        String message = buffReader.readLine();   
        System.out.println("this is the message:" +message);
        FileWriter fw = new FileWriter(path,true);    
        if(message!=null) fw.write(message+"\n");        
        fw.close();
    }
}
