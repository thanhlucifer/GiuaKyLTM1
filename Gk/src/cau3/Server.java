/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau3;

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

            while (true) {
                Socket clientSocket = serverSocket.accept();

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

                int t = Integer.parseInt(inFromClient.readLine());

                while (t > 0) {
                    String s = inFromClient.readLine();

                    // Xử lý chuỗi theo yêu cầu của đề bài
                    StringBuilder result = new StringBuilder();
                    boolean isFirstChar = true;

                    for (char c : s.toCharArray()) {
                        if (Character.isLetter(c)) {
                            if (isFirstChar) {
                                result.append(Character.toUpperCase(c));
                                isFirstChar = false;
                            } else {
                                result.append(Character.toLowerCase(c));
                            }
                        } else if (c == ' ' && !isFirstChar) {
                            isFirstChar = true;
                            result.append(c);
                        }
                    }

                    // Gửi kết quả về client
                    outToClient.println(result.toString().trim());

                    t--;
                }

                // Đóng luồng đầu vào và đầu ra
                inFromClient.close();
                outToClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
