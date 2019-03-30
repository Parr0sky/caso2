package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class Asimetrico {
	public static final byte[] cifrar(PublicKey kp, String entrada) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			byte[] textoClaro = entrada.getBytes();
			cipher.init(Cipher.ENCRYPT_MODE, kp);
			byte[] textoCifrado = cipher.doFinal(textoClaro);
			return textoCifrado;
		} catch (Exception e) {
			System.err.println("Excepcion: " + e.getMessage());
			return null;
		}
	}

	public static final String descifrar(byte[] txt, PrivateKey llave) throws Exception {

		try{
			Cipher cifrador=Cipher.getInstance("RSA");
			cifrador.init(Cipher.DECRYPT_MODE, llave);
			byte[] txtClaro=cifrador.doFinal(txt);
			return new String (txtClaro);

		}catch(Exception e){
			System.out.println("Excepcion: " + e.getMessage());
			return null;
		}

	}
}
