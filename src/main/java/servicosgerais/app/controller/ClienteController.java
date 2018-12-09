package servicosgerais.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import servicosgerais.app.dto.TesteDTO;
import servicosgerais.app.entity.Cliente;
import servicosgerais.app.repository.ClienteRepository;

@Controller
@RequestMapping("/teste")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
		
	@GetMapping(value = "model")//ip:8080/servicosgerais-app/teste/model
	@ResponseBody
	public ResponseEntity<Model> getModel(Model model) {
		model.addAttribute("teste", 22);
		return new ResponseEntity<Model>(model, HttpStatus.OK);
	}
	@GetMapping(value = "obj")//ip:8080/servicosgerais-app/teste/model
	@ResponseBody
	public Cliente getObj(Cliente teste) {
		return new Cliente();
	}
	
	@RequestMapping(value = "/html",  method=RequestMethod.GET)//ip:8080/servicosgerais-app/teste/model
	public String getHtml(Model model) {
		System.out.println("teste 1");
		System.out.println("teste 2");
		model.addAttribute("adriano", "teste thymeleaf");
		return "pastaTeste/teste";
	}
	
	@ApiOperation(value="Teste post")
	@RequestMapping(value="/testePost/{nrCpfOperador}", method=RequestMethod.POST)
	@ResponseBody
	public TesteDTO testePost(@PathVariable String nrCpfOperador, @RequestBody TesteDTO parametrosPost) throws Exception{
		return new TesteDTO();
	}
}
