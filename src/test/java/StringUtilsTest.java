import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.example.StringUtils;

public class StringUtilsTest {

    private StringUtils utils;

    @BeforeEach
    public void setupBeforeEach() {
        utils = new StringUtils();
    }

    @AfterEach
    public void tearDownAfterEach() {
        utils = null;
    }

    @Test
    public void testReverseString() {
        Assert.assertEquals("tset", utils.reverseString("test"));
        Assert.assertEquals("", utils.reverseString(""));
        Assert.assertEquals(null, utils.reverseString(null));
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(utils.isPalindrome("radar"));
        Assert.assertFalse(utils.isPalindrome("test"));
        Assert.assertFalse(utils.isPalindrome(null));
    }

    @Test
    public void testCountVowels() {
        Assert.assertEquals(2, utils.countVowels("teest"));
        Assert.assertEquals(0, utils.countVowels(""));
        Assert.assertEquals(0, utils.countVowels(null));
    }
}