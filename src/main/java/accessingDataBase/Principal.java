package accessingDataBase;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String nombre;
        String apellidos;
        String curso;
        int edad;
        int numAsignaturas;

        Alumnos alumno;
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        Scanner in = new Scanner(System.in);

        //Entrada de datos por consola
        System.out.println("Inserte un alumno");
        System.out.println("Nombre:");
        nombre = in.nextLine();
        System.out.println("Apellidos:");
        apellidos = in.nextLine();
        System.out.println("Curso:");
        curso = in.nextLine();
        System.out.println("Edad:");
        edad = in.nextInt();
        System.out.println("Número de asignaturas matriculado:");
        numAsignaturas = in.nextInt();

        alumno = new Alumnos(nombre, apellidos, curso, edad, numAsignaturas);

        alumnoDAO.insertAlumno(alumno);
    }
}
