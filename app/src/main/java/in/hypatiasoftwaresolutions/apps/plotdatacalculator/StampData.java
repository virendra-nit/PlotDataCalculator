package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import java.io.Serializable;

/**
 * Created by viru on 3/19/2017.
 */
public class StampData implements Serializable {
    public double plotsize;
    public  MeasuringUnit unit;
    public int  circlerate,purchase,advocatefee,mutation,otherfee,maliyat,stampduty,courtfee,id;
    public String dateofentry;
    Gender gender;
    boolean corner,nearcity;
    public StampData(int id,int purchase, double plotsize, int circlerate, int advocatefee, int mutation, int otherfee,int maliyat,int stampduty,int courtfee, Gender gender, boolean corner, boolean nearcity,String dateofentry)
    {
        this.id=id;
        this.purchase=purchase;
        this.plotsize=plotsize;
        this.circlerate=circlerate;
        this.advocatefee=advocatefee;
        this.mutation=mutation;
        this.otherfee=otherfee;
        this.maliyat=maliyat;
        this.stampduty=stampduty;
        this.courtfee=courtfee;
        this.gender=gender;
        this.corner=corner;
        this.nearcity=nearcity;
        this.dateofentry=dateofentry;

    }
    public StampData(Object data)
    {
        String str="" + data;
        str=str.trim();
        String[] strings=str.split("~");
        this.id=Integer.parseInt( strings[0]);
        this.purchase=Integer.parseInt( strings[1]);
        this.plotsize=Integer.parseInt( strings[2]);
        this.circlerate=Integer.parseInt( strings[3]);
        this.advocatefee=Integer.parseInt( strings[4]);
        this.mutation=Integer.parseInt( strings[5]);
        this.otherfee=Integer.parseInt( strings[6]);
        this.maliyat=Integer.parseInt( strings[7]);
        this.stampduty=Integer.parseInt( strings[8]);
        this.courtfee=Integer.parseInt( strings[9]);
        if(strings[10].trim().toLowerCase().equals("male"))
        this.gender=Gender.Male;
        else
        this.gender=Gender.Female;
        if(strings[11].trim().toLowerCase().equals("1"))
        this.nearcity=true;
        else
        this.nearcity=false;
        if(strings[12].trim().equals("1"))
        this.corner=true;
        else
        this.corner=true;
        this.dateofentry=strings[13];
    }
    public String toString()
    {
        return "Data"+
                "{"+
                "id="+id+
                "purchase="+purchase+
                "plotsize="+plotsize+
                "circlerate="+circlerate+
                "advocatefee="+advocatefee+
                "mutation="+mutation+
                "otherfee="+otherfee+
                "maliyat="+maliyat+
                "stampduty="+stampduty+
                "courtfee="+courtfee+
                "gender="+gender+
                "corner="+corner+
                "nearcity="+nearcity+
                "Date of entry=" + dateofentry +
                "}";
    }
}
