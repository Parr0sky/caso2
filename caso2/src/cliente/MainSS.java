package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainSS {
	
	public static final String DIRECCION = "localhost";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] comandosCliente=new String[7];
		comandosCliente[0]="HOLA";
		comandosCliente[1]="ALGORITMOS:AES:RSA:HMACSHA1";
		comandosCliente[2]="Certificado del Cliente";
		comandosCliente[3]="OK";
		int iter=0;
		
		Socket socket = null;
		Scanner sc = null;
		String strUsuario="";
		

		try
		{
			socket = new Socket(DIRECCION, 8080);
			sc = new Scanner(System.in);
		}
		catch (Exception e)
		{
			System.err.println("Exception: " + e.getMessage());
			System.exit(1);
		}

		while(true&&iter<7)
		{
			System.out.println("Excriba el comando:");
			strUsuario=sc.nextLine();
	
					
			
		}
		System.out.println("Fin de la transacción");

		// cierre el socket y la entrada estándar
		try {
			sc.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
