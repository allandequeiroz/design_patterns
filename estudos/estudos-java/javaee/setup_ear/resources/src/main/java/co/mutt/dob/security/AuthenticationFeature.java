//package co.mutt.dob.security;
//
//import javax.inject.Inject;
//import javax.ws.rs.container.DynamicFeature;
//import javax.ws.rs.container.ResourceInfo;
//import javax.ws.rs.core.FeatureContext;
//import javax.ws.rs.ext.Provider;
//import java.lang.reflect.Method;
//
///**
//* Created by allanqueiroz on 10/2/14.
//*/
//@Provider
//public class AuthenticationFeature implements DynamicFeature {
//
//    @Inject
//    AuthenticationProvider authenticationProvider;
//
//    @Override
//    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
//        Method method = resourceInfo.getResourceMethod();
//        if (! method.isAnnotationPresent(AuthenticationNotRequired.class)) {
//            AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationProvider);
//            featureContext.register(authenticationFilter);
//        }
//    }
//}
