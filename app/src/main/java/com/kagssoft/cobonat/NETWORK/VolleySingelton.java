package com.kagssoft.cobonat.NETWORK;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.kagssoft.cobonat.manifests.java.MyApplication;

/**
 * Created by sams on 1/20/2017.
 */

public class VolleySingelton {
    private static VolleySingelton sInstance=null;
    private ImageLoader mImageLoder;
    private RequestQueue mRequstQueue ;
    private VolleySingelton(){
      mRequstQueue= Volley.newRequestQueue(MyApplication.getAppContext());
        mImageLoder =new ImageLoader(mRequstQueue, new ImageLoader.ImageCache() {
            private LruCache<String, Bitmap> cache=new LruCache<>((int) ((Runtime.getRuntime().maxMemory()/1024)/8));
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    public static VolleySingelton getsInstance(){

        if (sInstance==null)
        {
            sInstance=new VolleySingelton();
        }
        return sInstance ;
    }

    public RequestQueue getmRequstQueue (){
        return mRequstQueue ;
    }

    public ImageLoader getmImageLoder() {
        return mImageLoder;
    }
}
