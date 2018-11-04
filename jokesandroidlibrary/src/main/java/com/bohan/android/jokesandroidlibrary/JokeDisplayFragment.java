package com.bohan.android.jokesandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Bo Han.
 */
public class JokeDisplayFragment extends Fragment {

    public JokeDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_jokes_display, container, false);
        Intent i = getActivity().getIntent();
        /*
        String joke = i.getStringExtra("jokes");

        TextView textView = v.findViewById(R.id.jokes_text_view);
        textView.setText(joke);

        */
        String gce_result = getActivity().getIntent().getStringExtra("gce_result");
        TextView gce_result_show = (TextView) v.findViewById(R.id.jokes_text_view);
        gce_result_show.setText(gce_result);

        return v;
    }

}
