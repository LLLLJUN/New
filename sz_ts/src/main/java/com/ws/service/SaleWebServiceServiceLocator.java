/**
 * SaleWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ws.service;

public class SaleWebServiceServiceLocator extends org.apache.axis.client.Service implements com.ws.service.SaleWebServiceService {

    public SaleWebServiceServiceLocator() {
    }


    public SaleWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SaleWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SaleWebServicePort
    private java.lang.String SaleWebServicePort_address = "http://www.echitec.com/sz_ws/services/merchandise";

    public java.lang.String getSaleWebServicePortAddress() {
        return SaleWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SaleWebServicePortWSDDServiceName = "SaleWebServicePort";

    public java.lang.String getSaleWebServicePortWSDDServiceName() {
        return SaleWebServicePortWSDDServiceName;
    }

    public void setSaleWebServicePortWSDDServiceName(java.lang.String name) {
        SaleWebServicePortWSDDServiceName = name;
    }

    public com.ws.service.SaleWebService getSaleWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SaleWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSaleWebServicePort(endpoint);
    }

    public com.ws.service.SaleWebService getSaleWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ws.service.SaleWebServiceServiceSoapBindingStub _stub = new com.ws.service.SaleWebServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSaleWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSaleWebServicePortEndpointAddress(java.lang.String address) {
        SaleWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ws.service.SaleWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ws.service.SaleWebServiceServiceSoapBindingStub _stub = new com.ws.service.SaleWebServiceServiceSoapBindingStub(new java.net.URL(SaleWebServicePort_address), this);
                _stub.setPortName(getSaleWebServicePortWSDDServiceName());
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
        if ("SaleWebServicePort".equals(inputPortName)) {
            return getSaleWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.ws.com/", "SaleWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.ws.com/", "SaleWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SaleWebServicePort".equals(portName)) {
            setSaleWebServicePortEndpointAddress(address);
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
