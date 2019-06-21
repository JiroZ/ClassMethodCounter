import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {


    public static void main(String[] Args) {


        String inputFile = "src\\SampleFile.java";

        Pattern pattern = Pattern.compile("[A-Za-z0-9]+ +[A-Za-z0-9]+\\([A-Za-z0-9, !\\[\\]\\)\\(_<>]+\\)\\W+\\{");
        Pattern pattern2 = Pattern.compile("[A-Za-z0-9]+ +[A-Za-z0-9]+\\([A-Za-z0-9, !\\[\\]\\)\\(_<>]+\\)\\{");
        Pattern pattern3 = Pattern.compile("[A-Za-z0-9]+ +[A-Za-z0-9]+\\(\\)\\W+\\{");
        Pattern pattern4 = Pattern.compile("[A-Za-z0-9]+ +[A-Za-z0-9]+\\(\\)\\{");
        Pattern classPattern = Pattern.compile("[A-Za-z0-9]+ +class +[A-Za-z0-9]+ +\\{");
        Pattern classPattern2 = Pattern.compile("[A-Za-z0-9]+ +class +[A-Za-z0-9]+\\{");


        try {
            Integer methodCounter = 0;
            Integer classCounter = 0;
            BufferedReader r = new BufferedReader(new FileReader(inputFile));

            String fileString = null, lineString = null;

            while (r.readLine() != null) {

                lineString = r.readLine();

                fileString += lineString;

            }
           // System.out.println(fileString);

            Matcher matcher = pattern.matcher(fileString);
            Matcher matcher2 = pattern2.matcher(fileString);
            Matcher matcher3 = pattern3.matcher(fileString);
            Matcher matcher4 = pattern4.matcher(fileString);
            Matcher classMatcher = classPattern.matcher(fileString);
            Matcher classMatcher2 = classPattern2.matcher(fileString);

            for (int i = 1; matcher.find(); i++) {
                System.out.println("Token1 " + i + ": " + matcher.group());
                for (int j = 1; matcher2.find(); j++) {
                    System.out.println("Token2 " + i + ": " + matcher2.group());
                    methodCounter++;
                }
                methodCounter++;
            }
            for (int i = 1; matcher3.find(); i++) {
                System.out.println("Token3 " + i + ": " + matcher3.group());
                for (int j = 1; matcher4.find(); j++) {
                    System.out.println("Token4 " + i + ": " + matcher4.group());
                    methodCounter++;
                }
                methodCounter++;
            }

            for (int i = 1; classMatcher.find(); i++) {
                System.out.println("ClassToken " + i + classMatcher.group());
                for (int j = 1; classMatcher2.find(); j++) {
                    System.out.println("ClassToken2 " + j + classMatcher2.group());
                    classCounter++;
                }
                classCounter++;
            }
            System.out.println("----------------");
            System.out.println("There are " + methodCounter + " methods in the source file");
            System.out.println("There are " + classCounter + " classes in the source file");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}