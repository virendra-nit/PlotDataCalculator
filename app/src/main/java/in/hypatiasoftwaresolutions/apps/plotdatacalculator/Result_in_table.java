package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

//import com.example.viru.plotdatacalculator.R;

public class Result_in_table extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5;
    EditText e1,e2,e3,e4,e5,e6,e7;
    ListView lv;
    Button btn;
    Data data;
    int maliyat=0,stampduty=0,courtfee=0,otherfee=0,advocatefee=0;
    boolean debug=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_in_table);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        tv5=(TextView)findViewById(R.id.tv5);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        e6=(EditText)findViewById(R.id.e6);
        e7=(EditText)findViewById(R.id.e7);
        btn=(Button)findViewById(R.id.btn);
        Intent intent=getIntent();
        data=(Data)intent.getSerializableExtra("data");
      //  data=(StampData)intent.getSerializableExtra("data");
        if( (data.corner))
            maliyat = SaleUtilities.GetMaliat(data.plotsize, MeasuringUnit.SquareFeet, data.circlerate, 10);
        else
            maliyat = SaleUtilities.GetMaliat(data.plotsize, MeasuringUnit.SquareFeet, data.circlerate);

        stampduty = SaleUtilities.StampDuty(maliyat, data.nearcity, data.gender);
        courtfee=SaleUtilities.CoutFee(maliyat);
        otherfee=SaleUtilities.OtherFee(maliyat,data.otherfee);
        e1.setText(""+maliyat);
        e2.setText(""+stampduty);
        e3.setText(""+courtfee);
        e4.setText(""+otherfee);
        e5.setText(""+data.advocatefee);
        e6.setText(""+data.mutation);
        int total=0;
        int advocatefee=Integer.parseInt(""+data.advocatefee);
        int mutation=Integer.parseInt(""+data.mutation);
        total=stampduty+courtfee+otherfee+advocatefee+mutation;
        e7.setText(""+total);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_result_in_table, menu);
        return true;
    }
    public  void doback(View view)
    {
        finish();
    }
//********************************************************************************************************************

    public void dosave(View view)
    {
        try {
            int bcorner,bnearcity;
            if(data.corner)
                bcorner=1;
            else
                bcorner=0;
            if (data.nearcity)
                bnearcity=1;
            else
                bnearcity=0;
            Gender gender=data.gender;

            // String str=DatabaseUtilities.insertTable(this,data.purchase,data.plotsize,data.circlerate,data.advocatefee,data.mutation,data.otherfee,maliyat,stampduty,courtfee,"male",bnearcity,bcorner);
            String b=DatabaseUtilities.insertTable(this,data.purchase,data.plotsize,data.circlerate,data.advocatefee,data.mutation,data.otherfee,maliyat,stampduty,courtfee,"" + gender,bnearcity,bcorner);
            setTitle(b);

        }
        catch (Exception ex)
        {
            setTitle(ex.getMessage());
        }
    }
    //***********************************************************************************************************************************

    //****************************************************************************************************************
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
