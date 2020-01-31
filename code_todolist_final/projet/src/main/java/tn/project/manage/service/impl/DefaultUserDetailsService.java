package tn.project.manage.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.project.manage.common.Role;
import tn.project.manage.common.RoleName;
import tn.project.manage.common.User;
import tn.project.manage.common.UserPrinciple;

@Slf4j
@Service
public class DefaultUserDetailsService implements UserDetailsService {

	private static Map<String, User> users = new HashMap<>();

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	private void init() {
		User adminUser = new User("admin", "admin", "admin@ims.tn", passwordEncoder.encode("admin@123"));
		adminUser.setRoles(new HashSet<Role>(Arrays.asList(new Role(RoleName.ROLE_USER),new Role(RoleName.ROLE_ADMIN))));
		User simpleUser = new User("user", "user", "user@ims.tn", passwordEncoder.encode("user@123"));
		simpleUser.setRoles(new HashSet<Role>(Arrays.asList(new Role(RoleName.ROLE_USER))));
		users.put(adminUser.getUsername(), adminUser);
		users.put(simpleUser.getUsername(), simpleUser);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("load user : {}", userName);
		User user = users.get(userName);
		if ((user != null))
			return UserPrinciple.build(user);
		else
			throw new UsernameNotFoundException("User not found by name: " + userName);
	}

}
