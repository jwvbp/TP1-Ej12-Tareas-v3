package ar.edu.unlu.tareas3v;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrador {

	private ArrayList<Tarea> misTareas = new ArrayList<Tarea>();

	public void agregarTarea(Tarea tarea) {
		misTareas.add(tarea);
	}

	public void agregarRecordatorio(Tarea tarea, String fechaRecordatorio) {
		tarea.agregarRecordatorio(fechaRecordatorio);
	}

	public void marcarComoConcluida(Tarea tarea, String nombre, LocalDate hoy) {
		tarea.concluir(nombre, hoy);
	}

	public void listarTareas() {
		for (int i = 0; i < misTareas.size(); i++) {
			System.out.println(misTareas.get(i).toString());
		}
	}

	public void listarTareasConcluidasPorColaborador(String nombre) {
		for (int i = 0; i < misTareas.size(); i++) {
			if (misTareas.get(i).getColaborador() == nombre) {
				System.out.println(misTareas.get(i).toString());
			}
		}
	}

	public Tarea buscarTareaPorTitulo(String titulo) {
		Tarea tarea = null;
		for (int i = 0; i < misTareas.size(); i++) {
			if (misTareas.get(i).getTitulo() == titulo) {
				System.out.println(misTareas.get(i).toString());
				tarea = misTareas.get(i);
			}
		}
		return tarea;
	}

	public void listarTareasInconsistentes(LocalDate hoy) {
		for (int i = 0; i < misTareas.size(); i++) {
			misTareas.get(i).mostrarInconsistencia(hoy);
		}
	}

	public void listarTareasNoVencidas(LocalDate hoy) {
		for (int i = 0; i < misTareas.size(); i++) {
			misTareas.get(i).mostrarTareasNoVencidas(hoy);
		}
	}

}
