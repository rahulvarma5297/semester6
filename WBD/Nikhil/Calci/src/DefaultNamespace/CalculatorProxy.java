package DefaultNamespace;

public class CalculatorProxy implements DefaultNamespace.Calculator {
  private String _endpoint = null;
  private DefaultNamespace.Calculator calculator = null;
  
  public CalculatorProxy() {
    _initCalculatorProxy();
  }
  
  public CalculatorProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculatorProxy();
  }
  
  private void _initCalculatorProxy() {
    try {
      calculator = (new DefaultNamespace.CalculatorServiceLocator()).getCalculator();
      if (calculator != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculator)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculator != null)
      ((javax.xml.rpc.Stub)calculator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.Calculator getCalculator() {
    if (calculator == null)
      _initCalculatorProxy();
    return calculator;
  }
  
  public double add(double x, double y) throws java.rmi.RemoteException{
    if (calculator == null)
      _initCalculatorProxy();
    return calculator.add(x, y);
  }
  
  public double mod(double x, double y) throws java.rmi.RemoteException{
    if (calculator == null)
      _initCalculatorProxy();
    return calculator.mod(x, y);
  }
  
  public double sub(double x, double y) throws java.rmi.RemoteException{
    if (calculator == null)
      _initCalculatorProxy();
    return calculator.sub(x, y);
  }
  
  public double mult(double x, double y) throws java.rmi.RemoteException{
    if (calculator == null)
      _initCalculatorProxy();
    return calculator.mult(x, y);
  }
  
  public double div(double x, double y) throws java.rmi.RemoteException{
    if (calculator == null)
      _initCalculatorProxy();
    return calculator.div(x, y);
  }
  
  
}