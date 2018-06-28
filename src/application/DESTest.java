package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DESTest {

	private static DES des = new DES();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String key = "12345678";
		assertEquals("abc", des.decrypt(des.encrypt("abc", key), key));
	}

}
