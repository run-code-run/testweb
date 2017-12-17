package testweb.service;

import org.springframework.stereotype.Service;
import testejb.bean.OrderBean;
import testejb.bean.RemoteCalculator;
import testejb.persistence.EOrderEntity;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.List;

@Service
public class RemoteCallService {


    public List<EOrderEntity> getOrdersList() throws NamingException, RemoteException {

        final OrderBean orderBean = lookupRemoteStatelessOrderBean();

        return orderBean.getOrders();
    }


    //Invoke statelessbean
    public int getRemoteValue() throws NamingException {

        final RemoteCalculator statelessRemoteCalculator = lookupRemoteStatelessCalculator();

        int a = 15;
        int b = 20;

        return statelessRemoteCalculator.add(a, b);
    }


    //TODO REimplement caz returnstatement
    public boolean placeNewOrder(EOrderEntity eOrder) throws NamingException, RemoteException {

        final OrderBean orderBean = lookupRemoteStatelessOrderBean();

        orderBean.addOrder(eOrder);

        return true;
    }

    private static RemoteCalculator lookupRemoteStatelessCalculator() throws NamingException {

        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        return (RemoteCalculator) context.lookup("ejb:/testejb/CalculatorBean!" + RemoteCalculator.class.getName());
    }

    private static OrderBean lookupRemoteStatelessOrderBean() throws NamingException {

        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        return (OrderBean) context.lookup("ejb:/testejb/OrderBeanImpl!" + OrderBean.class.getName());
    }


}
