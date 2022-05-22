package ListaContactos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {
	
	private SLList<ArrayList> lista;
	
	public Agenda() {
		
		lista = new SLList<ArrayList>();
				
	}
	
	public void crearAgenda() {
		for(char letra = 'A';letra <= 'Z'; letra++){
			ArrayList<Contacto> bloque = new ArrayList<Contacto>();
			bloque.clear();
			lista.add(bloque);
		}
	}
	
	public int size() {
		return lista.size();
	}
	

	public void imprimirContactos(){
		char letra = 'A';
		for(int i= 0; i < 26; i++){
			System.out.println(letra + " " + lista.getNode(i).x);
			letra++;
		}
	}
	
	public void agregarContacto(String nombre, String telefono, String email, String direccion, String tipo){
		Contacto nuevo = new Contacto(nombre, telefono, email, direccion, tipo);
		char letra = 'A';
		String inicial = nombre.toUpperCase();
		for(int i= 0; i < 26; i++){
			if(letra ==  inicial.charAt(0)) {
				lista.getNode(i).x.add(nuevo);
				ArrayList bloque = lista.getNode(i).x;
				ordenarContacto(bloque);
				System.out.println("\nContacto Agregado\n");
			}
			letra++;
		}
	}
	
	/*
	public void imprimirBloqueContactos(String nombre){
		String buscando = nombre;
		char letra = 'A';
		for(int i= 0; i < 26; i++){
			if(letra == buscando.toUpperCase().charAt(0)){
				System.out.println("Letra: " + letra);
				System.out.println(lista.getNode(i).x);
			}
			letra++;
		}
	}
	*/
	
	//Busqueda por nombre
	public void imprimirInfo(String nombre){
		String buscando = nombre;
		boolean noEncontrado = true;
		char letra = 'A';
		for(int i= 0; i < 26; i++){
			if(letra == buscando.toUpperCase().charAt(0)){
				for(int x = 0; x < lista.getNode(i).x.size(); x++) {
					Contacto contacto = (Contacto) lista.getNode(i).x.get(x);
					if(buscando.toUpperCase().equals(contacto.getNombre().toUpperCase())){
						contacto.info();
						noEncontrado = false;
					}
				}
				if(noEncontrado){
					System.out.println("El contacto que trata de obtener no existe o no coincide con el nombre\n");
				}
			}
			letra++;
		}
	}
	
	//Busqueda por telefono
	public void imprimirInfo1(String numero){
		String buscando = numero;
		boolean noEncontrado = true;
			for(int i= 0; i < 26; i++){
					for(int x = 0; x < lista.getNode(i).x.size(); x++) {
						Contacto contacto = (Contacto) lista.getNode(i).x.get(x);
						if(buscando.equals(contacto.getTelefono())){
							contacto.info();
							noEncontrado = false;
						}
					}
				}if(noEncontrado){
					System.out.println("El contacto que trata de obtener no existe o no coincide con el numero\n");
				}
			}
	
	
	public void eliminarContacto(String nombre){
		String buscando = nombre;
		boolean noEncontrado = true;
		char letra = 'A';
		for(int i= 0; i < 26; i++){
			if(letra == buscando.toUpperCase().charAt(0)){
				for(int x = 0; x < lista.getNode(i).x.size(); x++) {
					Contacto contacto = (Contacto) lista.getNode(i).x.get(x);
					if(buscando.equalsIgnoreCase(contacto.getNombre())){
						lista.getNode(i).x.remove(contacto);
						System.out.println("\nContacto Eliminado \n");
						noEncontrado = false;
					}
				}
				if(noEncontrado){
					System.out.println("\nEl contacto que desea eliminar no existe o no concide con el nombre del contacto\n");
				}
			}
			letra++;
		}
	}

	public void ordenarContacto(ArrayList<Contacto> bloque) {
		List<Contacto> contacto = bloque;
		Collections.sort(contacto);
	}
	
	
}


