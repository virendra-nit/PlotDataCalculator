package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import java.io.Serializable;

/**
 * Created by viru on 2/28/2017.
 */
public class Data implements Serializable {
    public double plotsize;
    public  MeasuringUnit unit;
    public int  circlerate,purchase,advocatefee,mutation,otherfee;
    Gender gender;
    boolean corner,nearcity;

    public Data(int purchase, double plotsize, int circlerate, int advocatefee, int mutation, int otherfee, Gender gender, boolean corner, boolean nearcity)
    {
        //this.id=id;
        this.purchase=purchase;
        this.plotsize=plotsize;
        this.circlerate=circlerate;
        this.advocatefee=advocatefee;
        this.mutation=mutation;
        this.otherfee=otherfee;
        this.gender=gender;
        this.corner=corner;
        this.nearcity=nearcity;
    }
    public String toString()
    {
        return "Data" +
                " {"+
               // "id="+id+
                "purchase="+purchase+
                "plotsize="+plotsize+
                "circlerate="+circlerate+
                "advocatefee="+advocatefee+
                "mutation="+mutation+
                "otherfee="+otherfee+
                "gender="+gender+
                "corner="+corner+
                "nearcity="+nearcity+
                "}";
    }


}
