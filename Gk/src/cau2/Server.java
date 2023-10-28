/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

/**
 *
 * @author thanh
 */
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
            int n = Integer.parseInt(in.readLine());
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(in.readLine());
            }

            int min1 = a[0];
            int max = a[0];

            for (int i = 1; i < n; i++) {
                if (a[i] < min1) min1 = a[i];
                if (a[i] > max) max = a[i];
            }

            int min2 = max;

            for (int i = 0; i < n; i++) {
                if (a[i] == min1) continue;
                if (a[i] < min2) min2 = a[i];
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(min1 + "\t và" + min2);

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

