package com.example.weatherapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class weatherSingleton {
    private static weatherSingleton minstance;
    private RequestQueue requestQueue;
    private static Context mCtx;
    private weatherSingleton(Context context) {
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized weatherSingleton getInstance(Context context) {
        if (minstance == null) {
            minstance = new weatherSingleton(context);
        }
        return minstance;
    }
    public void addToRequestQue(Request request){
        requestQueue.add(request);
    }

}
