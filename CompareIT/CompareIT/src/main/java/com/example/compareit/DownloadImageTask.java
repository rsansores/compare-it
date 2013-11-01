package com.example.compareit;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


/**
 * Carga una imagen por URL.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView bmImage;
    private ProgressBar pb;
    private IdString data;

    public DownloadImageTask(ImageView imageView, ProgressBar pb, IdString data) {
        this.bmImage = imageView;
        this.pb = pb;
        this.data = data;
    }

    protected void onPreExecute(){
        this.bmImage.setVisibility(View.INVISIBLE);
        this.pb.setVisibility(View.VISIBLE);
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];

        Log.i("GET",urldisplay);

        Bitmap mIcon11 = null;


        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            // Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        if(this.data.image == null){
            bmImage.setImageBitmap(result);
            this.data.image = result;
            this.bmImage.setVisibility(View.VISIBLE);
            this.pb.setVisibility(View.INVISIBLE);
            Log.i("GET","Complete!");
        }
    }
}
