package com.notebook.notebook.Security.filter;

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

import com.notebook.notebook.Security.Utils.JwtUtils;
import com.notebook.notebook.Service.serviceImpl.CustomUserDetailsService;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String username = null;
    String token = null;
    String requestTokenHeader = request.getHeader("Authentication");
    if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
      token = requestTokenHeader.substring(7);
      username = jwtUtils.extractUsername(token);
    }

    // Validate
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
      if (jwtUtils.validateToken(token, userDetails) == true) {
        System.out.println("Valid Token send");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
            userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        System.out.println(usernamePasswordAuthenticationToken.isAuthenticated());
        System.out.println(usernamePasswordAuthenticationToken.getName());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      } else {
        System.out.println("Invalid Token");
      }
    }
    System.out.println("forwording");
    filterChain.doFilter(request, response);

  }

}
