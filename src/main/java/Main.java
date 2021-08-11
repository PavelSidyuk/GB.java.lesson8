import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class Main {

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



        File file = new File("C:\\sandbox");

        if (!file.exists()){
            System.out.println("Фаил не существует");
            if (file.mkdirs()){
                System.out.println("Директория создана");
            }
            else {
                System.out.println("Директория не создана");
            }
        }
        else {
            System.out.println("Директория уже существует");
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\sandbox\\DZ_File1.txt");
            byte [] buf =str1.getBytes();

            fileOutputStream.write(buf);
            fileOutputStream.close();



        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            FileOutputStream fileOutputStream01 = new FileOutputStream("C:\\sandbox\\DZ_File2.txt");
            byte [] buf2 =str2.getBytes();

            fileOutputStream01.write(buf2);
            fileOutputStream01.close();



        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public static void Gluing( String s1, String s2){

        String str3= "";
        try {

            FileOutputStream fileOutputStream02 = new FileOutputStream("C:\\sandbox\\DZ_File3.txt");
            str3 = s1.concat(s2);
            byte [] buf3 =str3.getBytes();

            fileOutputStream02.write(buf3);
            fileOutputStream02.close();



        }catch (Exception e){
            System.out.println(e.getMessage());
        }







    }



}
