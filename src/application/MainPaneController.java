package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class MainPaneController {

	@FXML
	private TextArea PlainText, HashValue, RKaEncodeValue, PubKeyEncodeValue, UKbEncodeValue, CypherText, RKbDecodeValue, PubKeyDecodeValue, UKaDecodeValue;

	@FXML
	private TextField CompareResult;

	@FXML
	private Button RKaEncode, UKbEncode, RKbDecode, PubKeyDecode, UKaDecode, CompareHash, SHAButton, MD5Button, DESButton, AESButton;


	private PublicKey publickeyA, publickeyB;

	private PrivateKey privatekeyA, privatekeyB;

	private RSA rsaA = new RSA();
	private String decodeA;

	private RSA rsaB = new RSA();

	@FXML
	public void CalShaHash(ActionEvent event) {

		HashValue.clear();
		SHA sha = new SHA();
		String plaintext = PlainText.getText();
		String SHAresult = sha.getSHA256StrJava(plaintext);
		HashValue.setText(SHAresult);
	}

	@FXML
	public void CalMD5Hash(ActionEvent event) {

		HashValue.clear();
		MD5 md5 = new MD5();
		String plaintext = PlainText.getText();
		String MD5result = md5.getMD5Str(plaintext);
		HashValue.setText(MD5result);
	}

	@FXML
	public void RKaEncodeFunction(ActionEvent event) throws Exception {

		KeyPair keypair = rsaA.buildKeyPair();
		publickeyA = keypair.getPublic();
		privatekeyA = keypair.getPrivate();
		String plaintext = HashValue.getText();
		String result = rsaA.base64Encode(rsaA.encryptWithPri(privatekeyA, plaintext));
		

		RKaEncodeValue.setText(result);
	}

	public void RKaDecodeFunction(ActionEvent event) throws Exception {

		String cyphertext = RKaEncodeValue.getText();
		byte[] cypertextArrays = rsaA.base64Decode(cyphertext);
		String result = rsaA.base64Encode(rsaA.decryptWithPub(publickeyA, cypertextArrays));
		UKaDecodeValue.setText(result);
	}

	@FXML
	public void CalDES(ActionEvent event) {

	}

	@FXML
	public void CalAES(ActionEvent event) {

	}

}




