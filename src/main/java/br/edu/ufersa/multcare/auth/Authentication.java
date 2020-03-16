package br.edu.ufersa.multcare.auth;

import java.security.MessageDigest;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.edu.ufersa.multcare.persistence.Repositories;
import br.edu.ufersa.multcare.persistence.entities.Usuario;

public class Authentication {
	
	public static String secret = "secret";
	
	public static String authenticate(String username, String password) throws AuthenticationException
	{
		try {
			Usuario user = Repositories.usuarios.findByUsername(username);
			if(user == null)
				throw new AuthenticationException("Usuário não encontrado");
			
			String hashPassword = passwordHash(password);
			if(!hashPassword.equals(user.getSenha()))
				throw new AuthenticationException("Senha incorreta");
			
			String token = Authentication.JWTTokenGen(user.getLogin());
			
			return token;
				
		} catch (AuthenticationException e) {
			throw e;
		} catch (Exception e) {
			throw new AuthenticationException("Problema na autenticação, tente novamente.");
		}
	}
	
	public static Usuario getLoggedUserByToken(String token) throws AuthenticationException {
		try {
			String username = Authentication.JWTTokenVerify(token);
			
			Usuario user = Repositories.usuarios.findByUsername(username);
			if(user == null)
				throw new AuthenticationException("Usuário não encontrado");
			
			return user;
		} catch (Exception e) {
			throw new AuthenticationException(e.getMessage());
		}
	}
	
	public static String JWTTokenGen(String uuid) {
		try {
			
			Algorithm algorithmHS = Algorithm.HMAC256(Authentication.secret);
		    String token = JWT.create()
		        .withIssuer(uuid).withExpiresAt(new Date(System.currentTimeMillis() + (60 * 60 * 24)))
		        .sign(algorithmHS);
		    return token;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String JWTTokenVerify(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(Authentication.secret);
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    
		    String issuer = jwt.getIssuer();
		    return issuer;
		} catch (Exception exception){
			return null;
		}
	}

	public static String passwordHash(String password)
	{
		try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(password.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	    	ex.printStackTrace();
	    }
		
		return null;
	}
}
