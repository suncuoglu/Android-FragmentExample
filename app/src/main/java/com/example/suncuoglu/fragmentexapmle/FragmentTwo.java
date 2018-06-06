package com.example.suncuoglu.fragmentexapmle;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    TextView text;
    String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        text = view.findViewById(R.id.display_name);
        text.setText(name);

        return view;
    }

    public void setText(String name) {
        this.name = name;
    }

    public static FragmentTwo newInstance(String name) {
        FragmentTwo fragmenttwo = new FragmentTwo();
        fragmenttwo.setText(name);
        return fragmenttwo;
    }

}
