package com.dodemy.android.roomcrud.ui.notes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dodemy.android.roomcrud.db.NotesRepository;
import com.dodemy.android.roomcrud.db.entity.NoteEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class NotesListViewModel extends AndroidViewModel {

    private NotesRepository mRepository;
    private LiveData<List<NoteEntity>> notes;

    public NotesListViewModel(@NonNull Application application) {
        super(application);

        mRepository = new NotesRepository(application);
    }

    public LiveData<List<NoteEntity>> getNotes() {
        if (notes == null) {
            notes = mRepository.getAllNotes();
        }

        return notes;
    }

    public NoteEntity getNote(int id) throws ExecutionException, InterruptedException {
        return mRepository.getNote(id);
    }

    public void insertNote(NoteEntity note) {
        mRepository.insertNote(note);
    }

    public void updateNote(NoteEntity note) {
        mRepository.updateNote(note);
    }

    public void deleteNote(NoteEntity note) {
        mRepository.deleteNote(note);
    }

    public void deleteAllNotes() {
        mRepository.deleteAllNotes();
    }
}
