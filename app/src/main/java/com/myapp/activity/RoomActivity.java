package com.myapp.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityRoomBinding;
import com.myapp.room.Word;
import com.myapp.room.WordListAdapter;
import com.myapp.room.WordViewModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

public class RoomActivity extends BaseActivity<ActivityRoomBinding> implements View.OnClickListener {
//    MediatorLiveData<String>
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private WordViewModel mWordViewModel;
    @Override
    protected void initView() {
        binding.setClick(this);
        mWordViewModel = new WordViewModel();
        WordListAdapter adapter = new WordListAdapter(this);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(adapter);

//        Transformations.switchMap()


        mWordViewModel.getmAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
//                 Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_room;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.room_add:
                Intent intent = new Intent(this, NewWordActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);

                break;
            case R.id.room_delete:
                break;
            case R.id.room_up:
                break;
            case R.id.room_query:
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra(EXTRA_REPLY));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
