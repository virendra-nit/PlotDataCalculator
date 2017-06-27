package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

//import com.example.viru.plotdatacalculator.R;

import java.util.List;

/**
 * Created by viru on 3/12/2017.
 */
public class TableAdapter implements ListAdapter {
    Context context;
    List<StampData> lst=null;
    private LayoutInflater inflater;
    public TableAdapter(Context context,List<StampData> lst)
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
       // Data data= lst.get(position);
      /*
        StampData data=lst.get(position);
        Button b=new Button(context);
        b.setTag(data);
        b.setText(""+data.dateofentry);
        b.setOnClickListener(new ButtonHandler());
        return b;
        */
        View view;
        StampData data=lst.get(position);
        view=inflater.inflate(R.layout.activity_list_of_data,null);
        Button b=(Button)view.findViewById(R.id.btn1);
        TextView tv=(TextView)view.findViewById(R.id.tv);
        b.setTag(data);
        tv.setText(""+data.dateofentry);
        b.setOnClickListener(new ButtonHandler());
        return view;

    }
//*******************************************************************************************************
class ButtonHandler implements View.OnClickListener
{

    @Override
        public void onClick(View v) {
        Button b=(Button)v;
        StampData data=(StampData)b.getTag();
        Intent intent=new Intent(context,Data_in_Database.class);
        intent.putExtra("data",data);
        context.startActivity(intent);
    }
}
    //*******************************************************************************************************
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
