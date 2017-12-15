package testweb.service;

import org.springframework.stereotype.Service;
import testejb.RemoteCalculator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

@Service
public class RemoteCallService {



    //Invoke statelessbean
    public int getRemoteValue() throws NamingException {

        final RemoteCalculator statelessRemoteCalculator = lookupRemoteStatelessCalculator();

        int a = 15;
        int b = 20;

        int sum = statelessRemoteCalculator.add(a,b);


        return sum;
    }

    private static RemoteCalculator lookupRemoteStatelessCalculator() throws NamingException {

        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        return (RemoteCalculator) context.lookup("ejb:/testejb/CalculatorBean!" + RemoteCalculator.class.getName());
    }


}
