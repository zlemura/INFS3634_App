package com.example.android.googlemapsapp.MentalHealthModule;

import java.util.Arrays;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface MentalHealthQuestionDao {

    @Query("SELECT * FROM mentalhealthquestion")
    List<MentalHealthQuestion> getAll();

    @Query("SELECT * FROM mentalhealthquestion WHERE questionNumber LIKE :number LIMIT 1")
    MentalHealthQuestion getQuestionByNumber(int number);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MentalHealthQuestion> mentalHealthQuestion);

    @Delete
    void delete(MentalHealthQuestion mentalHealthQuestion);
}
