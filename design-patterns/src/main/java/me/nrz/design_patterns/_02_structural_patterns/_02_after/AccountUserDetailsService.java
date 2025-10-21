package me.nrz.design_patterns._02_structural_patterns._02_after;

import me.nrz.design_patterns._02_structural_patterns._02_after.security.UserDetails;
import me.nrz.design_patterns._02_structural_patterns._02_after.security.UserDetailsService;

/**
 * adapter
 */
public class AccountUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        return new AccountUserDetails(accountService.findAccountByUsername(username));
    }
}
