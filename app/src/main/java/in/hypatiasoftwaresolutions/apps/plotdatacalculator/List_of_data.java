package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.example.viru.plotdatacalculator.R;

public class List_of_data extends AppCompatActivity {
    TextView tv;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_data);
        tv=(TextView)findViewById(R.id.tv);
        b=(Button)findViewById(R.id.btn1);
    }
   /* public  void see(View view)
    {
        try {
            Intent intent = new Intent(this, Data_in_Database.class);
            startActivity(intent);
         }
        catch (Exception ex)
        {
            setTitle(ex.getMessage());
        }

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_of_data, menu);
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
