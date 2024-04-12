package com.student.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.student.entities.Administartor;
import com.student.entities.CustomAdmin;
import com.student.entities.CustomUser;
import com.student.entities.Role;
import com.student.entities.Student;
import com.student.repositories.AdministartorRepo;
import com.student.repositories.StudentRepo;



@Service
public class ProjectUserDetails implements UserDetailsService {
	
	@Autowired 
	private StudentRepo studentRepo;
	
	@Autowired
	private AdministartorRepo administartorRepo;
	
	private String role;
	
	public void setRole(String role) {
		this.role=role;
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		if (role.equals(Role.ROLE_ADMIN.toString()))
		{
			Administartor administrator = administartorRepo.findById(Long.parseLong(username)).get();
 
			if (administrator != null) 
			{
				return new CustomAdmin(administrator);
			} else {
				throw new UsernameNotFoundException("Admin name is invalid");
			}

		}
 
		else if (role.equals(Role.ROLE_USER.toString())) 
		{
			Student student = studentRepo.findById(username).get();
 
			if (student != null) 
			{	
//				System.err.println(student);	
				return new CustomUser(student);
			} else {
				throw new UsernameNotFoundException("User name is invalid");
			}
		}
 
		else {
			System.out.println("Select Your Role Propurly..!!");
			return null;
		}
 
	}

}
