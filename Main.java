package com.assignment;

import  java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(ServerSocket ss = new ServerSocket(2000)) {
            Socket stk = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
            PrintStream ps = new PrintStream(stk.getOutputStream());

            String msg;
            StringBuilder sb;
            do {
                msg = br.readLine();
                System.out.println(msg);
                sb = new StringBuilder(msg);
                msg = sb.reverse().toString();
                ps.println(msg);
            } while (!msg.equals("dne"));
        }
    }
}

class Client {
    public static void main(String[] args) throws IOException {
        try(Socket stk = new Socket("localhost",2000)) {
            BufferedReader keyb = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
            PrintStream ps = new PrintStream(stk.getOutputStream());

            String msg;
            do {
                msg = keyb.readLine();
                ps.println(msg);
                msg = br.readLine();
                System.out.println("From Server: " + msg);
            } while (!msg.equals("dne"));
        }
    }
}

