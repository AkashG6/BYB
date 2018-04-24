package in.dbit.byb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class LocalDB extends SQLiteAssetHelper {

    public LocalDB(Context context) {
        super(context, "byb.db", context.getExternalFilesDir(null).getAbsolutePath(), null, 1);
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery("SELECT * FROM big5",null);
        return result;
    }
}