package com.example.suncuoglu.fragmentexapmle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentOne extends Fragment {
    EditText editText;
    Button submit;
    OnFragmentAddListener onFragmentAddListener;
    private String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        editText = view.findViewById(R.id.name);
        submit = view.findViewById(R.id.submit_id);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                onFragmentAddListener.onButtonClicked(name);
            }
        });
        return view;
    }


    public void setOnFragmentAddListener(OnFragmentAddListener onFragmentAddListener) {
        this.onFragmentAddListener = onFragmentAddListener;
    }

    public static FragmentOne newInstance(OnFragmentAddListener onFragmentAddListener) {
        FragmentOne fragmentOne = new FragmentOne();
        fragmentOne.setOnFragmentAddListener(onFragmentAddListener);
        return fragmentOne;
    }


}
