package ar.edu.unlu.tareas3v;

import java.time.LocalDate;

public class Tarea {

	private String titulo;
	private int prioridad = 2; // 1: Alta 2:Baja
	private String estado = "Incompleta"; // Incompleta Realizada
	private LocalDate fechaLimite;
	private LocalDate fechaRecordatorio;
	private LocalDate fechaConcluida;
	private String colaborador;

	public Tarea(String titulo, String fechaLimite) {
		super();
		this.titulo = titulo;
		this.fechaLimite = LocalDate.parse(fechaLimite);
	}

	public void agregarRecordatorio(String fechaRecordatorio) {
		this.setFechaRecordatorio(LocalDate.parse(fechaRecordatorio));
	}

	public String getTitulo() {
		return titulo;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	private void setFechaRecordatorio(LocalDate fechaRecordatorio) {
		this.fechaRecordatorio = fechaRecordatorio;
	}

	public LocalDate getFechaRecordatorio() {
		return fechaRecordatorio;
	}

	public LocalDate getFechaConcluida() {
		return fechaConcluida;
	}

	public void setFechaConcluida(LocalDate fechaConcluida) {
		this.fechaConcluida = fechaConcluida;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public void concluir(String nombre, LocalDate hoy) {
		setEstado("Concluida");
		setColaborador(nombre);
		setFechaConcluida(hoy);
	}

	public void mostrarInconsistencia(LocalDate hoy) {
		int valor = fechaLimite.compareTo(hoy);
		int valor2 = fechaRecordatorio.compareTo(hoy);
		if ((valor2 == 0) && (estado == "Incompleta")) {
			System.out.print("<Hoy Fecha recordatorio> ");// Fecha Recordatorio es hoy
		}
		if ((valor == 0) && (estado == "Incompleta")) {
			System.out.print("<Hoy se vence> ");// La Fecha Limite es hoy y la Tarea esta Incompleta
		}
		if ((valor < 0) && (estado == "Incompleta")) {
			System.out.print("<Tarea VENCIDA> ");// La Fecha limite ya pasó y la Tarea esta Incompleta
		}
		if ((valor2 < 0) && (estado == "Incompleta")) { // Ya se paso la Fecha de recordatorio y todavia esta incompleta
			setPrioridad(1); // entonces subo la prioridad a 1
		}

		System.out.println(titulo + " (prioridad: " + prioridad + ")");
	}

	public void mostrarTareasNoVencidas(LocalDate hoy) {
		int valor = fechaLimite.compareTo(hoy);
		if (!((valor < 0) && (estado == "Incompleta"))) {
			System.out.println(titulo + "   Fecha Limite: " + fechaLimite);

		}
	}

	@Override
	public String toString() {
		return "Tarea [tit:" + titulo + "   pri:" + prioridad + "   est:" + estado + "   fLim:" + fechaLimite
				+ "   fRec:" + fechaRecordatorio + "   fConcl:" + fechaConcluida + "   colab:" + colaborador + "]";
	}

}
