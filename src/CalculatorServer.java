/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import CalculatorApp.calculator;
import CalculatorApp.calculatorHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 * @author Sugata
 */
public class CalculatorServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpos = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpos.the_POAManager().activate();
            CalculatorImpl calImpl = new CalculatorImpl();
            calImpl.setORB(orb);
            org.omg.CORBA.Object ref = rootpos.servant_to_reference(calImpl);
            calculator href = calculatorHelper.narrow(ref);
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name = "calculator";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);
            System.out.println("HelloServer ready and waiting ...");
            orb.run();

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        System.out.println("HelloServer Exiting ...");
    }

}
