package com.bohan.android.jokesandroidlibrary;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jokes_display, container, false);
        String result = getActivity().getIntent().getStringExtra("result");
        //System.out.println("result is: " + result);
        TextView result_show = (TextView) view.findViewById(R.id.jokes_text_view);
        result_show.setText(result);
        return view;
    }

}
