package com.maven.jpa;

import java.util.List;

import javax.persistence.*;

public class Jpa_Maven_Test {
 //declaramos un variable  de tipo entitymanager...
	private  EntityManager manager;
	
	
	//creamos su respectivo constructor.....
	public Jpa_Maven_Test(EntityManager manager) {
	//super();
	this.manager = manager;
       }   //fin del  constructor.....



	public static void main(String[] args) {
		
		// aplicamos una variable de tipo  entitymanagefactory
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("Proyecto-Maven-CibertecIII");	
		// aplicamos una variable de tipo  entitymanager
		EntityManager manager=factory.createEntityManager(); 
        //instanciamos la clase jpa_maven_test....
        Jpa_Maven_Test jpamaven=new Jpa_Maven_Test(manager);
        //aplicamos transaciones...
        EntityTransaction etran=manager.getTransaction();
        //iniciamos la transacion....
        etran.begin();
        //llamamos el metodo crear alumno.....
        jpamaven.InsertarAlumno();
        //llamamos al metodo listar alumnos....
      
        //declaramos una variable de list para recuperar los valores de la BD...
        List<Alumno> listadoAlum=jpamaven.ListarAlumnos();
        //aplicamos un bucle for....
        //imprimimos los campos por consola....
        System.out.println("nombre   "+"  apellido "+" dni "+" sexo "+"  email  ");
        for(Alumno lisalum:listadoAlum){
        	//imprimimos por consola...
        	System.out.println(lisalum.getNombre()+" "+lisalum.getApellido()+" "+lisalum.getDni()
        	+" "+lisalum.getSexo()+" "+lisalum.getEmail());
        	
        }   //fin del bucle for....
        //llamamos al metodo actualizar  alumno...
        jpamaven.ActualizarAlumnos(1,"Melany","Chuquimbalqui","40558899","F","melany@gmail.com");
        
        
	}  //fin  del metodo  principal.....
	
	//creamos el metodo insertar alumno
	public void InsertarAlumno(){
		//instanciamos la clase alumno....
		Alumno alumn=new Alumno("Luis Enrique","Gomez","10554488","M","luis@gmail.com");
		Alumno alumn2=new Alumno("Rosa Maria","Perez","40556688","F","rosa@gmail.com");
		Alumno alumn3=new Alumno("Arturo Jorge","Delgado","40334488","M","arturo@hotmail.com");
		Alumno alumn4=new Alumno("Iban Javier","Ramirez","10556677","M","iban@hotmail.com");
		Alumno alumn5=new Alumno("Carmen Rosa","Silva","40445533","F","carmen@gmail.com");
	//aplicamos el metodo de la persistencia.
		manager.persist(alumn);
		manager.persist(alumn2);
		manager.persist(alumn3);
		manager.persist(alumn4);
		manager.persist(alumn5);
	}  //fin del metodo insertar alumno....
	
	//creamos el metodo listar alumnos
	public List<Alumno> ListarAlumnos(){
		//declaramos una variable de tipo string
		String consulta="select a from Alumno a";
		//aplicamos la interfaz query...
		Query querycons=manager.createQuery(consulta,Alumno.class);
		//almacenamos los valores de la BD en una variable de tipo List....
		List<Alumno> listalum=querycons.getResultList();
		//retornamos los valores...
		return listalum;
	}  //fin del metodo listar alumnos....
	
	//creamos el metodo actualizar alumnos...
	public void ActualizarAlumnos(int cod,String nom,String ape,String dn,String sex,String em){
		//declaramos variable  de tipo string para la consulta...
		String cons="UPDATE Alumno a SET a.nombre=:nom,"
				+ "a.apellido=:ape,a.dni=:dn,a.sexo=:sex,"
				+ "a.email=:em where a.idalumno=:cod";
		//aplicamos la interfaz Query....
		Query queryconsul=manager.createQuery(cons);
		//aplicamos parametros dinamicos....
		queryconsul.setParameter("cod",cod);
		queryconsul.setParameter("nom",nom);
		queryconsul.setParameter("ape",ape);
		queryconsul.setParameter("dn",dn);
		queryconsul.setParameter("sex",sex);
		queryconsul.setParameter("em",em);
		//ejecutamos las instrucciones con executeupdate..
		int x=queryconsul.executeUpdate();
		//emitimos un mensaje  por consola...
		if(x>0)  System.out.println("datos del  alumno  actualizados correctamente");			
	}  //fin del metodo actualizar alumnos...

}   //fin de la  clase jpa_maven_test......
