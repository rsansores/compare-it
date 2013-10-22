package com.example.compareit;

/**
 * Created by Nacho on 10/21/13.
 */

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.UnsupportedEncodingException;
        import java.net.URI;
        import java.net.URISyntaxException;
        import java.util.ArrayList;
        import java.util.List;

        import org.apache.http.HttpResponse;
        import org.apache.http.NameValuePair;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.entity.StringEntity;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.message.BasicNameValuePair;
        import org.apache.http.params.HttpParams;
        import org.json.JSONObject;

        import android.app.ProgressDialog;
        import android.content.Context;
        import android.os.AsyncTask;
        import android.util.Log;


public class httpTask extends AsyncTask<JSONObject, Void, String>{


    public static final int GET=0;
    public static final int POST=1;

    private int method;
    private String url;

    private ProgressDialog dialog;
    private Context context;
    AsyncStuff listener;

    public httpTask(Context context, int method, String url){

        this.url = url;
        this.method = method;

        context = context;
        try{
            dialog = new ProgressDialog(context);
        }catch(Exception e){}
    }

    public void setListener(AsyncStuff listener) {
        this.listener = listener;
    }

    private  String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is), 8192);
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append((line + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private String get(JSONObject... args){

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet();
        try {
            get.setURI(new URI(this.url));
            HttpResponse r = client.execute(get);
            return this.convertStreamToString(r.getEntity().getContent());


        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private String post(JSONObject... args){

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(this.url);



        try {
            post.addHeader("Content-Type", "application/json");

            StringEntity se = new StringEntity(args[0].toString());

            se.setContentEncoding("UTF-8");
            se.setContentType("application/json");

            post.setEntity(se);
            HttpResponse r = client.execute(post);
            return this.convertStreamToString(r.getEntity().getContent());

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if(this.listener != null){
            this.listener.doStuff(result);
        }
        Log.i("httpTask",result);
        try{
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }catch(Exception e){}
    }


    protected void onPreExecute(){
        try{
            this.dialog.setMessage("Loading...");
            this.dialog.show();
        }catch(Exception e){}
    }
    @Override
    protected String doInBackground(JSONObject... params) {
        if(this.method == POST){
            return post(params);
        }else if (this.method == GET){
            return get(params);
        }else{
            return null;
        }
    }



}

