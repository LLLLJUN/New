package com.ws.service;

public class SaleWebServiceProxy implements com.ws.service.SaleWebService {
  private String _endpoint = null;
  private com.ws.service.SaleWebService saleWebService = null;
  
  public SaleWebServiceProxy() {
    _initSaleWebServiceProxy();
  }
  
  public SaleWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSaleWebServiceProxy();
  }
  
  private void _initSaleWebServiceProxy() {
    try {
      saleWebService = (new com.ws.service.SaleWebServiceServiceLocator()).getSaleWebServicePort();
      if (saleWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)saleWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)saleWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (saleWebService != null)
      ((javax.xml.rpc.Stub)saleWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ws.service.SaleWebService getSaleWebService() {
    if (saleWebService == null)
      _initSaleWebServiceProxy();
    return saleWebService;
  }
  
  public java.lang.String querySaleBaseAndSaleWorstData(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (saleWebService == null)
      _initSaleWebServiceProxy();
    return saleWebService.querySaleBaseAndSaleWorstData(arg0, arg1);
  }
  
  public java.lang.String querySaleBestWorstData(java.lang.String arg0) throws java.rmi.RemoteException{
    if (saleWebService == null)
      _initSaleWebServiceProxy();
    return saleWebService.querySaleBestWorstData(arg0);
  }
  
  public java.lang.String queryByTimeSalesVolume(java.lang.String arg0) throws java.rmi.RemoteException{
    if (saleWebService == null)
      _initSaleWebServiceProxy();
    return saleWebService.queryByTimeSalesVolume(arg0);
  }
  
  public java.lang.String querySaleData(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (saleWebService == null)
      _initSaleWebServiceProxy();
    return saleWebService.querySaleData(arg0, arg1);
  }
  
  
}