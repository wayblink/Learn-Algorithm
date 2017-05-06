package com.way.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server=null;
        
        server=new ServerSocket(4700);

        Socket socket=null;
        
        socket=server.accept();
        
        BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
        
        BufferedReader is =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        PrintWriter os=new PrintWriter(socket.getOutputStream());
        
        String readline;
        
        readline=sin.readLine();
        
        while(!readline.equals("bye")){
            os.println(readline);
            
            os.flush();
            
            System.out.println("Client:"+readline);
            
            System.out.println("Server:"+is.readLine());
            
            readline=sin.readLine();
        }
        os.close();
        is.close();
        socket.close();
        
    }

}
