package homework.File;

import java.io.File;
import java.util.Scanner;

public class FileUtilTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input path");
        String txtPath = scanner.nextLine();

        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();

        System.out.println("Please input file's name");
        String fileName = scanner.nextLine();

        System.out.println("Please write content");
        String content = scanner.nextLine();

        FileUtil.findLines(txtPath, keyword);
        FileUtil.printSizeOfPackage(txtPath);
        FileUtil.createFileWithContent(txtPath, fileName, content);




    }
}
