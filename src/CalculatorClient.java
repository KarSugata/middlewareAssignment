import CalculatorApp.calculator;
import CalculatorApp.calculatorHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 * @author Sugata Kar
 */
public class CalculatorClient {

    /**
     * @param args the command line arguments
     */
    static calculator calImpl;

    public static void main(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "calculator";
            calImpl = calculatorHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtained a handle on server object: " + calImpl);
            System.out.println(calImpl.getSum(4, 5));
            System.out.println(calImpl.getDifference(5, 4));
            System.out.println(calImpl.getProduct(4, 5));
            System.out.println(calImpl.getQuotient(6, 2));

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

}
