package DefaultNamespace;

public class TemperatureProxy implements DefaultNamespace.Temperature {
  private String _endpoint = null;
  private DefaultNamespace.Temperature temperature = null;
  
  public TemperatureProxy() {
    _initTemperatureProxy();
  }
  
  public TemperatureProxy(String endpoint) {
    _endpoint = endpoint;
    _initTemperatureProxy();
  }
  
  private void _initTemperatureProxy() {
    try {
      temperature = (new DefaultNamespace.TemperatureServiceLocator()).getTemperature();
      if (temperature != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)temperature)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)temperature)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (temperature != null)
      ((javax.xml.rpc.Stub)temperature)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.Temperature getTemperature() {
    if (temperature == null)
      _initTemperatureProxy();
    return temperature;
  }
  
  public double convert(double f) throws java.rmi.RemoteException{
    if (temperature == null)
      _initTemperatureProxy();
    return temperature.convert(f);
  }
  
  
}