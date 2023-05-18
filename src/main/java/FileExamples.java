import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileExamples {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // посмотреть файлы в директории, вариант 1
//        Arrays.stream(new File(".").list()).forEach(System.out::println);

        // посмотреть файлы в директории, вариант 1
//        File file = new File(".");
//        String[] l = file.list();
//        for (String s : l)
//            System.out.println(s);

        File file = new File("test.txt");
//        System.out.println(".isDirectory() = " + file.isDirectory());

//        boolean result = file.renameTo(new File("test2.txt"));
//        System.out.println(result);

//        System.out.println("Size of file = " + file.length() + " bytes");

        // дополнительный способ через java.nio.*
//        System.out.println(Files.readAllLines(Paths.get("test.txt")));


    }

    public static void exampleFileWriter() throws FileNotFoundException, IOException {
        FileWriter fileWriter = new FileWriter(new File("output.txt"), true);

        fileWriter.write("Hello qa_41. It's friday today");
        fileWriter.write("!!!");
        fileWriter.write("\n");

        fileWriter.close();
    }

    public static void exampleBufferedFileReader(File file) throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        // 1 способ прочитать все строчки в файле
//        String line = bufferedReader.readLine();
//        while (line != null) {
//            System.out.println(line);
//            line = bufferedReader.readLine();
//        }

        // 2 способ прочитать все строчки в файле
        System.out.println(bufferedReader.lines().toList());

        bufferedReader.close();
    }

    public static void exampleFileReader(File file) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(file);

        // 1 способ считывания файлов (наиболее универсальный способ)
//        int symbolInt = fileReader.read();
//        while (symbolInt != -1) {
//            System.out.print((char) symbolInt);
//            symbolInt = fileReader.read();
//        }

        // 2 способ, через массив
//        char[] array = new char[100];
//        fileReader.read(array);
//        System.out.println(array);

        fileReader.close();
    }

    public static void test(@NotNull File t) {
        Arrays.stream(t.list()).forEach(System.out::println);
    }
}
