package ar.com.api.cliente.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClienteDTO {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private int edad;
	private String fecha_nacimiento;
	private String fecha_probalble_muerte;
	
	public ClienteDTO() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	@SuppressWarnings("static-access")
	public String getFecha_probalble_muerte() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		Date date = dateFormat.parse(fecha_nacimiento);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.YEAR, 80);
		fecha_probalble_muerte = dateFormat.format(calendar.getTime());
		return fecha_probalble_muerte;
	}

	public void setFecha_probalble_muerte(String fecha_probalble_muerte) {
		this.fecha_probalble_muerte = fecha_probalble_muerte;
	}

}
