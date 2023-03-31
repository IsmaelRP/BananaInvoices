package es.netmind.banana_invoices.controller;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import es.netmind.banana_invoices.models.User;

@RestController
public class UserServiceController {

	@Autowired
	private WebClient webClient;

	@GetMapping(value = "/users-view")
	public List<User> getAllUsers(
			@RegisteredOAuth2AuthorizedClient("users-client-authorization-code") OAuth2AuthorizedClient authorizedClient) {
		return this.webClient.get().uri("http://127.0.0.1:8090/users")
				.attributes(oauth2AuthorizedClient(authorizedClient)).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<User>>() {
				}).block();
	}

	@PostMapping(value = "/users-add")
	public User createUser(
			@RegisteredOAuth2AuthorizedClient("recibos-client-authorization-code") OAuth2AuthorizedClient authorizedClient) {
		return this.webClient.post().uri("http://127.0.0.1:8090/user")
				.attributes(oauth2AuthorizedClient(authorizedClient)).retrieve()
				.bodyToMono(new ParameterizedTypeReference<User>() {
				}).block();
	}

}
