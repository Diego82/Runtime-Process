package teoria;

import java.io.IOException;
import java.io.InputStream;

public class ProcessDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] comandos = new String[3];
		InputStream in = null;
		
		if (args.length > 0) {
			comandos[0] = "ping";
			comandos[1] = args[0];
			comandos[2] = "-c4";
			System.out.println("Entra");
		}
		else
		{
			System.out.println("Faltan argumentos");
			System.exit(1);
		}
			
		try {
			Process p = Runtime.getRuntime().exec(comandos);
		
			//Recoger el InputStream que genera el ping
			in = p.getInputStream();
			
			int c; //Variable que definimos para recoger los datos
			//leemos los bytes uno a uno
			while ((c=in.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println("salida con valor: "+p.exitValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}

}
