import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TryCatchFinallyExamples {
    public static void main(String[] args) {

        try {
            BufferedImage image = ImageIO.read(new File("Lenna_(test_image).png"));
            System.out.println("Width = " + image.getWidth());
            System.out.println("Height = " + image.getHeight());
        } catch (IOException e) {
            System.out.println(e);
        }


        String email = "myemail@gmail.com\n";
        System.out.println(email);

        String regex = "[A-Za-z0-9]";

    }

    public static void randomExamplePNG() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("Lenna_(test_image).png", "r")) {

//            System.out.println(randomAccessFile.length());

            // должно быть 137 80 78 71 13 10 26 10 (исходя из оф. документации)

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < 8; i++) {
                list.add(randomAccessFile.readUnsignedByte());
            }

            for (int i = 0; i < 8; i++)
                System.out.print(list.get(i) + " ");
            System.out.println();

            for (int i = 0; i < 8; i++)
                System.out.print(Integer.toHexString(list.get(i)) + " ");
            System.out.println();

            for (int i = 0; i < 8; i++) {
                int tmp = list.get(i);
                char tmpChar = (char) tmp;
                System.out.print(tmpChar);
            }
            System.out.println();

            for (int i = 0; i < 4; i++) {
                System.out.print(Integer.toHexString(randomAccessFile.readUnsignedByte()) + " ");
            }
            System.out.println();

            System.out.print((char)randomAccessFile.readUnsignedByte()); // I
            System.out.print((char)randomAccessFile.readUnsignedByte()); // H
            System.out.print((char)randomAccessFile.readUnsignedByte()); // D
            System.out.print((char)randomAccessFile.readUnsignedByte()); // R

            System.out.println();

            // ihdr header
            int width = randomAccessFile.readInt();             // 4 byte  => int/float
            int height = randomAccessFile.readInt();            // 4 byte  => int/float
            int bitDepth = randomAccessFile.readUnsignedByte();          // 1 byte
            int colorType = randomAccessFile.readUnsignedByte();         // 1 byte
            int compressionMethod = randomAccessFile.readUnsignedByte(); // 1 byte
            int filterMethod = randomAccessFile.readUnsignedByte();      // 1 byte
            int interlaceMethod = randomAccessFile.readUnsignedByte();   // 1 byte

            System.out.println("width = " + width);
            System.out.println("height = " + height);
            System.out.println("bitDepth = " + bitDepth);
            System.out.println("colorType = " + colorType);
            System.out.println("compressionMethod = " + compressionMethod);
            System.out.println("filterMethod = " + filterMethod);
            System.out.println("interlaceMethod = " + interlaceMethod);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void exampleReadFIS() {
        try (FileInputStream fileInputStream = new FileInputStream("test.txt")) {
            int data = fileInputStream.read();

            while (data != -1) {
                System.out.print((char) data);
                data = fileInputStream.read();
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void compareTwoByteVsByte() {
        // посимвольное чтение
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test0.txt"))) {
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
            System.out.print((char)bufferedReader.read());
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println();

        // побайтовое чтение
        try (FileInputStream fileInputStream = new FileInputStream("test0.txt")) {
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.print((char)fileInputStream.read());
            System.out.println();
            System.out.println(fileInputStream.available());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void getCharInfo() {
        char a = 'q';
        char b = '\u1134';
        char c = 100;

        System.out.println((int) a);
        System.out.println(b);
        System.out.println(c);
        System.out.println((int)'q');
        System.out.println((int)'a');
        System.out.println('q' * 'a');
        System.out.println(Integer.toBinaryString(c));
        // 00000001 00101100 - 300
        // 00000000 01100100 - 100
    }

    public static void getScannerExample() {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static String example1() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        try {
            return br.readLine();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static String example2() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            return br.readLine();
        }
    }

    public static String example3() {
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            result = br.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }

        return result;
    }

    public static String example4() throws IOException {
        String result = "";
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        result = br.readLine();
        br.close();

        return result;
    }

    public static void modernWay() {

        //try-with-resources way
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
                FileWriter fileWriter = new FileWriter("test112.txt")
        ) {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void classicWay() {
        // try-catch-finally blocks
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("test.txt"));
            System.out.println(bufferedReader.readLine());

            fileWriter = new FileWriter("test2.txt");

        } catch (IOException e) {
            System.out.println("Error #1047 " + e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }

    }
}
