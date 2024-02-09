package pruebas;

import java.util.List;
import java.util.Scanner;

import daos.SubjectDao;
import daos.SubjectDaoImpl;
import model.Subject;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op=0;
		do {
			System.out.println("\n ------ MENU PRINCIPAL ------");
			System.out.println("1. Registrar");
			System.out.println("2. Editar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("5. SALIR");
			System.out.print("Ingrese una opción: ");
			op=sc.nextInt();
			switch (op) {
			case 1:
				registrar(); break;
			case 2:
				editar(); break;
			case 3:
				eliminar(); break;
			case 4:
				mostrar(); break;
			case 5:
				System.out.println("Hasta luego"); break;
			default:
				System.out.println("Elija la opción correctamente"); break;
			}
		} while (op!=5);
	}
	
	public static void mostrar() {
		SubjectDao dao = new SubjectDaoImpl();
		List<Subject> subjectList = dao.findAll();
		
		for(Subject s: subjectList) {
			System.out.println(s.getIdSubject());
			System.out.println(s.getCode());
			System.out.println(s.getName());
			System.out.println(s.getLevel());
			System.out.println(s.getTeacher());
		}
	}
	
	public static void registrar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Registro de nuevo sujeto ---");
		SubjectDao dao = new SubjectDaoImpl();
		String code, name, level, teacher;
		System.out.print("Ingrese el codigo: ");
		code = sc.next();
		System.out.print("\nIngrese el nombre: ");
		name = sc.next();
		System.out.print("\nIngrese el nivel: ");
		level = sc.next();
		System.out.print("\nIngrese el profesor: ");
		teacher = sc.next();
		System.out.println("");
		
		Subject subject = new Subject();
		subject.setCode(code);
		subject.setName(name);
		subject.setLevel(level);
		subject.setTeacher(teacher);
		
		dao.create(subject);
	}
	
	public static void editar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Editar Sujeto ---");
		SubjectDao dao = new SubjectDaoImpl();
		int id;
		String code, name, level, teacher;
		System.out.print("Ingrese el id del sujeto a modificar: ");
		id = sc.nextInt();
		System.out.print("\nIngrese el codigo: ");
		code = sc.next();
		System.out.print("\nIngrese el nombre: ");
		name = sc.next();
		System.out.print("\nIngrese el nivel: ");
		level = sc.next();
		System.out.print("\nIngrese el profesor: ");
		teacher = sc.next();
		System.out.println("");
		
		Subject subject = new Subject();
		subject.setCode(code);
		subject.setName(name);
		subject.setLevel(level);
		subject.setTeacher(teacher);
		
		dao.update(subject);
	}
	
	public static void eliminar() {
		Scanner sc = new Scanner(System.in);
		SubjectDao dao = new SubjectDaoImpl();
		int id;
		System.out.println("------ Eliminar Sujeto ------");
		System.out.print("Ingrese id del sujeto a eliminar: ");
		id = sc.nextInt();
		System.out.println("");
		dao.delete(id);
	}
}
