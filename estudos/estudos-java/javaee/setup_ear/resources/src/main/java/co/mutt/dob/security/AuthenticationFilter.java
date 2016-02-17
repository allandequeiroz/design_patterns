//package co.mutt.dob.security;
//
//import javax.annotation.Priority;
//import javax.ws.rs.Priorities;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import java.io.IOException;
//
///**
//* Created by allanqueiroz on 10/2/14.
//*/
//@Priority(Priorities.AUTHENTICATION)
//public class AuthenticationFilter implements ContainerRequestFilter {
//
//    private AuthenticationProvider authenticationProvider;
//
//    public AuthenticationFilter(AuthenticationProvider authenticationProvider) {
//        this.authenticationProvider = authenticationProvider;
//    }
//
//    @Override
//    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
//        AuthenticatedUserInfo authenticatedUserInfo =
//                this.authenticationProvider.authenticateUser(containerRequestContext);
//        containerRequestContext.setProperty(AuthenticatedUserInfo.PROFILE, authenticatedUserInfo);
//    }
//}
