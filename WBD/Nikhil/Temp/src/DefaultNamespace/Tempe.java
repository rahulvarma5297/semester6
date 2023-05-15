package DefaultNamespace;

import java.rmi.RemoteException;

public class Tempe {
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		TemperatureProxy obj = new TemperatureProxy();
		
		double f = 100;
		double c = obj.convert(f);
		System.out.println(c);
	}
}
