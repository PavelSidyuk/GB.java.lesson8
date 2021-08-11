import java.io.*;
import java.util.Scanner;


public class Main02 {

    public static String str05 = "";

    public static void main (String[] args) {

        String str1 = " Meet my family. There are five of us – my parents, my elder brother,\n" +
                " my baby sister and me. First, meet my mum and dad, Jane and Michael.\n " +
                "My mum enjoys reading and my dad enjoys playing chess with my brother Ken.\n" +
                " My mum is slim and rather tall. She has long red hair and big brown eyes.\n" +
                " She has a very pleasant smile and a soft voice. My mother is very kind and understanding\n";

        String str2 = " We are real friends. She is a housewife. As she has three children,\n" +
                " she is always busy around the house. She takes care of my baby sister Meg,\n" +
                " who is only three months old. My sister is very small and funny. She sleeps,\n " +
                "eats and sometimes cries. We all help our mother and let her have a rest in the evening.\n" +
                " Then she usually reads a book or just watches TV. My father is a doctor. " +
                "He is tall and handsome. He has short dark hair and gray eyes. He is a very hardworking man.\n " +
                "He is rather strict with us, but always fair. ";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите искомое слово :");
        str05 = scanner.nextLine();
        File file = new File("C:\\sandbox01");

        if (!file.exists()) {
            System.out.println("Фаил не существует");
            if (file.mkdirs()) {
                System.out.println("Директория создана");
            } else {
                System.out.println("Директория не создана");
            }
        } else {
            System.out.println("Директория уже существует");
        }
        try {
            FileWriter fileWriter = new FileWriter("C:\\sandbox01\\GB.java.Text1.txt");
            fileWriter.write(str1);
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FileWriter fileWriter01 = new FileWriter("C:\\sandbox01\\GB.java.Text2.txt");
            fileWriter01.write(str2);
            fileWriter01.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Gluing01(str1, str2);
        Search(Gluing01(str1, str2));
        WordSearch(file);


    }

    public static String Gluing01 (String s1, String s2) {
        String str3 = "";

        try {

            FileWriter fileWriter02 = new FileWriter("C:\\sandbox01\\GB.java.Text3.txt");
            str3 = s1.concat(s2);
            fileWriter02.write(str3);
            fileWriter02.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return str3;
    }

    public static void Search (String s) {
        char[] buf = new char[5000];


        try {
            FileReader fileReader = new FileReader("C:\\sandbox01\\GB.java.Text3.txt");
            int i = -1;
            Scanner scanner = new Scanner(System.in);
            while ((i = fileReader.read(buf)) != -1) {
                String str04 = new String(buf, 0, i);

               // System.out.println("Введите искомое слово в файле");
                //String str05 = scanner.nextLine();
                if (str04.contains(str05)) {
                    System.out.println("Слово <" + str05 + "> существкет в тексте");
                } else {
                    System.out.println("Слово <" + str05 + "> не существкет в тексте");
                }
                System.out.println("==============================");
                for (int j = 0; j < i; j++) {
                    System.out.print(buf[j]);
                }
                System.out.println();
                System.out.println("********************************************");
            }


            fileReader.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void WordSearch (File dir) {
        // File file1 = new File("C:\\sandbox01");
        File[] files = dir.listFiles();
        char[] buf01 = new char[5000];
        int counter =0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                counter++;
                try {
                    FileReader fileReader = new FileReader(files[i]);
                    int a = -1;
                    Scanner scanner = new Scanner(System.in);
                    while ((a = fileReader.read(buf01)) != -1) {
                        String str04 = new String(buf01, 0, a);


                        //String str05 = scanner.nextLine();
                        if (str04.contains(str05)) {
                            System.out.println("Слово <" + str05 + "> существкет в файле №: " + counter);
                        } else {
                            System.out.println("Слово <" + str05 + "> не существкет в файле №:" + counter);
                        }
                        System.out.println("==============================");
                        for (int j = 0; j < a; j++) {
                            System.out.print(buf01[j]);
                        }
                        System.out.println();
                        System.out.println("********************************************");
                    }


                    fileReader.close();
                    scanner.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }


}


