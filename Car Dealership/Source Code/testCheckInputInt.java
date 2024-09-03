import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
class testCheckInputInt {

	@Test
	public void testCheckInputInt() {
		String number = "12\n";
		InputStream input = new ByteArrayInputStream(number.getBytes());
		Scanner scanner = new Scanner(input);
		Admin admin = new Admin();
		int result = admin.checkInputInt(scanner);
		Assert.assertEquals(12, result);
	}
	@Test
	public void testCheckInputInt_InvalidInput() {
		String input = "abc\n";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		Scanner scanner = new Scanner(inputStream);
		Admin admin = new Admin();
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			admin.checkInputInt(scanner);
		});
	}
	
	@Test
	public void testCheckInputInt_NoInput() {
		String input = "";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		Scanner scanner = new Scanner(inputStream);
		Admin admin = new Admin();
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			admin.checkInputInt(scanner);
		});
	}



}
