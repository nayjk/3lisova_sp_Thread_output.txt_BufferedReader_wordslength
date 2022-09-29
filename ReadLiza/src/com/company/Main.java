package com.company;

import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь к файлу с текстом");
        String filename = in.nextLine();
        File file = new File(filename);
        int words = 0;
        int length = (int) file.length();
        String text = "";

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            text += line;
        }
        words = text.split(" ").length;
        System.out.println("Количество слов: " + words);
        System.out.println("Количество символов: " + length);
        System.out.println("Количество символов без пробела: "+ text.replaceAll(" ","").length());

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){
            bw.write("Количество слов: "+words+"\n");
            bw.write("Количество символов: "+length+"\n");
            bw.write("Количество символов без пробела: "+text.replaceAll(" ","").length());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
