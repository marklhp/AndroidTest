package com.myapp.room;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDataBase db=WordRoomDataBase.getDatabase(application);
        this.mWordDao = db.wordDao();
        this.mAllWords = mWordDao.getAllWords();
    }
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
           long num= mAsyncTaskDao.insert(params[0]);
            Log.d("打印好数据","==="+num);
            return null;
        }
    }
}
