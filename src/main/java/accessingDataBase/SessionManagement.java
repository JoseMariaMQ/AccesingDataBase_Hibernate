package accessingDataBase;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManagement {

    private static final SessionFactory myFactory;
    static {
        try {
            myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class).buildSessionFactory();
        } catch(Throwable th){
            System.err.println("Error en la creación inicial de SessionFactory"+th);
            throw new ExceptionInInitializerError(th);
        }
    }
    public static SessionFactory getMyFactory(){
        return myFactory;
    }

    /*public void insertar(Alumnos alumno) {
        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class).buildSessionFactory();
        try (myFactory; Session mySession = myFactory.openSession()) {
            //Escritura de registro
            mySession.beginTransaction();
            mySession.save(alumno);
            mySession.getTransaction().commit();
            System.out.println("Alumno insertado correctamente.");

            //Lectura del registro
            mySession.beginTransaction();
            System.out.println("Lectura del registro con Id: " + alumno.getId());
            Alumnos alumnoInsertado = mySession.get(Alumnos.class, alumno.getId());
            System.out.println("Registro: " + alumnoInsertado);
            mySession.getTransaction().commit();
            System.out.println("Terminado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
