package me.nrz.design_patterns._02_structural_patterns._02_after;


import me.nrz.design_patterns._02_structural_patterns._02_after.security.LoginHandler;
import me.nrz.design_patterns._02_structural_patterns._02_after.security.UserDetailsService;

public class App {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("nrz", "nrz");
        System.out.println(login);
    }
}
