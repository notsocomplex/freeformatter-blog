package com.freeformatter.blog;

import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class MessageDigester {

	public String digest(String input, String algorithm) throws NoSuchAlgorithmException {

		// Create a MessageDigest instance using the name of the algorithm and Bouncy Castle
		// as the crypto provider
		MessageDigest digester = MessageDigest.getInstance(algorithm, new BouncyCastleProvider());

		// Update the digest to use our input string as bytes
		digester.update(input.getBytes());

		// Digest the bytes
		byte[] messageDigest = digester.digest();

        StringWriter writer = new StringWriter();

        // Convert the resulting byte into a hex string 
        for (byte b : messageDigest) {
        	writer.append(String.format("%02x", b));
        }
    
		return writer.toString();

	}
	
}
