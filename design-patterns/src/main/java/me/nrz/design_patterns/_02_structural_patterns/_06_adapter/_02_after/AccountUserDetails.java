package me.nrz.design_patterns._02_structural_patterns._06_adapter._02_after;

import me.nrz.design_patterns._02_structural_patterns._06_adapter._02_after.security.UserDetails;

/**
 * adapter
 */
public class AccountUserDetails implements UserDetails {

    private Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return account.getName();
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }
}
