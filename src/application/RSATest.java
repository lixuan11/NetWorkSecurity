package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.security.PrivateKey;
import java.security.PublicKey;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RSATest {

	private RSA rsa = new RSA();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {

		KeyPair keypair = rsa.buildKeyPair();
		PublicKey publickey = keypair.getPublic();
		PrivateKey privatekey = keypair.getPrivate();

		String plainText = "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad";
		//assertEquals(plainText, new String(rsa.decryptWithPub(publickey, rsa.encryptWithPri(privatekey, plainText))));

		assertEquals(plainText.getBytes(), rsa.decryptWithPri(privatekey, rsa.encryptWithPub(publickey, plainText)));
	}

}
