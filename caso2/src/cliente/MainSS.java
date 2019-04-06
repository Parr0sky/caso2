package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainSS {
	
	public final static String[] commands={"HOLA","ALGORITMOS","OK","ERROR"};
	public final static String separador=":";
	public final static String ALGs="AES";
	public final static String ALGa="RSA";
	public final static String ALGhmac="HMACSHA1";
	public static final String DIRECCION = "localhost";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket socket=null;
		String strUsuario="";
		BufferedReader bf=null;
		PrintWriter pw=null;
		String strServidor="";
		//coneccion de server y texto estandar
		try
		{
			socket = new Socket(DIRECCION, 8080);
			bf= new BufferedReader(new InputStreamReader(System.in));
			pw=new PrintWriter(socket.getOutputStream(),true);
		}
		catch (Exception e)
		{
			System.err.println("Exception: " + e.getMessage());
			System.exit(1);
		}

		for (int i = 0; i < 7; i++) {
			System.out.println("Escriba el comando:");
			try {
				strUsuario=bf.readLine();
				if(strUsuario!="" && strUsuario!=null){
					if(strUsuario.equalsIgnoreCase(commands[0])) pw.println(commands[0]);
					//envio algs
					String algs=commands[1]+separador+ALGs+separador+ALGa+separador+ALGhmac;
					pw.println(algs);
					
					//certificado del cliente
					
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
					
			
		
		System.out.println("Fin de la transacción");

		// cierre el socket y la entrada estándar
		try {
			bf.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
