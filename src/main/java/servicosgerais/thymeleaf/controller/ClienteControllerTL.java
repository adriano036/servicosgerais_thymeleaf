package servicosgerais.thymeleaf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import servicosgerais.thymeleaf.extras.APIConnector;
import servicosgerais.thymeleaf.extras.ServicosGeraisException;
import servicosgerais_dto.dto.ClienteDTO;
import servicosgerais_dto.dto.PessoaDTO;

@Controller
@RequestMapping("/cliente")
public class ClienteControllerTL {

	@RequestMapping(value = "/html",  method=RequestMethod.GET)//ip:8080/servicosgerais-api/teste/html
	public String getHtml(Model model) throws Exception{
		
		ClienteDTO clienteDTO = (ClienteDTO) APIConnector.doGet("/cliente/obj", ClienteDTO.class);
		model.addAttribute("adriano", "teste thymeleaf");
		model.addAttribute("id_cliente", clienteDTO.getId());
		return "pastaTeste/teste";
	}
	
	
	
	@RequestMapping(value = "/salvar",  method=RequestMethod.POST)
	public void salvarCliente(@RequestParam Map<String, Object> body, 
			Model model, RedirectAttributes redirectAttrs,
			@ModelAttribute ClienteDTO cliente,
			HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		boolean sucesso = APIConnector.doPost("/cliente/salvar", cliente);
		if(!sucesso) throw new ServicosGeraisException("Não foi possível salvar o clientee");
		
	}
	
	@RequestMapping(value = "/visualizar/pagina/salvamento",  method=RequestMethod.GET)
	public String visualizarPaginaSalvamento(HttpSession session, Model model, RedirectAttributes redirectAttrs) throws Exception{
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setPessoa(new PessoaDTO());
		model.addAttribute("cliente", clienteDTO);
		return "salvarCliente";
	}
	
	
}
