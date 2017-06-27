package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viru on 3/11/2017.
 */
public class DatabaseUtilities
{
    //****************************************************************************************************************************************
    public static  boolean createTable(Context context)
    {
        DBHelper helper=new DBHelper(context);
        SQLiteDatabase database=helper.getWritableDatabase();
        try {
           // database.execSQL("drop table records");
            //database.execSQL("create table records(id INTEGER PRIMARY KEY AUTOINCREMENT,purchase INTEGER,plotsize INTEGER,circlerate INTEGER,advocatefee INTEGER,mutation INTEGER,otherfee INTEGER,maliyat INTEGER,stampduty INTEGER,courtfee INTEGER,gender text,nearcity INTEGER,corner INTEGER,dateofentry TEXT)");
            database.execSQL("create table records(id INTEGER PRIMARY KEY AUTOINCREMENT,purchase INTEGER,plotsize INTEGER,circlerate INTEGER,advocatefee INTEGER,mutation INTEGER,otherfee INTEGER,maliyat INTEGER,stampduty INTEGER,courtfee INTEGER,gender text,nearcity INTEGER,corner INTEGER,dateofentry TEXT)");
            return true;

        }
        catch (Exception ex)
        {
            System.out.println(ex);
            return false;
        }
    }
    //*******************************************************************************************************************************
    public  static  String insertTable(Context context,int purchase,double plotsize,int circlerate,int advocatefee,int mutation,int otherfee,int maliyat,int stampduty,int courtfee,String gender,int nearcity,int corner)
    {
        DBHelper helper=new DBHelper(context);
        SQLiteDatabase database=helper.getWritableDatabase();
        try{
            ContentValues values =new ContentValues();
            values.put("purchase",purchase);
            values.put("plotsize",plotsize);
            values.put("circlerate",circlerate);
            values.put("advocatefee",advocatefee);
            values.put("mutation",mutation);
            values.put("otherfee",otherfee);
            values.put("maliyat",maliyat);
            values.put("stampduty",stampduty);
            values.put("courtfee",courtfee);
            values.put("gender",gender);
            values.put("nearcity",nearcity);
            values.put("corner",corner);
            values.put("dateofentry",DateUtilities.getCurrentDate());
            long n=  database.insert("records",null,values);
            return "" + n;

        }
        catch (Exception ex)
        {
            System.out.println(ex);
            return  "" + ex;
        }
    }
    //*****************************************************************************
    public  static String deleteAll(Context context)
    {
        DBHelper helper=new DBHelper(context);
        SQLiteDatabase database=helper.getWritableDatabase();
        try
        {

            long n= database.delete("records",null,null);
            return ""+n;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            return ""+ex;
        }
    }


    //***********************************************************************************************************************************
    public  static String deleteTable(Context context,int id)
    {
        DBHelper helper=new DBHelper(context);
        SQLiteDatabase database=helper.getWritableDatabase();
        try
        {
            String[] args={""+id};
            long n= database.delete("records","id=?",args);
            return ""+n;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            return ""+ex;
        }
    }
    //*****************************************************************************
    public static List<String> getUrls(Context context)
    {
        List<String> lst=new ArrayList<>();
        DBHelper helper=new DBHelper(context);
        SQLiteDatabase database=helper.getReadableDatabase();
        try {
           // String url="http://jijaji.hypatiasoftwaresolutions.in/insertplotdata.aspx?id=45&purchaseamount=500000&plotsize=1000&&circlerate=5000&advocatefee=100&mutation=1200&otherfee=0&maliyat=1000000&stampduty=21000&gender=Female&nearcity=1&corner=0&dateofentry=21-Apr-2016";
            String[] columns={"id","purchase","plotsize","circlerate","advocatefee","mutation","otherfee","maliyat","stampduty","courtfee","gender","corner","nearcity","dateofentry"};
            Cursor cursor=database.query(false, "records", columns, null, null, null, null, null, null);
            while (cursor.moveToNext())
            {
                int id=cursor.getInt(0);
                int purchase=cursor.getInt(1);
                double plotsize=cursor.getDouble(2);
                int circlerate=cursor.getInt(3);
                int advocatefee=cursor.getInt(4);
                int mutation=cursor.getInt(5);
                int otherfee=cursor.getInt(6);
                int maliyat=cursor.getInt(7);
                int stampduty=cursor.getInt(8);
                int courtfee=cursor.getInt(9);
                String gender=cursor.getString(10);
                Gender gndr=Gender.Male;
                if(gender.trim().toLowerCase().equals("female"))
                    gndr=Gender.Female;
                int corner=cursor.getInt(11);



                int nearcity=cursor.getInt(12);

                String dateofentry=cursor.getString(13);


                // Data data=new Data(purchase,plotsize,circlerate,advocatefee,mutation,otherfee,gndr,corn,ncity);
                String newurl="http://jijaji.hypatiasoftwaresolutions.in/insertplotdata.aspx?id=" +  id + "&purchaseamount=" + purchase + "&plotsize=" + plotsize + "&circlerate=" + circlerate + "&advocatefee=" + advocatefee + "&mutation=" + mutation + "&otherfee=" + otherfee + "&maliyat=" + maliyat + "&stampduty=" + stampduty + "&courtfee=" +courtfee +"&gender=" + gndr + "&nearcity=" + nearcity +"&corner=" + corner + "&dateofentry=" +dateofentry;

                lst.add(newurl);

            }

        }catch (Exception ex)
        {
            System.out.println(ex);
        }
      return lst;
    }
    //*************************************************************************
    //************************************************************************************************************************************
    public static List<StampData> select(Context context)
    {
        List<StampData> lst=new ArrayList<>();
        DBHelper helper=new DBHelper(context);
        SQLiteDatabase database=helper.getReadableDatabase();
        try {
            String[] columns={"id","purchase","plotsize","circlerate","advocatefee","mutation","otherfee","maliyat","stampduty","courtfee","gender","corner","nearcity","dateofentry"};
            Cursor cursor=database.query(false,"records",columns,null,null,null,null,null,null);

            while (cursor.moveToNext())
            {

                int id=cursor.getInt(0);
                int purchase=cursor.getInt(1);
                double plotsize=cursor.getDouble(2);
                int circlerate=cursor.getInt(3);
                int advocatefee=cursor.getInt(4);
                int mutation=cursor.getInt(5);
                int otherfee=cursor.getInt(6);
                int maliyat=cursor.getInt(7);
                int stampduty=cursor.getInt(8);
                int courtfee=cursor.getInt(9);
                String gender=cursor.getString(10);
                Gender gndr=Gender.Male;
                if(gender.trim().toLowerCase().equals("female"))
                    gndr=Gender.Female;
                int corner=cursor.getInt(11);
                boolean corn=false;
                if (corner==1)
                    corn=true;

                int nearcity=cursor.getInt(12);
                boolean ncity=false;
                if (nearcity==1)
                    ncity=true;
                String dateofentry=cursor.getString(13);


              //  Data data=new Data(purchase,plotsize,circlerate,advocatefee,mutation,otherfee,gndr,corn,ncity);
                StampData data=new StampData(id,purchase,plotsize,circlerate,advocatefee,mutation,otherfee,maliyat,stampduty,courtfee,gndr,corn,ncity,dateofentry);
                lst.add(data);

            }
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        return lst;
    }


}
