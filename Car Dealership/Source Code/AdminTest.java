import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
/**
 * This JUnit Test Suite contains multiple test classes that cover different functionalities of the Admin class.
 * It groups related test classes together for organized and comprehensive testing of the Admin class.
 * The included test classes are:
 * - {@link testCheckCondition} for testing the checkCondition method in the Admin class.
 * - {@link testCheckInputInt} for testing input validation with integers in the Admin class.
 * - {@link testgetYesNo} for testing the getYesNo method in the Admin class.
 *
 * <p>This suite allows running all related test cases with a single invocation, ensuring thorough testing
 * of critical functionalities in the Admin class.</p>
 *
 * @see testCheckCondition
 * @see testCheckInputInt
 * @see testgetYesNo
 */
@Suite
@SelectClasses({ testCheckCondition.class, testCheckInputInt.class, testgetYesNo.class })
public class AdminTest {
	/**
	 * Will create an instance of the JUnit TestSuite AdminTest.
	 */
	public AdminTest() {}
}
