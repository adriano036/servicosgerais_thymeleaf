package servicosgerais.thymeleaf.controller;

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
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiOperation;
import servicosgerais.dto.ClienteDTO;

@Controller
@RequestMapping("/teste")
public class ClienteController {

	@GetMapping(value = "model")//ip:8080/servicosgerais-api/teste/model
	@ResponseBody
	public ResponseEntity<Model> getModel(Model model) {
		model.addAttribute("teste", 22);
		return new ResponseEntity<Model>(model, HttpStatus.OK);
	}
	
	@GetMapping(value = "obj")//ip:8080/servicosgerais-api/teste/model
	@ResponseBody
	public ClienteDTO getObj() {
		return new ClienteDTO();
	}
	
	@RequestMapping(value = "/html",  method=RequestMethod.GET)//ip:8080/servicosgerais-api/teste/model
	public String getHtml(Model model) {
		String urlAPI = "";
		RestTemplate restTemplate = new RestTemplate();
        ClienteDTO clienteDTO = restTemplate.getForObject(urlAPI, ClienteDTO.class);
        System.out.println(clienteDTO.getId());
        
		System.out.println("teste 1");
		System.out.println("teste 2");
		model.addAttribute("adriano", "teste thymeleaf");
		model.addAttribute("id_cliente", clienteDTO.getId());
		return "pastaTeste/teste";
	}
	
	@ApiOperation(value="Teste post")
	@RequestMapping(value="/testePost/{nrCpfOperador}", method=RequestMethod.POST)
	@ResponseBody
	public ClienteDTO testePost(@PathVariable String nrCpfOperador, @RequestBody ClienteDTO parametrosPost) throws Exception{
		return new ClienteDTO();
	}
}
