package com.backend.condominio.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.condominio.domain.Acceso;
import com.backend.condominio.domain.Cuota;
import com.backend.condominio.domain.CuotasExtra;
import com.backend.condominio.domain.Duenio;
import com.backend.condominio.domain.Filial;
import com.backend.condominio.service.AccesoServiceImpl;
import com.backend.condominio.service.CuotaServiceImpl;
import com.backend.condominio.service.CuotasExtraServiceImpl;
import com.backend.condominio.service.DuenioServiceImpl;
import com.backend.condominio.service.FilialServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/Condominio")
@CrossOrigin(origins = "http://localhost:4200/")
public class controlador {

	@Autowired
	private FilialServiceImpl fs;
	
	@Autowired
	private DuenioServiceImpl DSI;
	
	@Autowired
	private AccesoServiceImpl AS;
	
	@Autowired
	private CuotasExtraServiceImpl CES;
	
	@Autowired
	private CuotaServiceImpl CS;
	
	/*                                     DUEÑOS                            */
	
	@GetMapping("/duenios")
    public List<Duenio> listadoDuenio(Model model) {
		
        List<Duenio> duenios = DSI.Listar();
		return duenios;
	}
	
	@PostMapping("/duenios/guardar")
    public void guardar(@RequestBody Duenio duenio) {
		
		if(DSI.buscarUno(duenio.getIdDuenio()) != null) {
			DSI.editar(duenio);
		}else {
			DSI.guardar(duenio);
		}
	}
	
	@GetMapping("/duenios/{id}")
    public ResponseEntity<Duenio> obtenerDuenioXid(@PathVariable Long id) {
		
		Duenio duenio = DSI.buscarUno(id);
		return ResponseEntity.ok(duenio);
	}
	
	@DeleteMapping("/duenios/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarDueno(@PathVariable Long id) {
		
		Duenio duenio = DSI.buscarUno(id);
        DSI.eliminar(duenio);
		
        Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping("/dueniosCuotas/{id}")
    public List<String> obtenerDueniosCuotasXid(@PathVariable Long id) {
		DSI.listarDuoenioCuota(id).forEach(System.out::println);
		return DSI.listarDuoenioCuota(id);
	}
	
	/*                                     FILIALES                            */
	
	@GetMapping("/filiales")
    public List<Filial> listadoFilial(Model model) {
		
        List<Filial> filiales = fs.Listar();
        model.addAttribute("lfiliales", filiales);
		return filiales;
	}
	
	@PostMapping("/filiales/guardar")
	public void guardarFilial(@RequestBody Filial filial) {
		if(fs.buscarUno(filial.getId()) != null) {
			fs.editar(filial);
		}else {
			fs.guardar(filial);
		}
	}
	
	@GetMapping("/filiales/{id}")
    public ResponseEntity<Filial> obtenerFilialXid(@PathVariable Long id) {
		
		Filial filial = fs.buscarUno(id);
		return ResponseEntity.ok(filial);
	}
	
	@DeleteMapping("/filiales/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarFilial(@PathVariable Long id) {
		
		Filial filial = fs.buscarUno(id);
        fs.eliminar(filial);
		
        Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
	
	/*                                     ACCESOS                            */
	
	@GetMapping("/accesos")
    public List<Acceso> listadoAcceso(Model model) {
		
        List<Acceso> Accesos = AS.Listar();
        model.addAttribute("Accesos", Accesos);
		return Accesos;
	}
	
	@PostMapping("/accesos/guardar")
	public void guardarAcceso(@RequestBody Acceso acceso) {
		if(AS.buscarUno(acceso.getIdAcceso()) != null) {
			AS.editar(acceso);
		}else {
			AS.guardar(acceso);
		}
	}
	
	@GetMapping("/accesos/{id}")
    public ResponseEntity<Acceso> obtenerAccesoXid(@PathVariable Long id) {
		
		Acceso acceso = AS.buscarUno(id);
		return ResponseEntity.ok(acceso);
	}
	
	@DeleteMapping("/accesos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarAcceso(@PathVariable Long id) {
		
		Acceso acceso = AS.buscarUno(id);
        AS.eliminar(acceso);
		
        Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
	
	
/*                                     CUOTAS_EXTRA                            */
	
	@GetMapping("/cuotaExtra")
    public List<CuotasExtra> listadoCuotaExtra(Model model) {
		
        List<CuotasExtra> CuotasExtras = CES.Listar();
        model.addAttribute("CuotasExtras", CuotasExtras);
		return CuotasExtras;
	}
	
	@PostMapping("/cuotaExtra/guardar")
	public void guardarCuotaExtra(@RequestBody CuotasExtra cuotasExtra) {
		if(CES.buscarUno(cuotasExtra.getId()) != null) {
			CES.editar(cuotasExtra);
		}else {
			CES.guardar(cuotasExtra);
		}
	}
	
	@GetMapping("/cuotaExtra/{id}")
    public ResponseEntity<CuotasExtra> obtenerCuotaExtraXid(@PathVariable Long id) {
		
		CuotasExtra cuotasExtra = CES.buscarUno(id);
		return ResponseEntity.ok(cuotasExtra);
	}
	
	@DeleteMapping("/cuotaExtra/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCuotaExtra(@PathVariable Long id) {
		
		CuotasExtra cuotasExtra = CES.buscarUno(id);
        CES.eliminar(cuotasExtra);
		
        Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
	
	
/*                                          CUOTAS                                   */
	
	@GetMapping("/cuota")
    public List<Cuota> listadoCuota(Model model) {
		
        List<Cuota> Cuotas = CS.Listar();
        model.addAttribute("Cuotas", Cuotas);
		return Cuotas;
	}
	
	@PostMapping("/cuota/guardar")
	public void guardarCuota(@RequestBody Cuota cuota) {
		if(CS.buscarUno(cuota.getId()) != null) {
			CS.editar(cuota);
		}else {
			CS.guardar(cuota);
		}
	}
	
	@GetMapping("/cuota/{id}")
    public ResponseEntity<Cuota> obtenerCuotaXid(@PathVariable Long id) {
		
		Cuota cuota = CS.buscarUno(id);
		return ResponseEntity.ok(cuota);
	}
	
	@DeleteMapping("/cuota/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCuota(@PathVariable Long id) {
		
		Cuota cuota = CS.buscarUno(id);
        CS.eliminar(cuota);
		
        Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
