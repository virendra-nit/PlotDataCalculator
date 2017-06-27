package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Champak Roy on 4/20/2017.
 */
    public class DatabaseAdapter implements ListAdapter {
    Context context;
      List<String> lst=null;

    private LayoutInflater inflater;
    public DatabaseAdapter(Context context,List<String> lst)

    {
        this.context=context;
        this.lst=lst;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        //String url= lst.get(position);
        String data=lst.get(position);
        view=inflater.inflate(R.layout.activity_insert__data__in__database, null);
        Button b=(Button)view.findViewById(R.id.btn1);
        TextView tv=(TextView)view.findViewById(R.id.tv);
        tv.setText("" + (position + 1));
        b.setTag(data);

        b.setOnClickListener(new ButtonHandler());
        return view;
    }
    //***********************************************************************
    class  ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v)
        {
            //Button b=(Button)v;
            //String url=(String)b.getTag();
            Downloader downloader=new Downloader();
            downloader.execute("" + v.getTag());
            Button b=(Button)v;
           // b.setText("" + v.getTag());
        }
    }
    class  Downloader extends AsyncTask
    {

        @Override
        protected Object doInBackground(Object[] params) {
            try {
               String url="" + params[0];
                url=url + "&userid=" + Utilities.loggedinemail;
                return Utilities.getDataFromURL(url);
            }
            catch (Exception e)
            {
                return  e;
            }

        }

        @Override
        protected void onPostExecute(Object result)
        {
            super.onPostExecute(result);
            Toast.makeText(context,"" + result,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
