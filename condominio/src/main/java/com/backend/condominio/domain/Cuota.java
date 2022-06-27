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

import lombok.Data;


@Data
@Entity
@NamedStoredProcedureQuery(
	    name = "guardarCuotas", 
	    procedureName = "SP_INSERTAR_CUOTAS", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDCUOTAN"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "FECHAN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "MONTON"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "IDDUENION"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "DESCRIPCIONN")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "editarCuotas", 
	    procedureName = "SP_ACTUALIZAR_CUOTA", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDCUOTACUR"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "FECHAN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "MONTON"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "DESCRIPCIONN")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "eliminarCuotas", 
	    procedureName = "SP_BORRAR_CUOTA", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDCUOTACUR"), 
	        
	    }
	)
@Table(name="CUOTAS")
public class Cuota  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_CUOTA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FECHA")
	private String fecha;
	
	@Column(name="MONTO")
	private int monto;
	
	@Column(name="ID_DUENIO")
	private int numDuenio;
	
	@Column(name="DESCRIPCION")
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
