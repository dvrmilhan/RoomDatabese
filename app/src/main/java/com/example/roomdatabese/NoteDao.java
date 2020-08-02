package com.example.roomdatabese;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Data Access Object: All the methods about my table in there
@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Query("UPDATE note_table SET description = :sText WHERE id = :sId")
    void update(int sId, String sText);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();

}
