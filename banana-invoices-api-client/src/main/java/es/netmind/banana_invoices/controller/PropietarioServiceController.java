package es.netmind.banana_invoices.controller;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import es.netmind.banana_invoices.models.Propietario;

@RestController
public class PropietarioServiceController {
	
	 @Autowired
	    private WebClient webClient;

	    @GetMapping(value = "/propietarios-view")
	    public List<Propietario> getPropietarios(
	            @RegisteredOAuth2AuthorizedClient("propietarios-client-authorization-code") OAuth2AuthorizedClient authorizedClient
	    ) {
	        return this.webClient
	                .get()
	                .uri("http://127.0.0.1:8090/propietarios")
	                .attributes(oauth2AuthorizedClient(authorizedClient))
	                .retrieve()
	                .bodyToMono(new ParameterizedTypeReference<List<Propietario>>() {
	                })
	                .block();
	    }
	
	
}
