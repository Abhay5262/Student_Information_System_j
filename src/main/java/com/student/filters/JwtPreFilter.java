package com.student.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.student.userdetails.ProjectUserDetails;
import com.student.utils.JwtUtils;

@Component
public class JwtPreFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private ProjectUserDetails projectUserDetails;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		String headerToken = request.getHeader("Auth");
		String jwtToken = null;
		
		if(headerToken != null && headerToken.startsWith("ABC "))
		{
			jwtToken = headerToken.substring(4);
			String username = jwtUtils.extractUsername(jwtToken);
			UserDetails userDetails = projectUserDetails.loadUserByUsername(username);
			
			if(jwtUtils.validateToken(jwtToken, userDetails)) 
			{
				UsernamePasswordAuthenticationToken uAAToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				uAAToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(uAAToken);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
