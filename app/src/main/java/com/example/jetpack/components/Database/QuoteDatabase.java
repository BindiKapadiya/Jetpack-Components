package com.example.jetpack.components.Database;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.jetpack.components.Database.Entity.Quote;
import com.example.jetpack.components.myModel.WallPaperModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Bindi : 16-07-2024
 */

@Database(entities = {Quote.class, WallPaperModel.class}, version = 1/*, exportSchema = false*/)
public abstract class QuoteDatabase extends RoomDatabase {

    private static final String TAG = QuoteDatabase.class.getSimpleName();
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static Context context;
    static volatile QuoteDatabase instance;

    public static QuoteDatabase getDatabase(Context context) {
        if (instance == null) {
            synchronized (QuoteDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), QuoteDatabase.class, "quote_database")
                            .createFromAsset("quotes.db")
//                            .addMigrations(MIGRATION_1_2)
                            .build();
                }
            }
        }
        return instance;
    }

    static final Migration MIGRATION_1_2 = new Migration(2, 1) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            Log.e(TAG, "migrate: MIGRATION_1_2");
            Toast.makeText(context, "MIGRATION_1_2", Toast.LENGTH_SHORT).show();
//            database.execSQL("ALTER TABLE quote ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)");

        }
    };

    public abstract QuoteDao quoteDao();

}
