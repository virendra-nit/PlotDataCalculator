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

public class Data_in_Database extends AppCompatActivity {
    EditText epurchase,eplotsize,ecirclerate,eadvocatfee,emutation,eotherfee;
    Gender gender;
    RadioButton female,male;
    CheckBox checkBoxcorner,checkBoxnearcity;
    StampData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        boolean debug=true;
        setContentView(R.layout.activity_data_in__database);

       // Data data=(Data)getIntent().getSerializableExtra("data");
        data=(StampData)getIntent().getSerializableExtra("data");
        epurchase=(EditText)findViewById(R.id.epurchase);
        epurchase.setText(""+data.purchase);
        eplotsize=(EditText)findViewById(R.id.eplotsize);
        eplotsize.setText(""+data.plotsize);
        ecirclerate=(EditText)findViewById(R.id.ecirclerate);
        ecirclerate.setText(""+data.circlerate);

        eadvocatfee=(EditText)findViewById(R.id.eadvocatefee);
        eadvocatfee.setText(""+data.advocatefee);
        emutation=(EditText)findViewById(R.id.emutation);
        emutation.setText(""+data.mutation);
        eotherfee=(EditText)findViewById(R.id.eotherfee);
        eotherfee.setText(""+data.otherfee);
        female=(RadioButton)findViewById(R.id.btnfemale);
        male=(RadioButton)findViewById(R.id.btnmale);
        if(data.gender==Gender.Male)
            male.setChecked(true);
        else
        female.setChecked(true);
        male.setEnabled(false);
        female.setEnabled(false);
        checkBoxcorner=(CheckBox)findViewById(R.id.chnearcorner);
        checkBoxnearcity=(CheckBox)findViewById(R.id.chnearcity);

        if (data.nearcity)
            checkBoxnearcity.setChecked(true);
         else
            checkBoxnearcity.setChecked(false);
            checkBoxnearcity.setEnabled(false);


        if (data.corner)
            checkBoxcorner.setChecked(true);
        else
            checkBoxcorner.setChecked(false);

            checkBoxcorner.setEnabled(false);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_data_in__database, menu);
        return true;
    }
    public  void doNext(View view)
    {
       // StampData data=new StampData()
       // StampData data=(StampData)getIntent().getSerializableExtra("data");
        Intent intent=new Intent(this,Next_Data_in_Database.class);
        intent.putExtra("data",data);
        startActivityForResult(intent, 10);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
