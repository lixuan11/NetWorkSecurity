package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SHATest {

	private static SHA sha = new SHA();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSHA256StrJava() {
		String SHAresult = sha.getSHA256StrJava("abc123455667777");
		assertEquals("e7ef4b3ddd597dc128aab769a23b79ee54790006e67d4ca9ede809e35ab5c342", SHAresult);
	}

}
