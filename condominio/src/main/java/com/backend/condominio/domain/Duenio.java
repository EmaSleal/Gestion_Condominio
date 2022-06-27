package com.backend.condominio.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@NamedStoredProcedureQuery(
	    name = "guardarDuenio", 
	    procedureName = "SP_INSERTAR_DUENIOS", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDDUENION"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "NOMBREN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "APE1N"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "APE2N"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "TELEFONON"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "CORREON")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "editarDuenio", 
	    procedureName = "SP_ACTUALIZAR_DUENIO", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDDUENIOCUR"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "NOMBREN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "APE1N"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "APE2N"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "TELEFONON"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "CORREON")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "eliminarDuenio", 
	    procedureName = "SP_BORRAR_DUENIO", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDDUENIOCUR"), 
	        
	    }
	)
@NamedStoredProcedureQuery(
	    name = "mostrarPagos", 
	    procedureName = "SP_MOSTRAR_DATOS_PAGOS", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "ID"), 
	        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "p_cursor")
	    }
	)
@Table(name="DUENIOS")
public class Duenio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDuenio;
	
	@Column(name="NOMBRE")
	@NotEmpty
	private String nombre;
	
	@Column(name="APE1")
	@NotEmpty
	private String apellido1;
	
	@Column(name="APE2")
	@NotEmpty
	private String apellido2;
	
	@Column(name="TELEFONO")
	@NotEmpty
	private Long telefono;
	
	@Column(name="CORREO")
	@NotEmpty
	private String Correo;
	
	
	public long getIdDuenio() {
		return idDuenio;
	}
	public void setIdDuenio(long l) {
		this.idDuenio = l;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	
}
