package univ.etu.tachemun.db.managers;

import android.content.ContentValues;
import android.content.Context;

import univ.etu.tachemun.db.tableclass.Droits;

public class DroitsManager extends TableManager {
    static final String tableName = "Droits";
    static final String ID_DROIT = "ID_Droits";


    public static final String createTableScript = "CREATE TABLE " + tableName +
            " (" +
            " " + ID_DROIT + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ");";


    public DroitsManager(Context context) {
        super(context);


    }

    private ContentValues putInContent(Droits d) {
        ContentValues c = new ContentValues();
        c.put(ID_DROIT, d.getID());

        return c;
    }

    public long insert(Droits d) {
        ContentValues c = putInContent(d);
        c.remove(ID_DROIT);
        return db.insert(tableName, null, c);
    }

    public int update(Droits d) {

        ContentValues values = putInContent(d);
        String where = ID_DROIT + " = ?";
        String[] whereArgs = {d.getID() + ""};


        return db.update(tableName, values, where, whereArgs);
    }

    public int delete(Droits d) {


        String where = ID_DROIT + " = ?";
        String[] whereArgs = {d.getID() + ""};
        return db.delete(tableName, where, whereArgs);
    }

    public Droits getFromId(int id) {
        return null;
    }
}
