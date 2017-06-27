package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by viru on 3/11/2017.
 */
public class
        DBHelper  extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "bhuganak", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
