package org.oorsprong.www.websamples_countryinfo;

import java.rmi.RemoteException;

public class TestWS {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		CountryInfoServiceSoapTypeProxy obj = new CountryInfoServiceSoapTypeProxy();
		String s = obj.capitalCity("IN");
		TCountryInfo si = obj.fullCountryInfo("IN");
		System.out.println(s);
		System.out.println(si);
	}
}
