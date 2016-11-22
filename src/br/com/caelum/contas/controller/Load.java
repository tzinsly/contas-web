package br.com.caelum.contas.controller;

/**
 * @author Zinsly, Tatiane
 * @email tzinsly@br.ibm.com
 */

/*import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import javax.ws.rs.client.*;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@RestController
public class LoadController {

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public ResponseEntity<String> helloWorld() {

		Client client = Client.create();

		String url = "https://gateway.marvel.com/v1/public/characters?ts=1&apikey=ab09ce26f072d2e21f27fc7d4f6d778a&hash=3fa15fa037538d0d0890dbbf81abba86";
		WebResource webResource = client.resource(url);

		ClientHttpResponse response = webResource.accept("application/json").get(ClientResponse.class);

		String output = response.getEntity(String.class);
		
		OutputJson outputJson = new Gson().fromJson(output, OutputJson.class);
		
		List<Personagens> personagens = outputJson.getPersonagens();
		
		for (Personagens personagem : personagens) {
			
			//DB.getInstance().saveCharacter(personagem.getId(), character);
			
		}
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}*/

//}
