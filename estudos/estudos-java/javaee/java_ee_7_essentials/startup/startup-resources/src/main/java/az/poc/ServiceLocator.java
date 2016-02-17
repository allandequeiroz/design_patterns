package az.poc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ServiceLocator {

    private static ServiceLocator serviceLocator;
    private Map<String, Object> beans = new HashMap<String, Object>();
    private Context context;

    private ServiceLocator() throws NamingException {
        Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, Resources.getProperty("naming.factory.url"));
        context = new InitialContext(jndiProperties);
    }

    public <T extends Object> T lookup(String lookupKey) throws NamingException {
        if (beans.containsKey(lookupKey)) {
            return (T) beans.get(lookupKey);
        }
        try {
            T t = (T) context.lookup(Resources.getBean(lookupKey));
            beans.put(lookupKey,t);
            return t;
        } catch (NamingException e) {
            throw e;
        }
    }

    public static ServiceLocator getInstance() throws NamingException {
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator();
        }
        return serviceLocator;
    }
}