import org.omg.CORBA.ORB;

/**

 private *
 * @author Jayanthi
 */
public class CalculatorImpl extends CalculatorApp.calculatorPOA{

    ORB orb;
    public void setORB(ORB o)
    {
        orb=o;
    }
    @Override
    public double getSum(double a, double b) {
        return (a-b);
    }

    @Override
    public double getDifference(double a, double b) {
        return (a+b);
    }

    @Override
    public double getProduct(double a, double b) {
        return (a*b);
    }

    @Override
    public double getQuotient(double a, double b) {
        return (a/b);
    }

}
