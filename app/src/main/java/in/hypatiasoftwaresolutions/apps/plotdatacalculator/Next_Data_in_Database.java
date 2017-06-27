package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

//import com.example.viru.plotdatacalculator.R;

public class Next_Data_in_Database extends AppCompatActivity {
    EditText emaliyat,estampduty,ecourtfee,eotherfee,eadvocatefee,emutation,etotal;
    StampData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next__data_in__database);
       // setTitle(""+data.id);
        emaliyat=(EditText)findViewById(R.id.emaliyat);
        estampduty=(EditText)findViewById(R.id.estampduty);
        ecourtfee=(EditText)findViewById(R.id.ecourtfee);
        eotherfee=(EditText)findViewById(R.id.eotherfee);
        eadvocatefee=(EditText)findViewById(R.id.eadvocatefee);
        emutation=(EditText)findViewById(R.id.emutation);
        etotal=(EditText)findViewById(R.id.etotal);
        data=(StampData)getIntent().getSerializableExtra("data");
        emaliyat.setText(""+data.maliyat);
        estampduty.setText(""+data.stampduty);
        ecourtfee.setText(""+data.courtfee);
        eotherfee.setText(""+data.otherfee);
        eadvocatefee.setText(""+data.advocatefee);
        emutation.setText(""+data.mutation);
        int total=0;
        total=data.maliyat+data.stampduty+data.courtfee+data.otherfee+data.advocatefee;
        etotal.setText(""+total);
        setTitle(""+data.id);
    }
    //**********************************************************************************************************************************
    public void doback(View view)
    {
        finish();
    }
    //********************************************************************************************************************************

    public void doDelete(View view)
    {
        try {
            int id=Integer.parseInt(""+data.id);
            DatabaseUtilities.deleteTable(this,id);
            Intent intent=new Intent(this,SavedCalculation.class);
           // intent.putExtra("data",data);
            startActivityForResult(intent, 10);
        }
        catch (Exception ex)
        {
            setTitle(ex.getMessage());
        }
    }
//*************************************************************************
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
        String b=DatabaseUtilities.insertTable(this,data.purchase,data.plotsize,data.circlerate,data.advocatefee,data.mutation,data.otherfee,data.maliyat,data.stampduty,data.courtfee,"" + gender,bnearcity,bcorner);
        setTitle(b);

    }
    catch (Exception ex)
    {
        setTitle(ex.getMessage());
    }
}
    //*********************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_next__data_in__database, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
