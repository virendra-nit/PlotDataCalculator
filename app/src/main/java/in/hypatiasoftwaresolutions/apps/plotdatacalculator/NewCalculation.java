package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

//import com.example.viru.plotdatacalculator.R;

public class NewCalculation extends AppCompatActivity {
    EditText epurchase,eplotsize,ecirclerate,eadvocatfee,emutation,eotherfee;
    Gender gender;
    RadioButton female,male;
    CheckBox checkBoxcorner,checkBoxnearcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_calculation);
        epurchase=(EditText)findViewById(R.id.epurchase);
        eplotsize=(EditText)findViewById(R.id.eplotsize);
        ecirclerate=(EditText)findViewById(R.id.ecirclerate);
        eadvocatfee=(EditText)findViewById(R.id.eadvocatefee);
        emutation=(EditText)findViewById(R.id.emutation);
        eotherfee=(EditText)findViewById(R.id.eotherfee);
        female=(RadioButton)findViewById(R.id.btnfemale);
        male=(RadioButton)findViewById(R.id.btnmale);
        checkBoxcorner=(CheckBox)findViewById(R.id.checkBoxcorner);
        checkBoxnearcity=(CheckBox)findViewById(R.id.checkBoxnearcity);
    }


    public  void stampduty(View view)
    {
        try {
            int purchase=Integer.parseInt("" + epurchase.getText());
            double plotsize=Double.parseDouble("" + eplotsize.getText());
            int circlerate=Integer.parseInt("" + ecirclerate.getText());
            int advocatefee=Integer.parseInt("" + eadvocatfee.getText());
            int mutation=Integer.parseInt(""+emutation.getText());
            int otherfee=Integer.parseInt(""+eotherfee.getText());
            Gender gender=Gender.None;
            //********************************************************************************************************************
            if (female.isChecked())
                gender = Gender.Female;
            if (male.isChecked())
                gender = Gender.Male;
            if (gender == Gender.None)
                throw new Exception("Gender not selected");
            //********************************************************************************************************************
            Data data=new Data(purchase,plotsize,circlerate,advocatefee,mutation,otherfee,gender,checkBoxcorner.isChecked(),checkBoxnearcity.isChecked());
            Intent intent=new Intent(NewCalculation.this,Result_in_table.class);
            intent.putExtra("data",data);
            startActivityForResult(intent,10);

        }
        catch (Exception ex)
        {
            setTitle(ex.getMessage());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_calculation, menu);
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
