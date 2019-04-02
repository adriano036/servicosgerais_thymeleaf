package servicosgerais.thymeleaf.extras;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import servicosgerais_dto.dto.ClienteDTO;

public class APIConnector {
	
	public static Object doGet(String caminhoServico, Class classeMapeadaDTO) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity response = restTemplate.exchange(ConfiguracoesFrontThymeleaf.URL_BASE_API + caminhoServico, HttpMethod.GET, null, classeMapeadaDTO);
		return response.getBody();		
	}
	
	// TODO implementar a fim de que retorne uma listagem de dtos (por enquanto está errado, mas sei que é possível fazer isto). Acho que tem isso no Boletim ou no Desconto Externo
	public static List<Object> doGetList(String caminhoServico, Class classeMapeadaDTO) throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity response = restTemplate.exchange(ConfiguracoesFrontThymeleaf.URL_BASE_API + caminhoServico, HttpMethod.GET, null, classeMapeadaDTO);
		if(1==1) throw new Exception("Método doGetList da classe APIConnector ainda não implementado");
		return (List<Object>) response.getBody();		
	}

}
