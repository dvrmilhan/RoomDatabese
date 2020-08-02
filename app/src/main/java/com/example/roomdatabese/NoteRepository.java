package com.example.roomdatabese;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository implements NoteDao{

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application){
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    @Override
    public  void insert(Note note){
        noteDao.insert(note);
    }

    @Override
    public void update(int sId, String sText) {

    }

    @Override
    public void delete(Note note){
        noteDao.delete(note);
    }

    @Override
    public void deleteAllNotes(){
        noteDao.deleteAllNotes();
    }

    @Override
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
