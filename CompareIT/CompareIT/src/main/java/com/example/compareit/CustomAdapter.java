package com.example.compareit;


        import java.util.ArrayList;
        import java.util.List;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.util.DisplayMetrics;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.animation.Animation;
        import android.view.animation.TranslateAnimation;
        import android.widget.ArrayAdapter;
        import android.widget.Filterable;
        import android.widget.ImageView;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Filter;
        import android.util.Log;

public class  CustomAdapter<T> extends ArrayAdapter<T> {



    Utils ut;
    Context ct;
    DisplayMetrics metrics;
    ArrayList<T> source;

    public CustomAdapter(Context context, int textViewResourceId, List<T> objects, DisplayMetrics metrics) {
        super(context, textViewResourceId, objects);
        this.ct = context;
        ut = new Utils();
        this.metrics = metrics;
        this.source = new ArrayList<T>(objects);
    }



    public void refresh(ArrayList<T> items){

        this.source.clear();
        for(T item:items){
            source.add(item);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.search_row, null);
        }
        TextView name = (TextView)vi.findViewById(R.id.name);
        TextView price = (TextView)vi.findViewById(R.id.Price);
        ImageView thumb=(ImageView)vi.findViewById(R.id.list_image);

        IdString data = (IdString)this.getItem(position);


        ProgressBar pb = (ProgressBar) vi.findViewById(R.id.ProgressBar);

        // if(data.image == null){
        Log.i("URL", "id:" + data.id + " " + data.url);
        ut.setImage(thumb, pb , data.url, data);
        data.imgLoaded = true;

        //}
        // Setting all values in listview
        name.setText(data.name);
        price.setText(data.price + "");



        int side = position % 2 == 0 ? 1: -1;
        Animation animation_main = new TranslateAnimation(-1 * side * metrics.widthPixels/2, 0, 0, 0);
        animation_main.setDuration(700);
        vi.startAnimation(animation_main);

        animation_main = null;

        return vi;
    }





}

