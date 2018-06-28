package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MD5Test {

	private static MD5 md5 = new MD5();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMD5Str() {
		String MD5result = md5.getMD5Str("abc123455667777");
		assertEquals("54e914a6edffd0656b1a8692c79ff8de", MD5result);
	}

}
