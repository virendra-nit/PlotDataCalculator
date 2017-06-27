package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;

import java.util.List;

/**
 * Created by Champak Roy on 4/26/2017.
 */
public class DownloadedAdapter implements ListAdapter {
    Context context;
    List<String> lst=null;
    private LayoutInflater inflater;
    public DownloadedAdapter(Context context,List<String> lst)
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
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        String data=lst.get(position);
        view=inflater.inflate(R.layout.activity_list_of_data,null);
        Button b=(Button)view.findViewById(R.id.btn1);
        try {
            StampData sd=new StampData(data);
            b.setText("" + sd.dateofentry);
            b.setTag(sd);
            b.setOnClickListener(new ButtonHandler());
        }
        catch (Exception ex) {
            b.setText(ex.getMessage());
        }
        return  view;

    }
    class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Button b=(Button)v;
            try {
                StampData data = (StampData) b.getTag();
                Intent intent = new Intent(context, Data_in_Database.class);
                intent.putExtra("data", data);
                context.startActivity(intent);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
                b.setText(ex.getMessage());
            }
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
