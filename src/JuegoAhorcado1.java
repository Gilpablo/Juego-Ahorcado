import java.util.Scanner;

public class JuegoAhorcado1 {
	public static void dibujarMuneco(int vidas) {
		switch (vidas) {
		case 7:
			System.out.println("_____________________");
			break;
		case 6:
			System.out.println("|");
			System.out.println("|_____________________");
			break;
		case 5:
			
			break;
		case 4:
			
			break;
		case 3:
			
			break;
		case 2:
			
			break;
		case 1:
			
			break;
		case 0:
			
			break;

		default:
			break;
		}
	}
	
	public static boolean comprobarLetraPalabra(String vPalabraSecreta[], String letra) {
		boolean encontrado=false;
		
		
		return encontrado;
	}
	
	public static void inicializarVectores(String palabra, String vPalabraSecreta[], String vAciertos[],String vFallos[]) {
		for (int i = 0; i < vFallos.length; i++) {
			vFallos[i] = "_";
		}
		for (int i = 0; i < vPalabraSecreta.length; i++) {
	
			vPalabraSecreta[i] = palabra.substring(i, i+1);
			vAciertos[i] = "_";
		}
		
		
	}
	
	public static void dibujarAciertorErrores(String[] vFallos, String[] vAciertos) {
		
		
		System.out.println("Fallos cometidos:");
		for (int i = 0; i < vFallos.length; i++) {
			if (!vFallos[i].equals("_")) {
				System.out.print(vFallos[i] + " ");
			}
		}
		
		
		System.out.println("\n¡Palabra Secreta!");
		
		for (int i = 0; i < vAciertos.length; i++) {
			System.out.print(vAciertos[i]+ " ");
		}
	}
	
	public static boolean letraRepetida(String letra, String vFallos[]) {
		boolean repe = false;
		
		for (int i = 0; i< vFallos.length; i++) {
			if (vFallos[i].equalsIgnoreCase(letra)) {
				repe = true;
			}
		}
		
		return repe;
	}
	
	
	public static int comprobarLetraIntroducida(int vidas, String letra, String[] vPalabraSecreta, String[] vAciertos,
			String[] vFallos) {
		boolean encontrado = false;
		
		
		if (letraRepetida(letra, vFallos)==false) {
			
			for (int i=0 ; i<vPalabraSecreta.length; i++) {
				if (letra.equalsIgnoreCase(vPalabraSecreta[i])) {
					vAciertos[i] = letra;
					encontrado = true;
				}
			}
			
			if (encontrado == false) {
				for (int i = 0; i<vFallos.length; i++) {
					if (vFallos[i].equals("_")) {
						vFallos[i]=letra;
						vidas--;
						break;
					}
				}
			}
		}
		
		
		
		
		return vidas;
	}
	
	
	public static boolean heGanado(String vAciertos[]) {
		
		
		for (int i = 0; i<vAciertos.length; i++) {
			if (vAciertos[i].equals("_")) {
				return false;

			}
		}

		return true;
	}
	
	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);
		int vidas = 8;
		
		
		
		String palabraSecreta;
		
		System.out.println("Dime la palabra");
		palabraSecreta=leer.next();
				
		String letra;
		String vPalabraSecreta[], vAciertos[], vFallos[];
		vPalabraSecreta = new String[palabraSecreta.length()];
		vAciertos = new String[palabraSecreta.length()];
		vFallos = new String[vidas];
		inicializarVectores(palabraSecreta, vPalabraSecreta, vAciertos, vFallos);
	
		do {
		
			System.out.println("Dime una letra");
			letra = leer.next();
			
			vidas = comprobarLetraIntroducida(vidas, letra,vPalabraSecreta, vAciertos, vFallos);
			
		
			dibujarMuneco(vidas);
		
			dibujarAciertorErrores(vFallos, vAciertos);
			
			
		}while(vidas>=0 && heGanado(vAciertos)==false);

	}

}