package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

/**
 * Created by viru on 2/28/2017.
 */
public class SaleUtilities {
    public static int GetMaliat(double plotsize,MeasuringUnit unit,int circlerate,int cornerchargerate)
    {
        double plotsizeInMeter= MeasuringUtilities.ConvertToSquareMetres(plotsize, unit);
        int maliyat;
        double cornercharge=(circlerate* cornerchargerate)/100;

        maliyat=(int) (plotsizeInMeter*(circlerate+cornercharge));
        return maliyat;

    }
    public static int GetMaliat(double plotsize,MeasuringUnit unit,int circlerate)
    {
        double plotsizeInMeter= MeasuringUtilities.ConvertToSquareMetres(plotsize, unit);
        int maliyat;
        maliyat=(int) (plotsizeInMeter*circlerate);
        return maliyat;
    }
    public static int StampDuty(int maliyat,boolean isNearCity,Gender gender)
    {
        int stampDuty = 0;
        if(maliyat>=1000000)
        {
            stampDuty= (int) ((maliyat*7)/100);
            if(gender== Gender.Female)
                stampDuty-=10000;
            return MeasuringUtilities.RoundTo500(stampDuty);
        }

        if(gender== Gender.Male )
        {
            if(isNearCity)
                stampDuty= (int) ((maliyat*7)/100);
            else
                stampDuty= (int) ((maliyat*5)/100);
            return MeasuringUtilities.RoundTo500(stampDuty);
        }

        if(isNearCity)
            stampDuty= (int) ((maliyat*6)/100);
        else
            stampDuty= (int) ((maliyat*4)/100);
        // stampDuty =MeasuringUtilities.RoundTo500(stampDuty);
        return MeasuringUtilities.RoundTo500(stampDuty);
    }
    public static int CoutFee(int maliyat)
    {
        if(maliyat<1000000)
        {
            double amount=((maliyat*2)/100);
            return MeasuringUtilities.RoundoffTo1(amount);
        }
        return 20100;
    }
    public static int OtherFee(int maliyat,double percentage)
    {
        double amount=((maliyat*percentage)/100);
        return MeasuringUtilities.RoundoffTo1(amount);
    }

}
