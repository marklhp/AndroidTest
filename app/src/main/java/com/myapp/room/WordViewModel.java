package com.myapp.room;

import android.app.Application;

import com.myapp.App;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel  {
    private WordRepository mRepository;

    private LiveData<List<Word>> mAllWords;
    public WordViewModel () {
        mRepository = new WordRepository(App.application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }
    public void insert(Word word){
        mRepository.insert(word);
    }
}
