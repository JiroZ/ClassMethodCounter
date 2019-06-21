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


            try {
                Integer methodCounter = 0;
                BufferedReader r = new BufferedReader(new FileReader(inputFile));

                String fileString = null, lineString = null;

                while (r.readLine() != null) {

                    lineString = r.readLine();

                    fileString += lineString;

                    System.out.println(lineString);
                }
                System.out.println(fileString);

                Matcher matcher = pattern.matcher(fileString);
                Matcher matcher2 = pattern2.matcher(fileString);
                for(int i=1; matcher.find();i++) {
                    System.out.println("Token " + i + ": " + matcher.group());
                    for(int j=1; matcher2.find();j++) {
                        System.out.println("Token2" + i + ": " + matcher2.group());
                        methodCounter++;
                    }
                methodCounter++;
                }
                System.out.println("There are " + methodCounter + " methods in the source file");
            }catch(Exception e) {
                e.printStackTrace();
            }






    }


}