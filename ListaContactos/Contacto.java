package ListaContactos;

public class Contacto implements Comparable<Contacto>{

		private String nombre, telefono, email, direccion, tipo;
		
		public Contacto(String nombre, String telefono, String email, String direccion, String tipo) {
			this.nombre = nombre;
			this.telefono = telefono;
			this.email = email;
			this.direccion = direccion;
			this.tipo = tipo;
		}
			
		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		
		@Override
		public String toString() {
			return nombre;
			
		}
		
		public void info(){
		System.out.println("Nombre: " + nombre + "\n"
					+"Telefono: " + telefono + "\n"
					+"Correo: " + email + "\n"
					+"Direccion: " + direccion + "\n"
					+"Tipo: " + tipo + "\n");
		}

		@Override
		public int compareTo(Contacto p1) {
			// TODO Auto-generated method stub
			return nombre.compareTo(p1.getNombre());
		}


}
