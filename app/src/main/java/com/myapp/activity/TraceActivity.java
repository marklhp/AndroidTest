package com.myapp.activity;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.myapp.R;
import com.myapp.adapter.TraceListAdapter;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityTraceBinding;
import com.myapp.utils.network.TracerouteContainer;
import com.myapp.utils.network.TracerouteWithPing;

import java.util.ArrayList;
import java.util.List;

public class TraceActivity extends BaseActivity<ActivityTraceBinding> implements View.OnClickListener {
    public static final String tag = "TraceroutePing";
    public static final String INTENT_TRACE = "INTENT_TRACE";

    private TraceListAdapter traceListAdapter;

    private final int maxTtl = 40;

    private List<TracerouteContainer> traces;
    private TracerouteWithPing tracerouteWithPing;

    @Override
    protected void initView() {
        binding.setClick(this);
        this.tracerouteWithPing = new TracerouteWithPing(this);
        this.traces = new ArrayList<TracerouteContainer>();
        traceListAdapter = new TraceListAdapter();
        binding.listViewTraceroute.setLayoutManager(new LinearLayoutManager(TraceActivity.this));
        binding.listViewTraceroute.setAdapter(traceListAdapter);
        binding.editTextPing.requestFocusFromTouch();
        binding.editTextPing.requestFocus();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_trace;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLaunch:

                if (binding.editTextPing.getText().length() == 0) {
                    Toast.makeText(TraceActivity.this, getString(R.string.no_text), Toast.LENGTH_SHORT).show();
                } else {
                    traces.clear();
                    traceListAdapter.refreshData(traces);
                    startProgressBar();
                    hideSoftwareKeyboard(binding.editTextPing);
                    tracerouteWithPing.executeTraceroute(binding.editTextPing.getText().toString(), maxTtl);
                }
                break;
        }
    }
    /**
     * Allows to refresh the listview of traces
     *
     * @param trace
     *            The list of traces to refresh
     */
    public void refreshList(TracerouteContainer trace) {
        final TracerouteContainer fTrace = trace;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                traces.add(fTrace);
                traceListAdapter.refreshData(traces);
            }
        });
    }

    /**
     * Hides the keyboard
     *
     * @param currentEditText
     *            The current selected edittext
     */
    public void hideSoftwareKeyboard(EditText currentEditText) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(currentEditText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void startProgressBar() {
        binding.progressBarPing.setVisibility(View.VISIBLE);
    }

    public void stopProgressBar() {
        binding.progressBarPing.setVisibility(View.GONE);
    }
}
