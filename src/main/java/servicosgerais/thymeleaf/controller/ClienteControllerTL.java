package servicosgerais.thymeleaf.controller;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Arrays;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
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
import servicosgerais.thymeleaf.extras.APIConnector;
import servicosgerais_dto.dto.ClienteDTO;

@Controller
@RequestMapping("/teste")
public class ClienteControllerTL {

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
	
	@ApiOperation(value="Teste get")
	@RequestMapping(value="/testeGet/{nrCpfOperador}", method=RequestMethod.GET)
	@ResponseBody
	public ClienteDTO testeGet() throws Exception{
		return new ClienteDTO();
	}
	
	private static HttpHeaders getHeaders(){
        String plainCredentials="bill:abc123";
        String base64Credentials = new String(org.apache.commons.codec.binary.Base64.encodeBase64(plainCredentials.getBytes()));
         
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
	
	@RequestMapping(value = "/html",  method=RequestMethod.GET)//ip:8080/servicosgerais-api/teste/html
	public String getHtml(Model model) throws Exception{
		
//		String keyPassphrase = "12345678";
//
//		KeyStore keyStore = KeyStore.getInstance("PKCS12");
//		keyStore.load(new FileInputStream("cert-key-pair.pfx"), keyPassphrase.toCharArray());
//
//		SSLContext sslContext = SSLContexts.custom()
//		        .loadKeyMaterial(keyStore, null)
//		        .build();
//
//		HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
//		HttpResponse response = httpClient.execute(new HttpGet("https://example.com"));
//		System.out.println(response);
//		System.out.println(response.getEntity());
		
		//String urlAPI = "http://localhost:8180/servicosgerais-api/teste/obj";
		
//		String urlAPI = "https://localhost:8543/servicosgerais-api/teste/obj";
//		
//		CloseableHttpClient httpClient
//	      = HttpClients.custom()
//	        .setSSLHostnameVerifier(new NoopHostnameVerifier())
//	        .build();
//	    HttpComponentsClientHttpRequestFactory requestFactory 
//	      = new HttpComponentsClientHttpRequestFactory();
//	    requestFactory.setHttpClient(httpClient);
//	    
//	    RestTemplate restTemplate = new RestTemplate(requestFactory);
//	    restTemplate.getInterceptors().add(
//				  new BasicAuthorizationInterceptor("adriano", "12345678"));
//	    		
//	    ResponseEntity<ClienteDTO> response 
//	      = restTemplate.exchange(
//	      urlAPI, HttpMethod.GET, null, ClienteDTO.class);
//	    
//	    System.out.println(response.getBody().getId());
//	    
//		System.out.println("teste html");
		//String urlAPI = "https://localhost:8543/servicosgerais-api/teste/obj";
		
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getInterceptors().add(
//				  new BasicAuthorizationInterceptor("adriano", "12345678"));
//        //ClienteDTO clienteDTO = restTemplate.getForObject(urlAPI, ClienteDTO.class);
//		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
//		ResponseEntity<ClienteDTO> response = restTemplate.exchange(urlAPI, HttpMethod.GET, request, ClienteDTO.class);
//        System.out.println(response.getBody().getId());
        
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<ClienteDTO> response = restTemplate.exchange(urlAPI, HttpMethod.GET, null, ClienteDTO.class);
//		ClienteDTO clienteDTO = response.getBody();
		
		ClienteDTO clienteDTO = (ClienteDTO) APIConnector.doGet("/teste/obj", ClienteDTO.class);
		
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
