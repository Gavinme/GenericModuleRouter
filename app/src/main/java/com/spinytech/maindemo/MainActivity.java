package com.spinytech.maindemo;

import java.util.HashMap;

import com.spinytech.macore.RouterCallback;
import com.spinytech.macore.RouterManager;
import com.spinytech.macore.RouterRequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private void toastOnUIThread(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_local_sync_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.getInstance()
                        .route(MainActivity.this, new RouterRequest().provider("main")
                                        .action("sync")
                                        .data("1", "Hello")
                                        .data("2", "World"),
                                new RouterCallback() {
                                    @Override
                                    public void onResult(int resultCode, HashMap resultData) {
                                        String result = "";
                                        if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                            result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                        } else {
                                            result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                        }
                                        toastOnUIThread(resultCode + "\t" + result);
                                    }
                                });

            }
        });
        findViewById(R.id.main_local_async_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.getInstance()
                        .route(MainActivity.this, new RouterRequest().provider("main")
                                        .action("async")
                                        .data("1", "Hello")
                                        .data("2", "World"),
                                new RouterCallback() {
                                    @Override
                                    public void onResult(int resultCode, HashMap resultData) {
                                        String result = "";
                                        if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                            result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                        } else {
                                            result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                        }
                                        toastOnUIThread(resultCode + "\t" + result);
                                    }
                                });
            }
        });

        findViewById(R.id.main_play_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long startTime = System.currentTimeMillis();
                final RouterRequest request = new RouterRequest()
                        .provider("music")
                        .action("play");
                RouterManager.getInstance()
                        .route(MainActivity.this, request,
                                new RouterCallback() {
                                    @Override
                                    public void onResult(int resultCode, HashMap resultData) {
                                        String result = "";
                                        if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                            result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                        } else {
                                            result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                        }
                                        toastOnUIThread(resultCode + "\t" + result);
                                    }
                                });
            }
        });
        findViewById(R.id.main_stop_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long startTime = System.currentTimeMillis();
                RouterManager.getInstance()
                        .route(MainActivity.this, new RouterRequest()
                                        .provider("music")
                                        .action("stop"),
                                new RouterCallback() {
                                    @Override
                                    public void onResult(int resultCode, HashMap resultData) {
                                        String result = "";
                                        if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                            result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                        } else {
                                            result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                        }
                                        toastOnUIThread(resultCode + "\t" + result);
                                    }
                                });

            }
        });

        findViewById(R.id.main_music_shutdown_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long startTime = System.currentTimeMillis();
                RouterManager.getInstance()
                        .route(MainActivity.this, new RouterRequest()
                                        .provider("music")
                                        .action("shutdown"),
                                new RouterCallback() {
                                    @Override
                                    public void onResult(int resultCode, HashMap resultData) {
                                        String result = "";
                                        if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                            result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                        } else {
                                            result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                        }
                                        toastOnUIThread(resultCode + "\t" + result);
                                    }
                                });
            }
        });
        findViewById(R.id.main_wide_shutdown_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        findViewById(R.id.main_pic_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long startTime = System.currentTimeMillis();
                RouterManager.getInstance()
                        .route(MainActivity.this, new RouterRequest()
                                .provider("pic")
                                .action("pic")
                                .data("is_big", "0"), new RouterCallback() {
                            @Override
                            public void onResult(int resultCode, HashMap resultData) {
                                String result = "";
                                if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                    result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                } else {
                                    result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                }
                                toastOnUIThread(resultCode + "\t" + result);
                            }
                        });
            }
        });

        findViewById(R.id.main_big_pic_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long startTime = System.currentTimeMillis();
                RouterManager.getInstance()
                        .route(MainActivity.this, new RouterRequest()
                                        .provider("pic")
                                        .action("pic")
                                        .data("is_big", "1"),
                                new RouterCallback() {
                                    @Override
                                    public void onResult(int resultCode, HashMap resultData) {
                                        String result = "";
                                        if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                            result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                        } else {
                                            result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                        }
                                        toastOnUIThread(resultCode + "\t" + result);
                                    }
                                });
            }
        });
        findViewById(R.id.main_web_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.getInstance()
                        .route(MainActivity.this, new RouterRequest()
                                        .provider("web")
                                        .action("web"),
                                new RouterCallback() {
                                    @Override
                                    public void onResult(int resultCode, HashMap resultData) {
                                        String result = "";
                                        if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                            result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                        } else {
                                            result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                        }
                                        toastOnUIThread(resultCode + "\t" + result);
                                    }
                                }
                        );
            }
        });
        findViewById(R.id.main_attach_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.getInstance()
                        .route(MainActivity.this, new RouterRequest()
                                        .provider("main")
                                        .action("attachment")
                                        .data("textview",findViewById(R.id.main_attach_btn)),
                                new RouterCallback() {
                                    @Override
                                    public void onResult(int resultCode, HashMap resultData) {
                                        String result = "";
                                        if(resultCode == RouterCallback.CODE_SUCCESS && resultData!=null){
                                            result = (String) resultData.get(RouterCallback.KEY_VALUE);
                                            final Object toast = resultData.get("toast");
                                            if( toast!= null && toast instanceof  Toast){
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        ((Toast)toast).show();
                                                    }
                                                });
                                            }
                                        } else {
                                            result = (String)resultData.get(RouterCallback.KEY_ERROR_MSG);
                                        }
                                        toastOnUIThread(resultCode + "\t" + result);
                                    }
                                }
                        );

            }
        });
    }

}
