/**
 * ChatService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface ChatService extends javax.xml.rpc.Service {
    public java.lang.String getChatAddress();

    public DefaultNamespace.Chat getChat() throws javax.xml.rpc.ServiceException;

    public DefaultNamespace.Chat getChat(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
