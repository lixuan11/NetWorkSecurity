package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AESTest {

	private AES aes = new AES();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {

		aes.setALGO("AES");

		aes.setKeyValue("4E7FF1C1F04F4B36".getBytes());
		String plain = "abcd";
		assertEquals(plain, aes.decrypt(aes.encrypt(plain)));
	}

}
