package com.uax.spring.listacompra.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.uax.spring.listacompra.dto.UsuarioDTO;
import com.uax.spring.listacompra.repositories.UsuarioRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        final UsuarioDTO usuarioDB = usuarioRepository.findByUsername(username);
        if (usuarioDB == null) {
            return null;
        }
        UserDetails user = User.withUsername(username).password(usuarioDB.getPassword()).roles(usuarioDB.getRoles()).build();
        return user;
    }
    
    public boolean registerUserDB(UsuarioDTO usuario) {
    	
    	List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(usuario.getRoles()));
		
    	String encodededPassword = bCryptPasswordEncoder.encode(usuario.getPassword());

		User user = new User(usuario.getUserName(), encodededPassword, authorities);

		jdbcUserDetailsManager.createUser(user);
		
		return true;
    }

}