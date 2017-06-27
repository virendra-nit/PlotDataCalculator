package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by viru on 3/11/2017.
 */
public class Utilities
{
    public static String loggedinemail,loggedinname;
    private  static  String[] menuitems={ "PlotDataCalculation","New Calculation","Saved Calculation"," Saved Data In Database"," Downloaded Data","About the App"};
    public static String[] getMenuitems()
    {
        return menuitems;
    }
    public static String pad(int n)
    {
        if(n<=9)
            return "0"+9;
        return ""+n;
    }
    public static List<String> GetDataInList(Object data)
    {
        List<String> lst=new ArrayList<>();
        try
        {
            String str="" + data;
            str=str.trim();
            String[] strings=str.split("#");
            for(int i=0;i<=strings.length-1;i++)
                lst.add(strings[i]);
        }
        catch (Exception ex)
        {
            System.out.println(ex);

        }
        return lst;
    }


//****************************************************************************
    public  static List<StampData> GetData(Object object)
    {
        List<StampData> lst=new ArrayList<>();
        try {


        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        return lst;
    }
    //************************************************************************


    public static String getDataFromURL(String location) throws Exception
    {
        String output="";
        URL url=new URL(location);
        URLConnection conn=url.openConnection();
        Scanner s=new Scanner(conn.getInputStream());
        while (s.hasNextLine())
            output+=s.nextLine();
        return output  ;
    }
    //************************************************
    //************************************************

    public static String encode(String str)
    {
        try
        {
            // str=str;
            return URLEncoder.encode(str, "UTF-8");
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            return str;
        }
    }

    //************************************************
    public  static JSONObject getDatainJSON(Object data) throws Exception
    {
        String output="" +data;
        output=output.trim();
        return  new JSONObject(output);
    }
    public static String[] getJSONName(Object object) throws Exception
    {
        JSONArray names=((JSONObject)object).names();
        String[] String=new String[names.length()];
        for (int i=0;i<=names.length();i++)
            String[i]=""+names.get(i);
        return String;
    }
    public static String getValue(JSONObject object, String names)throws JSONException
    {
     return ""+object.get(names);
    }
}
