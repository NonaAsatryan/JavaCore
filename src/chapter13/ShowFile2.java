package chapter13;

import java.io.*;

public class ShowFile2 {

    public static void main(String[] args) {
        int i;

        if (args.length != 1) {
            System.out.println("Usage: ShowFile2 filename");
            return;
        }
        try (FileInputStream fin = new FileInputStream(args[0])){
            do {
                i = fin.read();
                if (i != -1);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("An I/O Error occurred");
        }
    }
}
