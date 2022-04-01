import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    int points;
    int maxPoints;

    @BeforeEach
    void setUp() {
        maxPoints = 100;
    }

    @AfterEach
    void tearDown() {
        points = 0;
        maxPoints = 0;
    }

    @Test
    @DisplayName("Checks if 90% gives MVG")
    public void checkIf90givesMVG() {
        assertEquals("VG", Result.getResult(90));
    }

    @Test
    @DisplayName("Checks if 80% gives VG")
    public void checkIf80givesVG() {
        assertEquals("VG", Result.getResult(80));
    }

    @Test
    @DisplayName("Checks if 60% gives G")
    public void checkIf60givesG() {
        assertEquals("G", Result.getResult(60));
    }

    @Test
    @DisplayName("Checks if 10% gives IG")
    public void checkIf10givesIG() {
        assertEquals("IG", Result.getResult(10));
    }

    @Test
    @DisplayName("Checks if the percentage is calculated correctly")
    public void calculatePercentage() {
        assertEquals(75, Result.calculatePercentage(75, maxPoints));
    }

    @Test
    @DisplayName("Checks if MVG is converted to A")
    public void convertMVGtoA() {
        assertEquals("A", Result.convertABC("MVG"));
    }

    @Test
    @DisplayName("Checks if VG is converted to B")
    public void convertVGtoB() {
        assertEquals("B", Result.convertABC("VG"));
    }

    @Test
    @DisplayName("Checks if G is converted to C")
    public void convertGtoC() {
        assertEquals("C", Result.convertABC("G"));
    }

    @Test
    @DisplayName("Checks if IG is converted to F")
    public void convertIGtoF() {
        assertEquals("F", Result.convertABC("IG"));
    }

    @Test
    @DisplayName("test printout 60/100 gives 60 percent")
    public void checkPrintPercentage60(){
        assertEquals("Your percentage is: 60", Result.printPercentage(60, maxPoints));
    }
    @Test
    @DisplayName("makes sure IG is not converted to A")
    public void convertIGtoA(){
        assertNotEquals("A", Result.convertABC("IG"));
    }
    @Test
    @DisplayName("Check printout if 60 percent gives G")
    public void checkPrintResult(){
        assertEquals("Your result is: G", Result.printResult(60,maxPoints));
    }

    @Test
    @DisplayName("Checks Printout if 60 percent gives C")
    public void checkPrintConvertABC(){
        assertEquals("In the new scoring that would be: C", Result.printNewScore(60,maxPoints));
    }


    @Test
    @DisplayName("Runtime exception if not MVG,VG;G,IG is entered")
    public void RunTimeExceptionNotMVG() {
        Exception exception = assertThrows(RuntimeException.class, () -> Result.convertABC("Hej"));

        String expectedMessage = "Invalid input!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Check if course failed with 30%")
    public void checkCourseFailed(){
        assertFalse(Result.passedCourse(30));
    }

    @Test
    @DisplayName("Check if course passed with 80%")
    public void checkCoursePassed(){
        assertTrue(Result.passedCourse(80));
    }
}






