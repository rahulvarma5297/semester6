package org.oorsprong.www.websamples_countryinfo;

public class CountryInfoServiceSoapTypeProxy implements org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapType {
  private String _endpoint = null;
  private org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapType countryInfoServiceSoapType = null;
  
  public CountryInfoServiceSoapTypeProxy() {
    _initCountryInfoServiceSoapTypeProxy();
  }
  
  public CountryInfoServiceSoapTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCountryInfoServiceSoapTypeProxy();
  }
  
  private void _initCountryInfoServiceSoapTypeProxy() {
    try {
      countryInfoServiceSoapType = (new org.oorsprong.www.websamples_countryinfo.CountryInfoServiceLocator()).getCountryInfoServiceSoap();
      if (countryInfoServiceSoapType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)countryInfoServiceSoapType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)countryInfoServiceSoapType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (countryInfoServiceSoapType != null)
      ((javax.xml.rpc.Stub)countryInfoServiceSoapType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapType getCountryInfoServiceSoapType() {
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType;
  }
  
  public org.oorsprong.www.websamples_countryinfo.TContinent[] listOfContinentsByName() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfContinentsByName();
  }
  
  public org.oorsprong.www.websamples_countryinfo.TContinent[] listOfContinentsByCode() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfContinentsByCode();
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCurrency[] listOfCurrenciesByName() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfCurrenciesByName();
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCurrency[] listOfCurrenciesByCode() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfCurrenciesByCode();
  }
  
  public java.lang.String currencyName(java.lang.String sCurrencyISOCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.currencyName(sCurrencyISOCode);
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCountryCodeAndName[] listOfCountryNamesByCode() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfCountryNamesByCode();
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCountryCodeAndName[] listOfCountryNamesByName() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfCountryNamesByName();
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCountryCodeAndNameGroupedByContinent[] listOfCountryNamesGroupedByContinent() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfCountryNamesGroupedByContinent();
  }
  
  public java.lang.String countryName(java.lang.String sCountryISOCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.countryName(sCountryISOCode);
  }
  
  public java.lang.String countryISOCode(java.lang.String sCountryName) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.countryISOCode(sCountryName);
  }
  
  public java.lang.String capitalCity(java.lang.String sCountryISOCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.capitalCity(sCountryISOCode);
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCurrency countryCurrency(java.lang.String sCountryISOCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.countryCurrency(sCountryISOCode);
  }
  
  public java.lang.String countryFlag(java.lang.String sCountryISOCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.countryFlag(sCountryISOCode);
  }
  
  public java.lang.String countryIntPhoneCode(java.lang.String sCountryISOCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.countryIntPhoneCode(sCountryISOCode);
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCountryInfo fullCountryInfo(java.lang.String sCountryISOCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.fullCountryInfo(sCountryISOCode);
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCountryInfo[] fullCountryInfoAllCountries() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.fullCountryInfoAllCountries();
  }
  
  public org.oorsprong.www.websamples_countryinfo.TCountryCodeAndName[] countriesUsingCurrency(java.lang.String sISOCurrencyCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.countriesUsingCurrency(sISOCurrencyCode);
  }
  
  public org.oorsprong.www.websamples_countryinfo.TLanguage[] listOfLanguagesByName() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfLanguagesByName();
  }
  
  public org.oorsprong.www.websamples_countryinfo.TLanguage[] listOfLanguagesByCode() throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.listOfLanguagesByCode();
  }
  
  public java.lang.String languageName(java.lang.String sISOCode) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.languageName(sISOCode);
  }
  
  public java.lang.String languageISOCode(java.lang.String sLanguageName) throws java.rmi.RemoteException{
    if (countryInfoServiceSoapType == null)
      _initCountryInfoServiceSoapTypeProxy();
    return countryInfoServiceSoapType.languageISOCode(sLanguageName);
  }
  
  
}