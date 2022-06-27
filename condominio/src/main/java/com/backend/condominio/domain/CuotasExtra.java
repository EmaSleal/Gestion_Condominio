package com.backend.condominio.domain;

import java.io.Serializable;

import javax.persistence.Column;
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
	    name = "guardarCuotasExtra", 
	    procedureName = "SP_INSERTAR_CUOTAS_EXTRAS", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "CUOTAIDN"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "FECHAN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "MONTON"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "DUENIOIDN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "DESCRIPCIONN")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "editarCuotasExtra", 
	    procedureName = "SP_ACTUALIZAR_CUOTAS_EXTRAS", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "CUOTAIDCUR"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "FECHAN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "MONTON"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "DESCRIPCIONN")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "eliminarCuotasExtra", 
	    procedureName = "SP_BORRAR_CUOTAS_EXTRAS", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "CUOTAIDCUR"), 
	        
	    }
	)
@Table(name="CUOTAS_EXTRAS")
public class CuotasExtra   implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_CUOTA_EXTRA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FECHA")
	@NotEmpty
	private String fecha;
	
	@Column(name="MONTO")
	@NotEmpty
	private int monto;
	
	@Column(name="ID_DUENIO")
	@NotEmpty
	private int numDuenio;
	
	@Column(name="DESCRIPCION")
	@NotEmpty
	private String descripcion;

	public Long getId() {
		return id;
	}

	public String getFecha() {
		return fecha;
	}

	public int getMonto() {
		return monto;
	}

	public int getNumDuenio() {
		return numDuenio;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
}
