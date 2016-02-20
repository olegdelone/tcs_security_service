package ws.security.service.endpoint;

import ws.security.service.generated.TestAuth;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== TestAuthSecurityEndpoint.java ==========
 * <p/>
 * $Revision:  $<br/>
 * $Author:  $<br/>
 * $HeadURL:  $<br/>
 * $Id:  $
 * <p/>
 * 23.12.13 7:53: Original version (OOBUKHOV)<br/>
 */
public class TestAuthSecurityEndpoint extends AbsSecurityEndpoint {
    @Override
    protected Object invokeInternal(Object request) throws Exception {
        TestAuth testAuth = (TestAuth)request;

        return securityService.testAuth(testAuth.getParam());
    }
}
