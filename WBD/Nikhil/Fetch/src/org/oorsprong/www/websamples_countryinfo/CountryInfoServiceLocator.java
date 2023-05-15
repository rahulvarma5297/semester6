/**
 * CountryInfoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.oorsprong.www.websamples_countryinfo;

public class CountryInfoServiceLocator extends org.apache.axis.client.Service implements org.oorsprong.www.websamples_countryinfo.CountryInfoService {

/**
 * This DataFlex Web Service opens up country information. 2 letter
 * ISO codes are used for Country code. There are functions to retrieve
 * the used Currency, Language, Capital City, Continent and Telephone
 * code.
 */

    public CountryInfoServiceLocator() {
    }


    public CountryInfoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CountryInfoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CountryInfoServiceSoap
    private java.lang.String CountryInfoServiceSoap_address = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";

    public java.lang.String getCountryInfoServiceSoapAddress() {
        return CountryInfoServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CountryInfoServiceSoapWSDDServiceName = "CountryInfoServiceSoap";

    public java.lang.String getCountryInfoServiceSoapWSDDServiceName() {
        return CountryInfoServiceSoapWSDDServiceName;
    }

    public void setCountryInfoServiceSoapWSDDServiceName(java.lang.String name) {
        CountryInfoServiceSoapWSDDServiceName = name;
    }

    public org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapType getCountryInfoServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CountryInfoServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCountryInfoServiceSoap(endpoint);
    }

    public org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapType getCountryInfoServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapBindingStub _stub = new org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCountryInfoServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCountryInfoServiceSoapEndpointAddress(java.lang.String address) {
        CountryInfoServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapBindingStub _stub = new org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapBindingStub(new java.net.URL(CountryInfoServiceSoap_address), this);
                _stub.setPortName(getCountryInfoServiceSoapWSDDServiceName());
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
        if ("CountryInfoServiceSoap".equals(inputPortName)) {
            return getCountryInfoServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CountryInfoServiceSoap".equals(portName)) {
            setCountryInfoServiceSoapEndpointAddress(address);
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
