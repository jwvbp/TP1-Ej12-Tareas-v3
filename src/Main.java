import java.time.LocalDate;

import ar.edu.unlu.tareas3v.Administrador;
import ar.edu.unlu.tareas3v.Tarea;

public class Main {

	public static void main(String[] args) {
		LocalDate hoy = LocalDate.now(); // private, static o final hace que LocalDate.now() no funcione
		System.out.println("Hoy es: " + hoy); // por eso envio (hoy) como parametro cuando lo requiera

		Administrador miAdmin = new Administrador();

		Tarea t1 = new Tarea("comprar pan", "2023-09-05");
		miAdmin.agregarTarea(t1);
		Tarea t2 = new Tarea("comprar verduras", "2023-09-06");
		miAdmin.agregarTarea(t2);
		Tarea t3 = new Tarea("comprar ropa", "2023-09-10");
		miAdmin.agregarTarea(t3);
		Tarea t4 = new Tarea("salir", "2023-09-10");
		miAdmin.agregarTarea(t4);
		Tarea t5 = new Tarea("dormir", "2023-09-01");
		miAdmin.agregarTarea(t5);
		Tarea t6 = new Tarea("arreglar auto", "2023-09-08");
		miAdmin.agregarTarea(t6);
		Tarea t7 = new Tarea("hacer nada", "2023-09-10");
		miAdmin.agregarTarea(t7);

		miAdmin.listarTareas();
		System.out.println("----------------------");

		miAdmin.agregarRecordatorio(t1, "2023-09-04");
		miAdmin.agregarRecordatorio(t2, "2023-09-06");
		miAdmin.agregarRecordatorio(t3, "2023-09-06");
		miAdmin.agregarRecordatorio(t4, "2023-09-07");
		miAdmin.agregarRecordatorio(t5, "2023-09-01");
		miAdmin.agregarRecordatorio(t6, "2023-09-01");
		miAdmin.agregarRecordatorio(t7, "2023-09-04");

		miAdmin.listarTareas();
		System.out.println("----------------------");
		miAdmin.marcarComoConcluida(t7, "Juan", hoy);
		miAdmin.marcarComoConcluida(t3, "Juan", hoy);

		miAdmin.listarTareas();
		System.out.println("----------------------");

		miAdmin.listarTareasConcluidasPorColaborador("Juan");
		System.out.println("----------------------");
		miAdmin.listarTareas();
		System.out.println("----------------------");

		Tarea aux = miAdmin.buscarTareaPorTitulo("salir"); // si el titulo no existe se rompe, por eso primero listo
		miAdmin.marcarComoConcluida(aux, "Andrea", hoy); // todas las tareas, si decido marcar como concluida, ya tengo
															// la referencia a la instancia de Tarea
		System.out.println("----------------------");

		miAdmin.listarTareasInconsistentes(hoy);

		System.out.println("----------------------");

		miAdmin.listarTareasNoVencidas(hoy);

	}
}
