//Este archivo contiene la clase principal, se trata de la clase abstracta naves, la cual se usa como modelo para crear las demás clases. En ella se encuentran los métodos principales, así como las variables usadas a lo largo de la ejecución del programa con el fin de no tener que declararlas en cada una de las clases.
package inventario_naves; //se implementa el paquete inventario_naves, para de esta forma usar los archivos que se encuentran allí
abstract public class naves { //se crea la clase abstracta naves
//A continuación definimos dos métodos abstractos, como se puede ver, ninguno de ellos posee cuerpo
	abstract boolean funciona(); //el metodo funciona sirve para comprobar si la nave seguirá funcionando dependiendo del tiempo transcurrido desde su creación
	abstract boolean reutilizable(); //el método reutilizable sirve para comprobar si es posible arreglar la nave para funcionar nuevamente basado en el tiempo transcurrido desde su creación

//A continuación se crean las variables que se usarán en la clase padre, es decir, la clase abstracta y que serán heredadas por las clases hijas
	
	private int anio_actual;
	private String tipo_nave;
	private String subtipo_nave;
	private String pais;
	private String nombre_nave;
	private int fecha_creacion;
	private int anio_ultima_actividad;
//En total se crearon seis variables, tres de ellas de tipo string y tres de tipo entero. Las variables fueron creadas privadas para que no fuera posible modificarlas desde el programa principal y de este modo evitar cambios intencionales en los valores que se tienen

//En este punto, se crean los getters y setters para cada una de las seis variables
	
	//getters y setters para la variables AnioActual	
	public int getAnio_actual() { 
		return anio_actual;
	}

	public void setAnio_actual(int anio_actual) {
		this.anio_actual = anio_actual;
	}
	//getters y setters para la variable TipoNave
	public String getTipo_nave() {
		return tipo_nave;
	}
	public void setTipo_nave(String tipo_nave) {
		this.tipo_nave = tipo_nave;
	}
	//getters y setters para la variable SubtipoNave
	public String getSubtipo_nave() {
		return subtipo_nave;
	}
	public void setSubtipo_nave(String subtipo_nave) {
		this.subtipo_nave = subtipo_nave;
	}
	//getters y setters para la variable Pais
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	//getters y setters para la variable NombreNave
	public String getNombre_nave() {
		return nombre_nave;
	}
	public void setNombre_nave(String nombre_nave) {
		this.nombre_nave = nombre_nave;
	}
	//getters y setters para la variable fecha_creación
	public int getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(int fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	//getters y setters para la variable AnioUltimaActividad
	public int getAnio_ultima_actividad() {
		return anio_ultima_actividad;
	}
	public void setAnio_ultima_actividad(int anio_ultima_actividad) {
		this.anio_ultima_actividad = anio_ultima_actividad;
	}
	
}

//Luego de haber definido la clase principal, se crean las clases generales, las cuales heredan de la clase abstracta naves e implementan la interfaz lanzar 
//la primera de estas clases es la clase nave_tipo_1
class nave_tipo_1 extends naves implements lanzar{
//Aquí se define el metodo constructor de la clase. En el se definen los campos que tendrá cada uno de los objetos que se creen, en este caso, los objetos de esta clase tendrán seis campos correspondientes a las seis variables de la clase padre
	public nave_tipo_1(String tipo_nave, String subtipo_nave,String pais, String nombre_nave, int fecha_creacion, int anio_ultima_actividad) {
	}
	//En esta seccion se definen los métodos que tendrá la clase, como se puede ver, dos de ellos corresponden a los métodos definidos en la clase abstracta.
	//el primer metodo es de tipo entero, se trata de un método que calcula el tiempo transcurrido desde la creación de la nave, tomando como referencia que nos encontramos en el año 2022
	public int tiempo_creacion() {
		setAnio_actual(2022);
		int tiempo_transcurrido=getAnio_actual()-getFecha_creacion();
		return tiempo_transcurrido;
	}
	//el segundo método habia sido definido anteriormente como un método abstracto en la clase naves. Se trata de un método que nos dice que la nave puede seguir funcionando siempre y cuando sea de tipo 1 y haya sido creada despues del 2000
	public boolean funciona() {
		if (getFecha_creacion()<2000) {
			return false;
		}
		return true;
	}
	//el tercer método había sido definido anteriormente como un método abstracto en la clase naves. Se trata de un método que nos dice que la nave puede repararse siempre y cuando sea de tipo 1 y haya sido usada por última vez en el año 2005
	public boolean reutilizable() {
		if(getAnio_ultima_actividad()<2005) {
			return false;
		}
		return true;
	}
//Por ultimo tenemos un método definido en la interfaz lanzar, el cual nos indica que tipo de objeto ha sido lanzado al espacio en esa nave.
	public void tipo_carga() {
		System.out.println("se ha lanzado una sonda");		
	}
}

//segundo tipo de naves
//la segunda de estas clases es la clase nave_tipo_2, la cual tambien hereda de la clase abstracta naves e implementa la interfaz lanzar
class nave_tipo_2 extends naves implements lanzar{
//aquí se define el método constructor de las naves pertenecientes a la segunda clase
	public nave_tipo_2(String tipo_nave, String subtipo_nave,String pais, String nombre_nave, int fecha_creacion, int anio_ultima_actividad) {
	}
	//al igual que en la clase 1, se definen los métodos de la clase 2, como se puede ver, el método tiempo_creacion es exactamente igual al de la clase 1	
	public int tiempo_creacion() {
		setAnio_actual(2022);
		int tiempo_transcurrido=getAnio_actual()-getFecha_creacion();
		return tiempo_transcurrido;
	}
	//el metodo funciona de la clase 2, si bien sigue una lógica igual a la de la clase 1, es diferente, ya que en este caso, las naves funcionarán siempre y cuando se hayan creado despues del 2010
	public boolean funciona() {
		if (getFecha_creacion()<2010) {
			return false;
		}
		return true;
	}
	//el método reutilizable de la clase 2, tambien sigue la misma lógica que tiene en la clase 1, pero el valor a comparar el año de la ultima actividad varía.	
	public boolean reutilizable() {
		if(getAnio_ultima_actividad()<2016) {
			return false;
		}
		return true;
	}
	//Al igual que en la clase 1, se el método tipo_carga de la interfaz lanzar, el cual nos indica que en este tipo de naves se acostumbra a lanzar un satélite
	public void tipo_carga() {
		System.out.println("Se ha lanzado un satelite");	
	}
}


//tercer tipo de naves
class nave_tipo_3 extends naves implements lanzar{
	//El constructor de la clase 3 sigue siendo identico al de las clases 1 y 2, manteniendo los parámetros definidos en la clase abstracta naves
	public nave_tipo_3(String tipo_nave, String subtipo_nave,String pais, String nombre_nave, int fecha_creacion, int anio_ultima_actividad) {
	}
	// El método tiempo_creación sigue manteniendose igual que en las dos clases anteriores	
	public int tiempo_creacion() {
		setAnio_actual(2022);
		int tiempo_transcurrido=getAnio_actual()-getFecha_creacion();
		return tiempo_transcurrido;
	}
	//El método funciona varía, ya que se tiene que el método retorna falso cuando la fecha de creación sea menor que 1995, es decir, posee valores distintos en cada una de las tres clases
	public boolean funciona() {
		if (getFecha_creacion()<1995) {
			return false;
		}
		return true;
	}
	//el método reutilizable tambien varía, ya que retorna falso cuando el año de la ultima actividad es menor que 1999, es decir posee valores distintos en cada una de las tres clases
	public boolean reutilizable() {
		if(getAnio_ultima_actividad()<1999) {
			return false;
		}
		return true;
	}

	//Por ultimo ,se tiene el método tipo_carga proveniente de la interfaz lanzar, en este caso, el método nos dice que se ha lanzado una persona al espacio, es decir, posee un valor distinto en cada una de las tres clases
	public void tipo_carga() {
		System.out.println("Se ha lanzado una persona al espacio");		
	}
}