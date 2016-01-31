package com.nexters.taigerapp.util;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class CookieUtil {
    private static final String COOKIE_KEY = "Cookie";

    public static void refreshSessionCookie(String url, String sessionId) {
        try {
            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

            String cookie1 = CookieManager.getInstance().getCookie(url);
            if (cookie1 != null) {
                con.setRequestProperty("Cookie", cookie1);
            }

            String COOKIES_HEADER = "Set-Cookie";

            con.setUseCaches(true);
            con.setRequestMethod("GET");
            con.connect();
            Map<String, List<String>> headerFields = con.getHeaderFields();
            List<String> cookiesHeader = headerFields.get(COOKIES_HEADER);

            if (cookiesHeader != null) {
                for (String cookie : cookiesHeader) {
                    String cookieName = HttpCookie.parse(cookie).get(0).getName();
                    String cookieValue = HttpCookie.parse(cookie).get(0).getValue();

                    if (cookieName.equals(sessionId))
                        CookieManager.getInstance().setCookie(url, cookieValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addHeadersSessionCookie(String url, Map<String, String> headers) {
        String sessionId = CookieManager.getInstance().getCookie(url);
        if(sessionId == null)
            return ;
        if (sessionId.length() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(sessionId);
            if (headers.containsKey(COOKIE_KEY)) {
                builder.append("; ");
                builder.append(headers.get(COOKIE_KEY));
            }
            headers.put(COOKIE_KEY, builder.toString());
        }
    }

    @SuppressWarnings("deprecation")
    public static void clearCookies(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
//            Log.d(C.TAG, "Using ClearCookies code for API >=" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else {
//            Log.d(C.TAG, "Using ClearCookies code for API <" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(context);
            cookieSyncMngr.startSync();
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncMngr.stopSync();
            cookieSyncMngr.sync();
        }
    }
}
