package com.nexters.taigerapp.network;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.SyncHttpClient;

public class TaigerApi {
    protected static AsyncHttpClient asyncClient = new AsyncHttpClient();
    protected static AsyncHttpClient syncClient = new SyncHttpClient();
    protected static Gson gson = new Gson();
}
