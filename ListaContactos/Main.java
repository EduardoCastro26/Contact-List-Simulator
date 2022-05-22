package ListaContactos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Agenda agenda = new Agenda();
		agenda.crearAgenda();
		boolean salir = false;
		int opcion;
		while(!salir) {

			String nombre, telefono, direccion, email, tipo;
						
				System.out.println("\t----- BIENVENIDO AL AGENDA DE CONTACTOS -----");
				System.out.println("\nSeleccione una opcion numerica: \n");				
				System.out.println("1. Agregar un contacto");
				System.out.println("2. Eliminar un contacto");
				System.out.println("3. Obtener informacion de un contacto");
				System.out.println("4. Mostrar todos los contactos");
				System.out.println("5. Salir\n");
				opcion = scan.nextInt();
				scan.nextLine();
				
				switch(opcion){
				case 1:
					System.out.println("\nIngrese el nombre:");
					nombre = scan.nextLine();
					System.out.println("Ingrese el telefono:");
					telefono = scan.nextLine();
					System.out.println("Ingrese el email:");
					email = scan.nextLine();
					System.out.println("Ingrese la direccion:");
					direccion = scan.nextLine();
					System.out.println("Ingrese el tipo de contacto (familiar, colega o cliente):");
					tipo = scan.nextLine();
					agenda.agregarContacto(nombre, telefono, email, direccion, tipo);
					break;
				case 2:
					System.out.println("\nIngrese el nombre del contacto a eliminar: ");
					nombre = scan.nextLine();
					agenda.eliminarContacto(nombre);
					break;
				case 3:
					System.out.println("\nRealizar busqueda mediante: ");
					System.out.println("\n1. Telefono");
					System.out.println("2. Nombre");
					System.out.println("\nSeleccione una opcion numerica: \n");
					int op2;
					op2 = scan.nextInt();
					scan.nextLine();
					switch(op2) {
						case 1: System.out.println("\nIngrese el telefono del contacto para obtener informaci�n: ");
						telefono = scan.nextLine();
						System.out.println();
						agenda.imprimirInfo1(telefono);
						break;
						case 2: System.out.println("\nIngrese el nombre del contacto para obtener informaci�n: ");
						nombre = scan.nextLine();
						System.out.println();
						agenda.imprimirInfo(nombre);
						break;
						default: System.out.println("Elija solo numeros entre 1-2\n");
					}
					
					break;
				case 4:
					System.out.println("\t----- AGENDA DE CONTACTOS -----");
					agenda.imprimirContactos();
					break;
				case 5:
					salir = true;
					break;
					default: System.out.println("Elija solo numeros entre 1-5\n");
				}
		}
		
	}
}
