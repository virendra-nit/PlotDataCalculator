package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class SavedDataInDataBase extends AppCompatActivity {
    ListView lv;
    StampData data;
    Button saveAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_data_in_data_base);
        lv=(ListView)findViewById(R.id.lv);
        // List<String> lst=DatabaseUtilities.getUrls(this);
         List<String> lst=DatabaseUtilities.getUrls(this);
        if (lst==null)
           setTitle("null");
        else
            setTitle(""+lst.size());
        DatabaseAdapter adapter=new DatabaseAdapter(this,lst);
        lv.setAdapter(adapter);
    }
    public  void  saveAll(View view)
    {
        setTitle("Saving all data");
        Downloader downloader=new Downloader();
        downloader.execute();
    }
class  Downloader extends  AsyncTask
    {

        @Override
        protected Object doInBackground(Object[] params) {
            try{
                String retvalue="";
                List<String> lst=DatabaseUtilities.getUrls(getApplicationContext());
                for(int i=0;i<=lst.size()-1;i++) {
                    String url = lst.get(i);
                    url=url + "&userid=" + Utilities.loggedinemail;
                   retvalue+="\n" + Utilities.getDataFromURL(url);
                }
                return retvalue;
            }catch (Exception e)
            {
                return e;
            }
        }
        @Override
        protected void onPostExecute(Object result)
        {
            super.onPostExecute(result);
            setTitle("" + result);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saved_data_in_data_base, menu);
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
