package com.example.compareit;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

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


        final ImageButton button = (ImageButton) vi.findViewById(R.id.pick_barcode);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               barCode();
            }
        });



        return vi;
    }


    public void barCode() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "BAR_CODE_MODE");
        startActivityForResult(intent, 0);
    }







}
