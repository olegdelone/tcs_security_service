package ws.security.service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.security.service.generated.WebServiceException_Exception;
import ws.security.service.generated.WsSecurityService;
import ws.security.service.generated.WsSecurityServiceImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== WsSecurityServiceClient.java ==========
 * <p/>
 * $Revision:  $<br/>
 * $Author:  $<br/>
 * $HeadURL:  $<br/>
 * $Id:  $
 * <p/>
 * 22.12.13 14:15: Original version (OOBUKHOV)<br/>
 */
public class WsSecurityServiceClient implements WsSecurityService {
    private static transient Logger log = LoggerFactory.getLogger(WsSecurityServiceClient.class);

    private WsSecurityService service;
    private String serviceName;
    private String namespaceUri;
    private String endpoint;
    private SOAPHandler<SOAPMessageContext> handler;

    public SOAPHandler<SOAPMessageContext> getHandler() {
        return handler;
    }

    public void setHandler(SOAPHandler<SOAPMessageContext> handler) {
        this.handler = handler;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setNamespaceUri(String namespaceUri) {
        this.namespaceUri = namespaceUri;
    }

    private synchronized WsSecurityService getService() {
        if (service == null) { // lazy
            initService();
        }
        return service;
    }

    private void initService() {
        log.debug("\n");
        log.debug("=========================================");
        log.debug("Initializing WsSecurityService....");
        log.debug("=========================================");
        log.debug("\n");
        try {
            if (endpoint == null) {
                throw new RuntimeException("Bean property 'endpoint' has null value ");
            }
            log.debug("Trying to create WSDL URL using endpoint: {}", endpoint);
            URL serviceEndpointUrl;
            serviceEndpointUrl = new URL(endpoint);
            QName qName = new QName(namespaceUri, serviceName);
            WsSecurityServiceImpl wsSecurityService = new WsSecurityServiceImpl(serviceEndpointUrl, qName);
            service = wsSecurityService.getWsSecurityServiceImplPort();

            if(handler != null){
                log.info("adding handler: {}", handler);
                BindingProvider bindingProvider = (BindingProvider)service;
                Binding binding = bindingProvider.getBinding();
                List<Handler> handlers = binding.getHandlerChain();
                handlers.add(handler);
                binding.setHandlerChain(handlers);
            }

            log.debug("Service has been created using endpoint:{} and QName:{}", serviceEndpointUrl, qName);
        } catch (MalformedURLException e) {
            String message = "Caught: MalformedURLException. Couldn't create URL using '"+endpoint+"'. Next execution is not possible. Original message: " + e;
            log.error(message);
            throw new RuntimeException(message, e);
        }
    }

    @Override
    public String testAuth(String param) throws WebServiceException_Exception {
        return getService().testAuth(param);
    }
}
