package cliente;

import java.io.BufferedReader;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {
	private final static String ALGORITMO="AES";
	
	
	
	public static void imprimir(byte[] contenido){
		int i=0;
		for(;i<contenido.length-1;i++){
			System.out.print(contenido[i]+" ");
		}
		System.out.println(contenido[i]+" ");
	}
	
	public static void main(String[] args){
		
		long i=System.nanoTime();
		Scanner sc= new Scanner(System.in);
		System.out.println("Excriba el texto que desea cifrar:");
		String txt=sc.nextLine();
		System.out.println("Mensaje de entrada en texto claro: "+txt);
		KeyGenerator kg;
		try {
			byte[] arr=txt.getBytes();
			System.out.print("Texto claro: ");
			imprimir(arr);
			kg = KeyGenerator.getInstance(ALGORITMO);
			SecretKey sk=kg.generateKey();
			byte[] cifrado=Simetrico.cifrar(sk, txt);
			System.out.print("Texto cifrado: ");
			imprimir(cifrado);
			byte[] descifrado=Simetrico.descifrar(sk, cifrado);
			System.out.print("Texto descifrado: ");
			imprimir(descifrado);
			String desc=new String(descifrado);
			System.out.print("Texto descifrado: ");
			System.out.println(desc);
			long f=System.nanoTime();
			System.out.println((f-i)+" nanosegundos de ejecucion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// main de digest
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Ingrese el texto a digerir");
			String input=bf.readLine();
			System.out.println("El teto ingresado es: "+input);
			long tInicial=System.nanoTime();
			byte[] textoClaro=input.getBytes();
			byte[] digerido=Digest.getDigest("MD5", textoClaro);
			System.out.println(digerido.length+"");
			Digest.imprimirHexa(digerido);
			System.out.println("Ingrese el texto a verificar");
			input=bf.readLine();
			//input= toLowerCase(input);
			byte[] ver=input.getBytes();
			//if(verificar(digerido, ver))System.out.println("Coinciden"); else System.out.println("No coinciden");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
