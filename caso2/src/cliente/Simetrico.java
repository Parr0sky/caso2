package cliente;

import javax.crypto.Cipher;

import javax.crypto.SecretKey;

public class Simetrico {
	private final static String PADDING="AES/ECB/PKCS5Padding";

	public static byte[] cifrar(SecretKey llave, String texto){
		byte[] textoCifrado;
		try{
			Cipher cifrador=Cipher.getInstance(PADDING);
			byte[] textoClaro=texto.getBytes();
			cifrador.init(Cipher.ENCRYPT_MODE, llave);
			textoCifrado=cifrador.doFinal(textoClaro);
			return textoCifrado;
		}catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	
	public static byte[] descifrar(SecretKey llave, byte[] txt){
		byte[] txtClaro;
		try{
			Cipher cifrador=Cipher.getInstance(PADDING);
			cifrador.init(Cipher.DECRYPT_MODE, llave);
			txtClaro=cifrador.doFinal(txt);
			
		}catch(Exception e){
			System.out.println();
			return null;
		}
		return txtClaro;
	}
}

