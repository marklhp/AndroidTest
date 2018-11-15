package com.myapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.myapp.R;
import com.myapp.databinding.ActivityWebSocketBinding;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

import androidx.databinding.DataBindingUtil;

public class WebSocketActivity extends Activity implements View.OnClickListener {
    ActivityWebSocketBinding binding;
    WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_socket);
        binding.setClick(this);
        init();
    }

    private void init() {
       Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("线程1",Thread.currentThread().getName().toString());
                try {
                    webSocketClient = new WebSocketClient(new URI("ws://172.18.44.23:2017"),new Draft_6455()) {
                        @Override
                        public void onOpen(ServerHandshake handshakedata) {
                            Log.d("picher_log", "打开通道" + handshakedata.getHttpStatus());
                            sendToTarget("打开通道");
                        }

                        @Override
                        public void onMessage(String message) {
                            Log.d("picher_log", "接收消息" + message);
                            sendToTarget(message);
                        }

                        @Override
                        public void onClose(int code, String reason, boolean remote) {
                            Log.d("picher_log", "通道关闭");
                            sendToTarget("通道关闭");

                        }

                        @Override
                        public void onWebsocketPing(WebSocket conn, Framedata f) {
                            super.onWebsocketPing(conn, f);
                        }

                        @Override
                        public void onWebsocketPong(WebSocket conn, Framedata f) {
                            super.onWebsocketPong(conn, f);
                        }

                        @Override
                        public void onError(Exception ex) {
                            Log.d("picher_log", "链接错误");
                        }
                    };
                    webSocketClient.connect();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
       thread.start();
    }


    private void sendToTarget(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("websocket--",string);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.websocket_c:
                webSocketClient.send("发送一个消息");
                break;
            case R.id.websocket_close:
                webSocketClient.close();
                break;
            case R.id.websocket_reopen:
                webSocketClient.reconnect();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webSocketClient!=null){
            webSocketClient.close();
        }
    }
}
