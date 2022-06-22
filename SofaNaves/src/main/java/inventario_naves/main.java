//Observación: Se recomienda leer primero el archivo naves, ya que es necesario para entender la documentación del archivo main
//En este archivo es donde se encuentra la parte principal del programa, ya que es la que ejecuta las funciones que verá el usuario. Para eso se hará uso de las clases y metodos creados anteriormente en la clase naves
package inventario_naves; //Aqui se indica que se hace uso del paquete inventario_naves, en el cual se encuentran todas las clases, interfaces y métodos necesarios para la clase main
import java.util.Scanner; //Se hace uso de esta clase para poder leer las variables a lo largo de la ejecución del programa
// A continuación se define la clase main, la cual es donde estará contenida el programa
public class main{
	int seleccion_tipo_nave; //Se crea la variable seleccion_tipo_nave, la cual permite
	public static void main(String[] args) { 
	
		Scanner entrada = new Scanner(System.in); //Se hace uso de la clase scanner para permitir la entrada de datos al programa
		while (true){ //Ya que se quiere que el programa se ejecute hasta que el usuario desee lo contrario, hacemos un while(true) que contendrá el programa principal
			//A continuación se le pide al usuario que ingrese los valores de cada una de las variables necesarias para el método constructor presentado en el archivo naves
			//Le pedimos al usuario que ingrese el tipo de nave que va a crear, ya sea 1, 2 o 3
			System.out.println("Introduce el tipo de nave que deseas crear: 1) Vehiculo lanzadera, 2) Nave no tripulada, 3) Nave tripulada");
			int numero_seleccion=entrada.nextInt();	
			//Se le pide al usuario que ingrese el subtipo de nave que desea crear
			System.out.println("introduce el subtipo de nave: ");
			String subtipo= entrada.next();
			//Se le pide al usuario que ingrese el país al que pertenece la nave
			System.out.println("introduce el pais de la nave: ");
			String pais=entrada.next();
			//Se le pide al usuario que le de un nombre a la nave que va a ingresar
			System.out.println("introduce el nombre de la nave: ");
			String nombre_nave=entrada.next();
			//Se le pide al usuario que ingrese el año de creación de la nave
			System.out.println("introduce el año de creacion de la nave: ");
			int fecha_creacion=entrada.nextInt();
			//Se le pide al usuario que ingrese el año de la ultima actividad de la nave
			System.out.println("introduce el año de la ultima actividad de la nave: ");
			int ultima_actividad=entrada.nextInt();
			//Se realiza un switch usando l variable numero_selección, que fue ingresada por el usuario para decidir a que clase pertenece el objeto que se va a crear
			switch (numero_seleccion) {
			case 1: //En esta seccion se presenta lo que realizará el programa cuando la variable numero_seleccion sea igual a 1
				//Lo primero que se hace es crear un objeto llamado nave_creada_1, perteneciente a la clase nave_tipo_1
				//El objeto creado se instancia haciendo uso del método constructor, como se puede ver, el primer parámetro contiene el valor vehiculo lanzadera, ya que se sabe que todos objetos pertenecientes a la clase 1 son de tipo vehiculo_lanzadera
				nave_tipo_1 nave_creada_1 = new nave_tipo_1("vehiculo_lanzadera",subtipo,pais,nombre_nave,fecha_creacion,ultima_actividad);
				//Se llama la función setter para cada uno de los parametros necesarios
				nave_creada_1.setSubtipo_nave(subtipo); //Para el parámetro subtipo, se realiza un setter a la variable subtipo ingresada por el usuario
				nave_creada_1.setPais(pais);//Para el parámetro pais, se realiza un setter a la variable pais ingresada por el usuario
				nave_creada_1.setNombre_nave(nombre_nave); //Para el parámetro nombre_nave, se realiza un setter a la variable nombre_nave ingresada por el usuario
				nave_creada_1.setFecha_creacion(fecha_creacion); //Para el parámetro fecha_creacion, se realiza un setter a la variable fecha_creacion ingresada por el usuario
				nave_creada_1.setAnio_ultima_actividad(ultima_actividad);//Para el parámetro anio_ultima_actividad, se realiza un setter a la variable anio_ultima_actividad ingresada por el usuario
				nave_creada_1.tipo_carga(); //se llama al metodo contenido en la interfaz lanzar, para que genere un valor dependiendo de la clase del objeto
				System.out.println("Se ha creado un vehiculo de lanzadera"); //Indica que se generó el objeto, el cual pertenece a la clase 1 de naves
				nave_creada_1.tipo_carga(); //Se llama el metodo de la interfaz para saber que tipo de carga se lanzó en la nave
				
				

				break; //Se rompe el switch
			//Se define lo que realizará el programa en caso de que la variable numero_seleccion sea igual a 2
			case 2:
				//Lo primero que se hace es crear un objeto llamado nave_creada_2, perteneciente a la clase nave_tipo_2
				//El objeto creado se instancia haciendo uso del método constructor, como se puede ver, el primer parámetro contiene el valor nave no tripulada, ya que se sabe que todos objetos pertenecientes a la clase 1 son de tipo vehiculo_lanzadera
				nave_tipo_2 nave_creada_2 = new nave_tipo_2("nave no tripulada",subtipo,pais,nombre_nave,fecha_creacion,ultima_actividad);
				nave_creada_2.setSubtipo_nave(subtipo);//Para el parámetro subtipo, se realiza un setter a la variable subtipo ingresada por el usuario
				nave_creada_2.setPais(pais); //Para el parámetro pais, se realiza un setter a la variable pais ingresada por el usuario
				nave_creada_2.setNombre_nave(nombre_nave);//Para el parámetro nombre_nave, se realiza un setter a la variable nombre_nave ingresada por el usuario
				nave_creada_2.setFecha_creacion(fecha_creacion); //Para el parámetro fecha_creacion, se realiza un setter a la variable fecha_creacion ingresada por el usuario
				nave_creada_2.setAnio_ultima_actividad(ultima_actividad);//Para el parámetro anio_ultima_actividad, se realiza un setter a la variable anio_ultima_actividad ingresada por el usuario
				System.out.println("Se ha creado una nave no tripulada"); //Indica que se generó el objto perteneciente a la clase 2 de naves
				nave_creada_2.tipo_carga(); //Se llama el metodo de la interfaz para saber que tipo de carga se lanzó en la nave
				
				break; //Se rompe el break
			
				//Se define lo que realizará el programa en caso de que la variable numero_seleccion sea igual a 3
			case 3:
				//Lo primero que se hace es crear un objeto llamado nave_creada_3, perteneciente a la clase nave_tipo_3
				//El objeto creado se instancia haciendo uso del método constructor, como se puede ver, el primer parámetro contiene el valor nave tripulada, ya que se sabe que todos objetos pertenecientes a la clase 1 son de tipo vehiculo_lanzadera
				nave_tipo_3 nave_creada_3 = new nave_tipo_3("vehiculo_lanzadera",subtipo,pais,nombre_nave,fecha_creacion,ultima_actividad);
				nave_creada_3.setTipo_nave("nave no tripulada");
				nave_creada_3.setSubtipo_nave(subtipo); //Para el parámetro subtipo, se realiza un setter a la variable subtipo ingresada por el usuario
				nave_creada_3.setPais(pais); //Para el parámetro pais, se realiza un setter a la variable pais ingresada por el usuario
				nave_creada_3.setNombre_nave(nombre_nave);//Para el parámetro nombre_nave, se realiza un setter a la variable nombre_nave ingresada por el usuario
				nave_creada_3.setFecha_creacion(fecha_creacion);//Para el parámetro fecha_creacion, se realiza un setter a la variable fecha_creacion ingresada por el usuario
				nave_creada_3.setAnio_ultima_actividad(ultima_actividad);//Para el parámetro anio_ultima_actividad, se realiza un setter a la variable anio_ultima_actividad ingresada por el usuario
				nave_creada_3.tipo_carga(); //Se llama el metodo de la interfaz para saber que tipo de carga se lanzó en la nave
				System.out.println("Se ha creado una nave tripulada");//Indica que se generó el objto perteneciente a la clase 3 de naves
				break; //Se rompe el ciclo break
			}
			System.out.println("Si deseas salir del programa ingresa un 0, de lo contrario ingresa cualquier otro número"); //Se le pregunta al usuario si desea crear otra nave
			int respuesta=entrada.nextInt(); //Se le pide al usuario que ingrese un número dependiendo de su decisión
			if(respuesta==0) { //Se realiza el ciclo if para verificar si el valor ingresado por el usuario es igual a 0
				break; //En caso de que el valor sea igual a 0, el programa termina, de lo contrario, el programa continua
			}
		}
		
		
	}
}
