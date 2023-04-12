package hibernate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hibernate.dao.Dao;
import hibernate.model.Customer;
import hibernate.model.Role;
import hibernate.model.CustomUserDetails;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	Dao<Customer> dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> list = dao.searchByName(username);
		if (list == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		Set<Role> role = ((Customer) list).getRole();
		for (Role r : role) {
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(authorities, list.getUsername(), list.getPassword(),
				list.getFullName, true, true, true, true);
		return customUserDetails;
	}

}