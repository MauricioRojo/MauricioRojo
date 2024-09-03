import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
class testCheckCondition {

    @Test
    public void testCheckCondition_new() {
        String input = "new\n";  
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin();  
        String result = admin.checkCondition(scanner);
        assertEquals("new", result);
    }
    @Test
    public void testCheckCondition_used() {
        String input = "used\n";  
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin();  
        String result = admin.checkCondition(scanner);
        assertEquals("used", result);
    }
    @Test
    public void testCheckCondition_Invalid() {
        String input = "invalid\n";  // Invalid input
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        String result = null;
        try {
            result = admin.checkCondition(scanner);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        assert result == null;
    }
    
}
