/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau4;

/**
 *
 * @author thanh
 */
import java.io.*;
import static java.lang.System.out;
import java.net.*;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running and waiting for connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            int n = Integer.parseInt(in.readLine());
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(in.readLine());
            }

            int k = Integer.parseInt(in.readLine());

            StringBuilder result = new StringBuilder();

            for (int i = k; i < n; i++) {
                result.append(a[i]).append("\t");
            }

            for (int i = 0; i < k; i++) {
                result.append(a[i]).append("\t");
            }

            out.println(result.toString());

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

