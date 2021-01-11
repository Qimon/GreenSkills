package fr.ssml.greenskills.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;

public class PlantDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String  DATABASE_FILE_PATH = "/mnt";
    private static final String DATABASE_NAME = "PlantLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "plant";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "Nom";
    private static final String COLUMN_FAMILY = "Famille";
    private static final String COLUMN_WATERING_DELAY = "Arrosage";
    private static final String COLUMN_SHINING_NEED = "Ensoleillement";

    public PlantDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQLiteDatabase.openDatabase(DATABASE_FILE_PATH + "/" + DATABASE_FILE_PATH, null, SQLiteDatabase.OPEN_READWRITE);
        StringBuilder sbQuery = new StringBuilder("CREATE TABLE ");
        sbQuery.append(TABLE_NAME);
        sbQuery.append((" ("));
        sbQuery.append(COLUMN_ID);
        sbQuery.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sbQuery.append(COLUMN_NAME);
        sbQuery.append(" TEXT, ");
        sbQuery.append(COLUMN_FAMILY);
        sbQuery.append(" TEXT, ");
        sbQuery.append(COLUMN_WATERING_DELAY);
        sbQuery.append(" INTEGER, ");
        sbQuery.append(COLUMN_SHINING_NEED);
        sbQuery.append(" INTEGER);");
        String query = sbQuery.toString();
        System.out.println("--------------" + db.getPath() + "--------------");
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        System.out.println("--------------" + db.getPath() + "--------------");
        onCreate(db);
    }

    public void addPlant(String nom, String famille, int arrosage, int ensoleillement){
        boolean test = checkDataBase();
        System.out.println("Resultat: ------------------ "+ test + " ------------------");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, nom);
        cv.put(COLUMN_FAMILY, famille);
        cv.put(COLUMN_WATERING_DELAY, arrosage);
        cv.put(COLUMN_SHINING_NEED, ensoleillement);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {

            String myPath = DATABASE_FILE_PATH + "/" + DATABASE_NAME;
            System.out.println("myPath:" + myPath);

            File file = new File(myPath);
            System.out.println("file.isFile():" + file.isFile());
            System.out.println("file.isDirectory():" + file.isDirectory());
            System.out.println("file.exists():" + file.exists());
            if (file.exists() && !file.isDirectory())
                checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            // database does't exist yet.
        }

        if (checkDB != null) {
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }
}
