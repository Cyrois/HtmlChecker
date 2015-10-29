import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;


public class HtmlValidatorTest {
	
	private static ByteArrayOutputStream testOutput;
	@Before
	public void setOut() throws FileNotFoundException {
		testOutput = new ByteArrayOutputStream();
	    
		System.setOut(new PrintStream(testOutput));
	}

	//test making an empty constructor
	@Test
	public void testConstructor() {
		HtmlValidator testVal = new HtmlValidator();
		assertTrue(testVal != null);
	}
	
	//test making a copy constructor
	@Test
	public void testQueueConstructor() {
		Queue<HtmlTag> testQueue = HtmlTag.tokenize("<html> <body>");
		
		try {
			HtmlValidator testVal = new HtmlValidator(testQueue);
			assertTrue(true);
		} catch (IllegalArgumentException exception) {
			assertTrue(false);
		}
	}
	
	//test copy constructor with null queue
	@Test
	public void testNullQueueConstructor() {
		Queue<HtmlTag> testQueue = null;
		
		try {
			HtmlValidator testVal = new HtmlValidator(testQueue);
			assertTrue(false);
		} catch (IllegalArgumentException exception) {
			assertTrue(true);
		}
	}
	
	//test adding a null tag
	@Test
	public void testAddNullTag() {
		HtmlValidator testVal = new HtmlValidator();
		HtmlTag tag = null;
		try {
			testVal.addTag(tag);
			assertTrue(false);
		} catch (IllegalArgumentException exception) {
			assertTrue(true);
		}
	}
	
	// test adding a tag
	@Test
	public void testAddTag() {
		HtmlValidator testVal = new HtmlValidator();
		HtmlTag tag = new HtmlTag("");
		try {
			testVal.addTag(tag);
			assertTrue(true);
		} catch (IllegalArgumentException exception) {
			assertTrue(false);
		}
	}

	@Test
	public void testGetTags() {
		Queue<HtmlTag> testQueue = HtmlTag.tokenize("<html> <body>");
		HtmlValidator testVal = new HtmlValidator(testQueue);
		
		assertTrue(testVal.getTags().equals(testQueue));
	}
	
	//test removing tags
	@Test
	public void testRemoveTags() {
		Queue<HtmlTag> testQueue = HtmlTag.tokenize("<html> <body> </html>");
		Queue<HtmlTag> resultQueue = HtmlTag.tokenize("<body> </body");
		HtmlValidator testVal = new HtmlValidator(testQueue);
		testVal.removeAll("html");
		assertTrue(testVal.getTags().equals(resultQueue));
	}
	
	//test using the testcases files
	@Test
	public void testValidate1() {
		String url = "testcases/test1.html";
		String expected = "testcases/expected_output_1.txt";
		
		try {
            String pageText = ValidatorMain.readCompleteFileOrURL(url);
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator testValidator = new HtmlValidator(tags);
            testValidator.validate();
            
            File is = new File(expected);
            byte[] expectedOutput = readContentIntoByteArray(is);
            assertTrue(Arrays.equals(expectedOutput, testOutput.toByteArray()));
        } catch (Exception exception) {
        	assertTrue(false);
        }
	}
	
	//test using the testcases files
	@Test
	public void testValidate2() {
		String url = "testcases/test2.html";
		String expected = "testcases/expected_output_2.txt";
		
		try {
            String pageText = ValidatorMain.readCompleteFileOrURL(url);
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator testValidator = new HtmlValidator(tags);
            testValidator.validate();
            
            File is = new File(expected);
            byte[] expectedOutput = readContentIntoByteArray(is);
            assertTrue(Arrays.equals(expectedOutput, testOutput.toByteArray()));
        } catch (Exception exception) {
        	assertTrue(false);
        }
	}
	
	//test using the testcases files
	@Test
	public void testValidate3() {
		String url = "testcases/test3.html";
		String expected = "testcases/expected_output_3.txt";
		
		try {
            String pageText = ValidatorMain.readCompleteFileOrURL(url);
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator testValidator = new HtmlValidator(tags);
            testValidator.validate();
            
            File is = new File(expected);
            byte[] expectedOutput = readContentIntoByteArray(is);
            assertTrue(Arrays.equals(expectedOutput, testOutput.toByteArray()));
        } catch (Exception exception) {
        	assertTrue(false);
        }
	}
	
	//test using the testcases files
	@Test
	public void testValidate4() {
		String url = "testcases/test4.html";
		String expected = "testcases/expected_output_4.txt";
		
		try {
            String pageText = ValidatorMain.readCompleteFileOrURL(url);
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator testValidator = new HtmlValidator(tags);
            testValidator.validate();
            
            File is = new File(expected);
            byte[] expectedOutput = readContentIntoByteArray(is);
            assertTrue(Arrays.equals(expectedOutput, testOutput.toByteArray()));
        } catch (Exception exception) {
        	assertTrue(false);
        }
	}
	
	//test using the testcases files
	@Test
	public void testValidate5() {
		String url = "testcases/test5.html";
		String expected = "testcases/expected_output_5.txt";
		
		try {
            String pageText = ValidatorMain.readCompleteFileOrURL(url);
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator testValidator = new HtmlValidator(tags);
            testValidator.validate();
            
            File is = new File(expected);
            byte[] expectedOutput = readContentIntoByteArray(is);
            assertTrue(Arrays.equals(expectedOutput, testOutput.toByteArray()));
        } catch (Exception exception) {
        	assertTrue(false);
        }
	}
	
	//test using the testcases files
	@Test
	public void testValidate6() {
		String url = "testcases/test6.html";
		String expected = "testcases/expected_output_6.txt";
		
		try {
            String pageText = ValidatorMain.readCompleteFileOrURL(url);
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator testValidator = new HtmlValidator(tags);
            testValidator.validate();
            
            File is = new File(expected);
            byte[] expectedOutput = readContentIntoByteArray(is);
            assertTrue(Arrays.equals(expectedOutput, testOutput.toByteArray()));
        } catch (Exception exception) {
        	assertTrue(false);
        }
	}
	
	//test using the testcases files
	@Test
	public void testValidate7() {
		String url = "testcases/test7.html";
		String expected = "testcases/expected_output_7.txt";
		
		try {
            String pageText = ValidatorMain.readCompleteFileOrURL(url);
            Queue<HtmlTag> tags = HtmlTag.tokenize(pageText);
            HtmlValidator testValidator = new HtmlValidator(tags);
            testValidator.validate();
            
            File is = new File(expected);
            byte[] expectedOutput = readContentIntoByteArray(is);
            assertTrue(Arrays.equals(expectedOutput, testOutput.toByteArray()));
        } catch (Exception exception) {
        	assertTrue(false);
        }
	}
	
	//only used for testing
	private static byte[] readContentIntoByteArray(File file) throws IOException
	{
		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];
		//convert file into array of bytes
		fileInputStream = new FileInputStream(file);
		fileInputStream.read(bFile);
		fileInputStream.close();
		return bFile;
	}
}
