package com.notebook.notebook.helper;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class CurrentSession {
  public static UserDetails getLoggedInUser() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserDetails userDetails = null;
    if (principal instanceof UserDetails) {
      userDetails = (UserDetails) principal;
    }
    return userDetails;
  }

  public static String getUsername() {
    return getLoggedInUser().getUsername();
  }
}
