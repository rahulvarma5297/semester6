package DefaultNamespace;

public class ChatProxy implements DefaultNamespace.Chat {
  private String _endpoint = null;
  private DefaultNamespace.Chat chat = null;
  
  public ChatProxy() {
    _initChatProxy();
  }
  
  public ChatProxy(String endpoint) {
    _endpoint = endpoint;
    _initChatProxy();
  }
  
  private void _initChatProxy() {
    try {
      chat = (new DefaultNamespace.ChatServiceLocator()).getChat();
      if (chat != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)chat)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)chat)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (chat != null)
      ((javax.xml.rpc.Stub)chat)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.Chat getChat() {
    if (chat == null)
      _initChatProxy();
    return chat;
  }
  
  public java.lang.String chat(java.lang.String str) throws java.rmi.RemoteException{
    if (chat == null)
      _initChatProxy();
    return chat.chat(str);
  }
  
  
}