package teoria;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lista = new ArrayList<String>();
		lista.add("ps");
		lista.add("aux");
		//lista.add("|");
		lista.add("grep");
		lista.add("/bin/init");

		
		//creo el objeto Builder
		ProcessBuilder pb = new ProcessBuilder(lista);
		try {
			File directorio = new File("/home/matinal");
			pb.directory(directorio);
			Process proceso = pb.start();
			BufferedReader in = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String linea = null;
			while ((linea = in.readLine()) != null){
				System.out.println(linea);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
