package teoria;

import java.io.IOException;

public class DestroyWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Process proceso = new ProcessBuilder("geany").start();
			System.out.println("abriendo el programa");
			//Thread.sleep(5_000);
			proceso.waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Programa termina");
	}

}
