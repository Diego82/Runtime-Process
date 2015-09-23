package teoria;

import java.io.IOException;

public class RuntimeDemo {
	public static void main(String[] args) {
		//Creamos un objeto Runtime
		Runtime r = Runtime.getRuntime();
		//Creamos un objeto de tipo Process
		try {
			Process p = r.exec("ls -la");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("para durante 10 segundos");
			//Utilizamos esto para parar el programa temporalmente
			Thread.sleep(10_000);
			System.out.println("continua");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fin del programa");
	}
}
