import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {


    public static void main(String args[]) {



        String inputFile = "src\\SampleFile.java";

        String s1="void main(string<>args[]) {  fghufguhfhufhufyhufufufufufufyufyufyufyu void main(string) {";



        Pattern pattern = Pattern.compile("[A-Za-z0-9]+ +[A-Za-z0-9]+\\([A-Za-z0-9, !\\[\\]\\)\\(_<>]+\\)\\W+\\{");
        Pattern pattern2 = Pattern.compile("[A-Za-z0-9]+ +[A-Za-z0-9]+\\([A-Za-z0-9, !\\[\\]\\)\\(_<>]+\\)\\{");

        int j= 0 ;
        try {
            Integer methodCounter = 0;
            BufferedReader r = new BufferedReader(new FileReader(inputFile));


            while (r.readLine()!=null) {

                String currentLine = r.readLine();

                Matcher matcher = pattern.matcher(currentLine);
                Matcher matcher2 = pattern2.matcher(currentLine);

                if(matcher.matches()||matcher2.matches()) {
                    methodCounter++;
                    System.out.println(methodCounter);
                }
               // System.out.println(j);
                System.out.println(r.readLine());
            }


            System.out.println(methodCounter);
        }
        catch(Exception e) {
            e.printStackTrace();
        }


//        for(int i=1; matcher.find();i++)
//            System.out.println("Token "+i+": " + matcher.group());


    }


}