package com.police.demonstrationservice.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DemonstrationInfo.class}, version = 1, exportSchema = false)
public abstract class DemonstrationDataBase extends RoomDatabase {
    public abstract DemonstrationDao demonstrationDao();

    private static DemonstrationDataBase database;
    private static final String DEMONSTRATION_DATABASE_NAME = "demonstrationDatabaseName";

    public synchronized static DemonstrationDataBase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), DemonstrationDataBase.class, DEMONSTRATION_DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
}