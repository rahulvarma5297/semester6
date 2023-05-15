/**
 * ChatServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class ChatServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.ChatService {

    public ChatServiceLocator() {
    }


    public ChatServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ChatServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Chat
    private java.lang.String Chat_address = "http://localhost:8080/Chatserver/services/Chat";

    public java.lang.String getChatAddress() {
        return Chat_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ChatWSDDServiceName = "Chat";

    public java.lang.String getChatWSDDServiceName() {
        return ChatWSDDServiceName;
    }

    public void setChatWSDDServiceName(java.lang.String name) {
        ChatWSDDServiceName = name;
    }

    public DefaultNamespace.Chat getChat() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Chat_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getChat(endpoint);
    }

    public DefaultNamespace.Chat getChat(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.ChatSoapBindingStub _stub = new DefaultNamespace.ChatSoapBindingStub(portAddress, this);
            _stub.setPortName(getChatWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setChatEndpointAddress(java.lang.String address) {
        Chat_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.Chat.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.ChatSoapBindingStub _stub = new DefaultNamespace.ChatSoapBindingStub(new java.net.URL(Chat_address), this);
                _stub.setPortName(getChatWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Chat".equals(inputPortName)) {
            return getChat();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "ChatService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "Chat"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Chat".equals(portName)) {
            setChatEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
