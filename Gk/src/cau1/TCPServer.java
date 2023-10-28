/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau1;

/**
 *
 * @author thanh
 */
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running...");
            Socket clientSocket = serverSocket.accept();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            String inputLine;
            
            while ((inputLine = in.readLine()) != null) {
                int n = Integer.parseInt(inputLine);
                int oddCount = 0;
                int evenCount = 0;
                
                while (n > 0) {
                    int digit = n % 10;
                    if (digit % 2 == 0) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                    n /= 10;
                }
                
                out.println(oddCount + " " + evenCount);
            }
            
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
