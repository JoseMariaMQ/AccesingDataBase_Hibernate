package accessingDataBase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AlumnoDAO {

    public void insertAlumno(Alumnos alumno) {
        try {
            SessionFactory myFactory = SessionManagement.getMyFactory();
            Session mySession = myFactory.openSession();
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

            mySession.close();
            myFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public void insertAlumno(Alumnos alumno) {
        SessionManagement s = new SessionManagement();
        s.insertar(alumno);
    }*/
}
