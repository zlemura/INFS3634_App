package com.example.android.googlemapsapp.MentalHealthModule;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {MentalHealthQuestion.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract MentalHealthQuestionDao mentalHealthQuestionDao();

}