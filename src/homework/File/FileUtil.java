package homework.File;

import java.io.*;

public class FileUtil {

    public static void findLines(String txtPath, String keyword) {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(txtPath))) {
            String line = "";
            while ((line = inputStream.readLine()) != null) {
                if (inputStream.readLine().contains(keyword)) {
                    System.out.println(inputStream.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printSizeOfPackage(String path) {
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.err.println("File doesn't exist!");
        } else {
            System.out.println(file.length() / (2 * 1024));
        }
    }

    static void createFileWithContent(String path, String fileName, String content) {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            File file1 = new File(path, fileName);
            if (!file1.exists()) {
                try {
                    file1.createNewFile();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file1))) {
                        bw.write(content);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("File doesn't exist or is not directory.");
            }
        }
    }
}
