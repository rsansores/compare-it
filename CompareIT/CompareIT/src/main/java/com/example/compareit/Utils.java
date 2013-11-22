package com.example.compareit;

        import java.util.HashMap;

        import android.widget.ImageView;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.os.AsyncTask;

public class Utils {


    public Utils(){

    }

    public <T extends TextView> void fillComponents(HashMap<String,T> components, HashMap<String, String> values){

        for(String k : components.keySet()){
            components.get(k).setText(values.get(k));
        }

    }


    public void setImage(ImageView img,ProgressBar pb, String url, IdString data){
        if(data.image == null){
            new DownloadImageTask(img,pb, data).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,url);
        }else{
            img.setImageBitmap(data.image);
        }
    }

}


