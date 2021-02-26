package com.gestaoclinica.apis.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoclinica.apis.entities.Transportadora;
import com.gestaoclinica.apis.entities.Login;
import com.gestaoclinica.apis.service.TransportadoraService;
import com.gestaoclinica.apis.service.LoginService;
import com.gestaoclinica.apis.service.exceptions.CorretorNegadoException;
import com.gestaoclinica.apis.service.exceptions.CorretorPendenteAprovacaoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.UsuarioInvalidoException;

@RestController
@CrossOrigin
@EnableWebSecurity
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private LoginService loginService;
	@Autowired
	private TransportadoraService corretorService;
	
	private Transportadora corretorAprovado;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		corretorAprovado = new Transportadora ();
		
		corretorAprovado = corretorService.findById(authenticationRequest.getCnpj());
		
		if (corretorAprovado.getAprovado() == 0) {
			throw new CorretorPendenteAprovacaoException("Pendente aprovação.");
		} else if (corretorAprovado.getAprovado() == 3) {
			throw new CorretorNegadoException ("Não aprovado.");
		} 
		authenticate1(authenticationRequest.getCnpj(), authenticationRequest.getSenha());
		final Login login = loginService.findByCpf(authenticationRequest.getCnpj());
		final String token = jwtTokenUtil.generateToken(login);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate1(Long cpf, String senha) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cpf, senha));

		} catch (DisabledException e) {

			throw new Exception("USER_DISABLED", e);
			
		} catch (BadCredentialsException e) {
			throw new UsuarioInvalidoException("");
		} catch (RuntimeException e) {
			throw new ErroNaoMapeadoException ("");
		}
	}
}