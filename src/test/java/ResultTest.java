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
        assertEquals("MVG", Result.getResult(90));
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
    @DisplayName("Check method if student passed the course")
    public void checkPassCourse() {
        assertTrue(Result.passedCourse(70));
    }


    @Test
    @DisplayName("Runtime exception if not MVG,VG;G,IG is entered")
    public void RunTimeExceptionNotMVG() {
        Exception exception = assertThrows(RuntimeException.class, () -> Result.convertABC("Hej"));

        String expectedMessage = "Invalid input!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}






