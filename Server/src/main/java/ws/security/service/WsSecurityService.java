package ws.security.service;

import ws.security.service.fault.WebServiceException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== UdCrudService.java ==========
 * <p/>
 * $Revision: 3698 $<br/>
 * $Author: OObukhov $<br/>
 * $HeadURL: https://7.227.94.20:50443/svn/FNS/development/java/modules/ud/ud_crud_services/trunk/ud-crud-service/src/main/java/ru/fns/ud/service/UdCrudService.java $<br/>
 * $Id: UdCrudService.java 3698 2013-10-08 10:49:24Z OObukhov $
 * <p/>
 * 06.08.13 15:37: Original version (iganin)<br/>
 */
@WebService(targetNamespace = "http://service.security.ws")
public interface WsSecurityService {
    @WebMethod
    @WebResult(name = "r")
    String testAuth(@WebParam(name = "param") String param) throws WebServiceException;

}
