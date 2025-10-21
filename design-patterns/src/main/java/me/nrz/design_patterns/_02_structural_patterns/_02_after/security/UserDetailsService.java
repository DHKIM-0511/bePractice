package me.nrz.design_patterns._02_structural_patterns._02_after.security;

/**
 * target
 */
public interface UserDetailsService {

    UserDetails loadUser(String username);

}
