package com.ul.project.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.ul.project.constants.CarRentalConstants;



/**
 * This class handle token encryption
 * and decryption
 */
public class TokenEncriptOrDecriptUtility {

	
	public static String decryptToken (String token,String passPharse) throws Exception
	{
		byte[] encryptedToken = Base64.decodeBase64(token);

		SecretKeySpec secretKeySpec = tokenKeySpec(CarRentalConstants.PASSWORD_ENCRPTION_SECRET_KEY,passPharse);
		Cipher cipher = Cipher.getInstance(CarRentalConstants.PASSWORD_ENCRPTION_SECRET_KEY);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

		byte[] decryptedtoken = cipher.doFinal(encryptedToken);

		return new String(decryptedtoken);
	}

	
	private static SecretKeySpec tokenKeySpec(String SECRET_KEY,String passPharse)throws UnsupportedEncodingException, NoSuchAlgorithmException,Exception
	{
		byte[] key = (passPharse).getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16); // use only first 128 bit

		return new SecretKeySpec(key, SECRET_KEY);
	}

	/**
	 * Method to generate the encrypted token.
	 * @param passPharse
	 * @return
	 * @throws Exception
	 */
	public static String encryptToken (String token,String passPharse) throws Exception
	{
		SecretKeySpec secretKeySpec = tokenKeySpec(CarRentalConstants.PASSWORD_ENCRPTION_SECRET_KEY,passPharse);
		Cipher cipher = Cipher.getInstance(CarRentalConstants.PASSWORD_ENCRPTION_SECRET_KEY);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] encryptedToken = cipher.doFinal((token).getBytes());
		return new String(Base64.encodeBase64URLSafe(encryptedToken));
	}



	public static String gettingencyptedPassword(String password) throws Exception {
		return getGeneratedEncodedToken(password,CarRentalConstants.PASSWORD_ENCRPTION_KEY);
	}

	public static String gettingdecyptedPassword(String password) throws Exception {
		return getGeneratedDecodedToken(password,CarRentalConstants.PASSWORD_ENCRPTION_KEY);
	}

	public static String getGeneratedEncodedToken(String token,String passPharse) throws Exception{
		return TokenEncriptOrDecriptUtility.encryptToken(token,passPharse);
	}

	public static String getGeneratedDecodedToken(String token,String passPharse)throws Exception {
		return TokenEncriptOrDecriptUtility.decryptToken(token,passPharse);
	}
}
