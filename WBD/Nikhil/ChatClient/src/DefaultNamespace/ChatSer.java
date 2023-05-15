package DefaultNamespace;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ChatSer {
	public static void main(String[] args) throws RemoteException {
		ChatProxy inp = new ChatProxy();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String input = sc.next();
		String res = inp.chat(input);
		System.out.println("The string Entered is: "+res);
	}
}