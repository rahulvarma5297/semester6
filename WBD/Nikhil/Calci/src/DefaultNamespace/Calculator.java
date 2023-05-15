/**
 * Calculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface Calculator extends java.rmi.Remote {
    public double add(double x, double y) throws java.rmi.RemoteException;
    public double mod(double x, double y) throws java.rmi.RemoteException;
    public double sub(double x, double y) throws java.rmi.RemoteException;
    public double mult(double x, double y) throws java.rmi.RemoteException;
    public double div(double x, double y) throws java.rmi.RemoteException;
}
