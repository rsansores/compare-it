package com.example.compareit;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nacho on 10/23/13.
 */
public class addProduct extends Fragment {

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View vi = inflater.inflate(
                R.layout.addproduct, container, false);


        return vi;
    }

}
