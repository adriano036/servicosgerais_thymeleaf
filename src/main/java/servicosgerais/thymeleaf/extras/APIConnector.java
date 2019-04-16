package servicosgerais.thymeleaf.extras;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
	public static <T> List<T> doGetList(String caminhoServico) throws Exception{
		RestTemplate restTemplate = new RestTemplate();
	    ParameterizedTypeReference<List<T>>  parameterizedTypeReference = new ParameterizedTypeReference<List<T>>(){};
	    ResponseEntity<List<T>> response = restTemplate.exchange(ConfiguracoesFrontThymeleaf.URL_BASE_API + caminhoServico, HttpMethod.GET, null, parameterizedTypeReference);
	    List<T> lista = response.getBody();
	    return lista;				
	}
	
	public static boolean doPost(String caminhoServico, Object objetoDTO){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> request = new HttpEntity<Object>(objetoDTO);
		ResponseEntity response = restTemplate.exchange(ConfiguracoesFrontThymeleaf.URL_BASE_API + caminhoServico, HttpMethod.POST, request, Void.class);
		return (response.getStatusCode()==HttpStatus.OK);		
	}

}
