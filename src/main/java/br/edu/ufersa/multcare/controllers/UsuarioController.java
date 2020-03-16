package br.edu.ufersa.multcare.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.multcare.auth.Authentication;
import br.edu.ufersa.multcare.auth.AuthenticationException;
import br.edu.ufersa.multcare.persistence.entities.Usuario;

@RestController
public class UsuarioController {
	
	@RequestMapping("/")
    public String index() {
        return "Wow! funciona! :D";
    }
	
	@RequestMapping(value = "/login")
    public String login(@RequestParam Map<String,String> allRequestParams) throws AuthenticationException {
		
		String usuario  = allRequestParams.get("usuario");
        String senha = allRequestParams.get("senha");
		
		Authentication auth = new Authentication();
		String token = auth.authenticate(usuario, senha);
        
        return token;
    }
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String registro(@RequestParam Map<String,String> allRequestParams) throws AuthenticationException {
		
		String idade = allRequestParams.get("idade");
		String username  = allRequestParams.get("usuario");
        String senha = allRequestParams.get("senha");
        String sexo = allRequestParams.get("sexo");
        String peso = allRequestParams.get("peso");
        String login = allRequestParams.get("login");
		
		Usuario usuario = new Usuario();
		usuario.setIdade(Integer.parseInt(idade));
		usuario.setLogin(login);
		usuario.setNome(username);
		usuario.setPeso(Float.parseFloat(peso));
		usuario.setSenha(senha);
		usuario.setSexo(sexo.charAt(0));
        
        return "ok";
    }
}