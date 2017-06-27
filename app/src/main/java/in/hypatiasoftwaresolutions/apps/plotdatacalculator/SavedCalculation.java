package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

//import com.example.viru.plotdatacalculator.R;

import java.util.List;

public class SavedCalculation extends AppCompatActivity {
    ListView lv;
    StampData data;
    Button DeleteAllData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_calculation);
        DeleteAllData=(Button)findViewById(R.id.btndelete);
       // Intent  intent=getIntent();
       // data=(StampData)getIntent().getSerializableExtra("data");
        lv=(ListView)findViewById(R.id.lv);
      //  List<Data> lst=DatabaseUtilities.select(this);
        List<StampData> lst=DatabaseUtilities.select(this);
        if (lst==null)
            setTitle("null");
        else
            setTitle(""+lst.size());
       TableAdapter adapter=new TableAdapter(this,lst);
        lv.setAdapter(adapter);

    }
    public  void DeleteAll(View view)
    {
        DatabaseUtilities.deleteAll(this);
    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_saved_calculation, menu);
        return true;
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
