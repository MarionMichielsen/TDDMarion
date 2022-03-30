import java.util.InputMismatchException;
import java.util.Scanner;

public class Result {
    static int points;
    static int maxPoints;

    public static void main(String[] args) {
        System.out.println("Your percentage is: " + calculatePercentage(enterPoints(), enterMaxPoints()));
        System.out.println("Your result is: " + getResult(calculatePercentage(points, maxPoints)));
        System.out.println("In the new scoring that would be: " + convertABC(getResult(calculatePercentage(points, maxPoints))));
    }

    private static int enterMaxPoints() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What was the maximum result on the test?");
        if (sc.hasNextInt())
            return sc.nextInt();
        else {
            System.out.println("You have to enter an integer.");
            return enterMaxPoints();
        }
    }

    static int enterPoints() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many points did you score on the test?");
        if (sc.hasNextInt())
            return sc.nextInt();
        else {
            System.out.println("You have to enter an integer.");
            return enterPoints();
        }

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
        return percentage >= 60;
    }
}
