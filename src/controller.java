package mx.com.proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.proyecto.Dto.CatEstadosDTO;
import mx.com.proyecto.Dto.MensajeDTO;
import mx.com.proyecto.Entidades.CatEstados;
import mx.com.proyecto.Service.CatEstadosService;

@Controller
@RequestMapping(value="CatEstado")
public class CatEstadosController {
	
	@Autowired
	private CatEstadosService catEstadosService;
	
	@ResponseBody 
    @RequestMapping(value="/guardarNuevoEstado", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	public String guardarNuevoEstado(@RequestBody CatEstadosDTO datos){
		String respuesta = catEstadosService.guardarNuevoEstado(datos);		
		return respuesta;	
    }
	
	@ResponseBody
    @RequestMapping(value="/deleteCatEstados", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity < String> deleteCatEstados(@RequestBody CatEstadosDTO id){
		
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = catEstadosService.deleteCatEstados(id);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    }
	
	@ResponseBody
    @RequestMapping(value="/eliminaEstadoPorId", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	public MensajeDTO eliminaEstadoPorId(@RequestBody CatEstadosDTO id){
		
		
		
		return catEstadosService.eliminaEstadoPorId (id);	
    }
	/*
	 * Actualizar
	 */
	
	@ResponseBody 
    @RequestMapping(value="/actualizarEstado", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	public String actualizarEstado(@RequestBody CatEstadosDTO datos){
		String respuesta = catEstadosService.actualizarEstado(datos);		
		return respuesta;	
    }
	
	/*
	 * Consultar datos por Id
	 */
	
	@ResponseBody 
    @RequestMapping(value="/getEstadoById", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	public String getEstadoById(@RequestBody CatEstadosDTO id){
		String respuesta = catEstadosService.getEstadoById(id);		
		return respuesta;	
	}
	
	/*
	 * Retorna el estado
	 */
	
	@ResponseBody 
    @RequestMapping(value="/getEstado", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	public ResponseEntity<List<CatEstados>> getEstado(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		List<CatEstados> estados = catEstadosService.buscarListaDatos();
		
				
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<CatEstados>> (estados, httpHeaders, HttpStatus.OK);		
	}

}
