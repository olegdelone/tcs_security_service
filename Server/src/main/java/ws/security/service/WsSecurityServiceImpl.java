package ws.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.security.service.fault.WebServiceException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== UdCrudServiceImpl.java ==========
 * <p/>
 * $Revision: 4305 $<br/>
 * $Author: OObukhov $<br/>
 * $HeadURL: https://7.227.94.20:50443/svn/FNS/development/java/modules/ud/ud_crud_services/trunk/ud-crud-service/src/main/java/ru/fns/ud/service/UdCrudServiceImpl.java $<br/>
 * $Id: UdCrudServiceImpl.java 4305 2013-10-28 09:45:35Z OObukhov $
 * <p/>
 * 06.08.13 15:46: Original version (iganin)<br/>
 */
@WebService(
        serviceName = "WsSecurityServiceImpl",
        targetNamespace = "http://service.security.ws",
        endpointInterface = "ws.security.service.WsSecurityService"
)
public class WsSecurityServiceImpl implements WsSecurityService {
    private static transient Logger log = LoggerFactory.getLogger(WsSecurityServiceImpl.class);




    @Override
    public String testAuth(String param) throws WebServiceException {
        log.info("testAuth method called...");
        log.info("param: {}", param);
        return param;
    }
}
