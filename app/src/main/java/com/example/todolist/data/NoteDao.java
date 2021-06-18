package com.example.todolist.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todolist.model.Note;

import java.util.List;


@Dao
public interface NoteDao {
    @Query("SELECT * FROM note")
    List<Note> loadAll();

    @Query("SELECT * FROM note")
    LiveData<List<Note>> loadAllLiveData();

    @Query("SELECT * FROM note WHERE id LIKE :id LIMIT 1")
    Note loadOneById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);
}
