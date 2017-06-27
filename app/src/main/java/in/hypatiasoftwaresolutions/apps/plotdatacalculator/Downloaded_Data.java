package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.List;

public class Downloaded_Data extends AppCompatActivity {
    ListView lv;
    StampData data;
    Button btndownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloaded__data);
        lv=(ListView)findViewById(R.id.lv);
        btndownload=(Button) findViewById(R.id.btndownload);
       /* List<StampData> lst=DatabaseUtilities.select(this);
        if (lst==null)
            setTitle("null");
        TableAdapter adapter=new TableAdapter(this,lst);
        lv.setAdapter(adapter);*/
    }
    public void download(View view)
    {
        Downloader downloader=new Downloader();
        downloader.execute();
    }
    class Downloader extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            try {

                String url = "http://jijaji.hypatiasoftwaresolutions.in/getdata.aspx?userid=" + Utilities.loggedinemail;
                return Utilities.getDataFromURL(url);

            } catch (Exception e) {
                return e;
            }
        }
        @Override

        public  void onPostExecute(Object result)
        {
            super.onPostExecute(result);
            try {
                List<String> lst=Utilities.GetDataInList(result);
                btndownload.setText("" + lst.size());
                DownloadedAdapter adapter=new DownloadedAdapter(Downloaded_Data.this,lst);
                lv.setAdapter(adapter);



            }catch (Exception e)
            {
                btndownload.setText(e.getMessage());
            }
        }
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_downloaded__data, menu);
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
