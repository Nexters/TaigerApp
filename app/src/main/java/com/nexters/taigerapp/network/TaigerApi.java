package com.nexters.taigerapp.network;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.SyncHttpClient;

public class TaigerApi {
    public static AsyncHttpClient asyncClient = new AsyncHttpClient();
    public static AsyncHttpClient syncClient = new SyncHttpClient();
    public static Gson gson = new Gson();
}
