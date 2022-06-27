package com.backend.condominio.domain;

import java.io.Serializable;
import java.sql.Date;

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
	    name = "guardarAcceso", 
	    procedureName = "SP_INSERTAR_ACCESOS", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDACCESON"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "FECHAN"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "FILIALN"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "HENTRADAN")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "editarAcceso", 
	    procedureName = "SP_ACTUALIZAR_ACCESOS", 
	    parameters = { 
		        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDACCESOCUR"),
		        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "HSALIDAN")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "eliminarAcceso", 
	    procedureName = "SP_BORRAR_ACCESOS", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDACCESOCUR"), 
	        
	    }
	)
@Table(name="ACCESOS")
public class Acceso  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAcceso;
	
	@Column(name="FECHA")
	@NotEmpty
	private String fecha;
	
	@Column(name="ID_VISITANTE")
	@NotEmpty
	private int numVisitante;
	
	@Column(name="FILIAL")
	@NotEmpty
	private int numFilial;
	
	@Column(name="H_ENTRADA")
	@NotEmpty
	private String entrada;
	
	@Column(name="H_SALIDA")
	@NotEmpty
	private String salida;
	
	public Long getIdAcceso() {
		return idAcceso;
	}
	public void setIdAcceso(Long idAcceso) {
		this.idAcceso = idAcceso;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getNumVisitante() {
		return numVisitante;
	}
	public void setNumVisitante(int numVisitante) {
		this.numVisitante = numVisitante;
	}
	public int getNumFilial() {
		return numFilial;
	}
	public void setNumFilial(int numFilial) {
		this.numFilial = numFilial;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	
}
