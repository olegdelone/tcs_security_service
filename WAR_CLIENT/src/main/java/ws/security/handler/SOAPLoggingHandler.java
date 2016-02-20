package ws.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

@Component
public class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext> {
    private static transient Logger log = LoggerFactory.getLogger(SOAPLoggingHandler.class);

    private OutputStream outputStream = System.out;//new ByteArrayOutputStream();

    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext smc) {
        log(smc);
        return true;
    }

    public boolean handleFault(SOAPMessageContext smc) {
        log(smc);
        return true;
    }

    // nothing to clean up
    public void close(MessageContext messageContext) {
    }

    private void log(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        SOAPMessage message = smc.getMessage();
        String type;
        if (outboundProperty.booleanValue()) {
            type = "Outbound";
        } else {
            type = "Inbound";
        }
//        log.debug("{} message: {}", type, message);


        try {
            log.debug("------------{}------------------", type);
            message.writeTo(outputStream);
            log.debug("\n------------{}-----------------", type);
        } catch (Exception e) {
            log.error("Caught Exception while writing SOAP message into OutputStream. ", e);
        }
    }
}