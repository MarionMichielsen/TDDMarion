import java.util.InputMismatchException;
import java.util.Scanner;

public class Result {
    static int points;
    static int maxPoints;

    public static void main(String[] args) {
     //   System.out.println(printPercentage(points, maxPoints));
    //    System.out.println(printResult(points, maxPoints));
   //     System.out.println( printNewScore(points, maxPoints));
    }

    public static String printNewScore(int points, int maxPoints) {
        return "In the new scoring that would be: " + convertABC(getResult(calculatePercentage(points, maxPoints)));
    }

    public static String printResult(int points, int maxPoints) {
       return "Your result is: " + getResult(calculatePercentage(points, maxPoints));
    }

    public static String printPercentage(int points, int maxPoints) {
        return "Your percentage is: " + calculatePercentage(points, maxPoints);
    }

    public static String getResult(int percentage){
        if (percentage >=90 )
            return "MVG";
        else if (percentage >= 75)
            return "VG";
        else if (percentage >= 50)
            return "G";
        else return "IG";
    }

    public static int calculatePercentage(int points, int maxPoints) {
        return points*100/maxPoints;
    }

    public static String convertABC(String grade) {
        if (grade.equals("MVG"))
            return "A";
        if (grade.equals("VG"))
            return "B";
        if (grade.equals("G"))
            return "C";
        if (grade.equals("IG"))
            return "F";
        else
            throw new RuntimeException("Invalid input!");
        }


    public static boolean passedCourse(int percentage) {
        return percentage >= 50;
    }
}
