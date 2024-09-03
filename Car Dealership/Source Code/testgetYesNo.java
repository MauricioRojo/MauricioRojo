import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class testgetYesNo {

    private ByteArrayInputStream inputStream;
    private Scanner scanner;
	@Test
	void testGetYesNo_yes() {
        String input = "yes\n";  
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        String result = Admin.getYesNo(scanner);

        assertEquals("yes", result);
	}
	@Test
	public void testGetYesNo_no() {
        String input = "no\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        String result = Admin.getYesNo(scanner);

        assertEquals("no", result);
	}
	
    @Test
    public void testGetYesNo_InvalidInput() {
        String input = "invalid\n";  // Invalid input
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        scanner = new Scanner(System.in);
        String result = null;
        try {
            result = Admin.getYesNo(scanner);
        } catch (NoSuchElementException e) {
            // Handle NoSuchElementException if necessary
            e.printStackTrace();
        }

        // Assert if the result is as expected
        // For invalid input, maybe you want the method to return null
        assert result == null;
    }

}
