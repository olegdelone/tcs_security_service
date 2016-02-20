package ws.security.service.endpoint;

import ws.security.service.generated.WsSecurityService;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== AbsSecurityEndpoint.java ==========
 * <p/>
 * $Revision:  $<br/>
 * $Author:  $<br/>
 * $HeadURL:  $<br/>
 * $Id:  $
 * <p/>
 * 23.12.13 7:52: Original version (OOBUKHOV)<br/>
 */
public abstract class AbsSecurityEndpoint {

    protected WsSecurityService securityService;

    public void setSecurityService(WsSecurityService securityService) {
        this.securityService = securityService;
    }

    protected abstract Object invokeInternal(Object request) throws Exception;
}
