package ws.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ws.security.handler.SOAPLoggingHandler;
import ws.security.service.generated.WebServiceException_Exception;
import ws.security.service.client.WsSecurityServiceClient;

import javax.xml.ws.Endpoint;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== DefaultController.java ==========
 * <p/>
 * $Revision:  $<br/>
 * $Author:  $<br/>
 * $HeadURL:  $<br/>
 * $Id:  $
 * <p/>
 * 22.12.13 14:46: Original version (OOBUKHOV)<br/>
 */
@Controller
public class DefaultController {
    private static transient Logger log = LoggerFactory.getLogger(DefaultController.class);

    @Autowired
    WsSecurityServiceClient wsSecurityServiceClient;

    @RequestMapping(value = "/do", method = RequestMethod.GET)
    public String defaultDo(@RequestParam("param") String param, Model model){
        log.info("doing......");

//        Endpoint ep = Endpoint.publish("http://my.server.com/mywebservice/", new WebserviceImpl());
//        ep.getBinding().getHandlerChain().add(new SOAPLoggingHandler());
        try {
            wsSecurityServiceClient.testAuth(param);
        } catch (WebServiceException_Exception e) {
            log.error("Caught WebServiceException_Exception: ", e);
        }
        return "";
    }
}
