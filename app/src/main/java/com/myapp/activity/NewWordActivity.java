package com.myapp.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityNewWord2Binding;

import static com.myapp.activity.RoomActivity.EXTRA_REPLY;

public class NewWordActivity extends BaseActivity<ActivityNewWord2Binding> {


    @Override
    protected void initView() {
        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(binding.editWord.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = binding.editWord.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_word2;
    }
}
