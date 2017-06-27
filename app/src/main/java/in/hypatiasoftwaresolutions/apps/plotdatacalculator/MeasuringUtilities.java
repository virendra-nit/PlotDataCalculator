package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

/**
 * Created by viru on 2/28/2017.
 */
public class MeasuringUtilities {
    public static double ConvertToSquareMetres(double size,MeasuringUnit inputunit)
    {
        double retvalue;
        switch(inputunit)
        {
            case Hectare:
                retvalue=size * Constants.HectareToMetres*Constants.HectareToMetres;
                break;
            case SquareFeet:
                retvalue=size * Constants.FeetToMetres*Constants.FeetToMetres;
                break;
            case SquareYard:
                retvalue=size * Constants.YardToMetres*Constants.YardToMetres;
                break;
            default:retvalue=size;
        }
        return RoundTo4( retvalue);
    }


    public static double RoundTo4(double  number)
    {
        double value=Math.round(number*10000);
        value=value/10000;
        return value;
    }
    public static int RoundTo500(int amount)
    {
        int rem=amount % 500;
        if(rem==0)
            return amount;
        int lower=amount-rem;
        int upper =lower + 500;
        return upper;
    }
    public static int RoundoffTo1(double  amount)
    {
        double res= (amount%1);
        if(res==0.0)
            return (int) amount;
        double a=amount-res;
        if(res<0.5)
            return (int) a;
        return (int) a+1;
    }
}
