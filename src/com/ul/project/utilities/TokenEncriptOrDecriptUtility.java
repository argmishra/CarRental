package com.ul.project.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.ul.project.constants.CarRentalConstants;



// TODO: Auto-generated Javadoc
/**
 * This class handle token encryption
 * and decryption.
 */
public class TokenEncriptOrDecriptUtility {

	
	/**
	 * Decrypt token.
	 *
	 * @param token the token
	 * @param passPharse the pass pharse
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String decryptToken (String token,String passPharse) throws Exception
	{
		byte[] encryptedToken = Base64.decodeBase64(token);

		SecretKeySpec secretKeySpec = tokenKeySpec(CarRentalConstants.PASSWORD_ENCRPTION_SECRET_KEY,passPharse);
		Cipher cipher = Cipher.getInstance(CarRentalConstants.PASSWORD_ENCRPTION_SECRET_KEY);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

		byte[] decryptedtoken = cipher.doFinal(encryptedToken);

		return new String(decryptedtoken);
	}

	
	/**
	 * Token key spec.
	 *
	 * @param SECRET_KEY the secret key
	 * @param passPharse the pass pharse
	 * @return the secret key spec
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws Exception the exception
	 */
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
	 *
	 * @param token the token
	 * @param passPharse the pass pharse
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String encryptToken (String token,String passPharse) throws Exception
	{
		SecretKeySpec secretKeySpec = tokenKeySpec(CarRentalConstants.PASSWORD_ENCRPTION_SECRET_KEY,passPharse);
		Cipher cipher = Cipher.getInstance(CarRentalConstants.PASSWORD_ENCRPTION_SECRET_KEY);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] encryptedToken = cipher.doFinal((token).getBytes());
		return new String(Base64.encodeBase64URLSafe(encryptedToken));
	}



	/**
	 * Gets the tingencypted password.
	 *
	 * @param password the password
	 * @return the tingencypted password
	 * @throws Exception the exception
	 */
	public static String gettingencyptedPassword(String password) throws Exception {
		return getGeneratedEncodedToken(password,CarRentalConstants.PASSWORD_ENCRPTION_KEY);
	}

	/**
	 * Gets the tingdecypted password.
	 *
	 * @param password the password
	 * @return the tingdecypted password
	 * @throws Exception the exception
	 */
	public static String gettingdecyptedPassword(String password) throws Exception {
		return getGeneratedDecodedToken(password,CarRentalConstants.PASSWORD_ENCRPTION_KEY);
	}

	/**
	 * Gets the generated encoded token.
	 *
	 * @param token the token
	 * @param passPharse the pass pharse
	 * @return the generated encoded token
	 * @throws Exception the exception
	 */
	public static String getGeneratedEncodedToken(String token,String passPharse) throws Exception{
		return TokenEncriptOrDecriptUtility.encryptToken(token,passPharse);
	}

	/**
	 * Gets the generated decoded token.
	 *
	 * @param token the token
	 * @param passPharse the pass pharse
	 * @return the generated decoded token
	 * @throws Exception the exception
	 */
	public static String getGeneratedDecodedToken(String token,String passPharse)throws Exception {
		return TokenEncriptOrDecriptUtility.decryptToken(token,passPharse);
	}
}
