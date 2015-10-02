package teoria;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PipeDemo {

	public static void main(String[] args) {
		
		//Definimos los comandos del proceso 1
		List<String> comandos1 = new ArrayList<String>();
		comandos1.add("ls");
		comandos1.add("-l");
		
		//Definimos los comandos del proceso 2
		List<String> comandos2 = new ArrayList<String>();
		comandos2.add("grep");
		comandos2.add("android");
		
		//Creamos 2 ProcessBuilder para cada proceso
		ProcessBuilder pBuilder1 = new ProcessBuilder(comandos1);
		ProcessBuilder pBuilder2 = new ProcessBuilder(comandos2);
		
		//definimos la ruta de directorio del proceso 1
		File file = new File("/home/matinal");
		pBuilder1.directory(file);

		//Abrimos dos procesos BufferedReader para nuestro proceso
		BufferedReader in1 = null, in2 = null;

		//output stream para el proceso 2
		PrintWriter out1 = null;
		
		try {
			//Preparo los dos procesos
			Process proceso1 = pBuilder1.start();
			Process proceso2 = pBuilder2.start();
			
			// Preparo el output stream del segundo proceso
			// Abro el canal y se llena
			out1 = new PrintWriter(proceso2.getOutputStream());
			
			in1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
			in2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
			String linea1 = null;
			while ((linea1=in1.readLine())!=null) {
				System.out.println(linea1);
				out1.write(linea1+"\n");
				
			}
			System.out.println("--------------------------------------------------");
			out1.close();
			String linea2 = null;
			while ((linea2=in2.readLine())!=null) {
				System.out.println(linea2);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				in1.close();
				in2.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
