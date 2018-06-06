package com.example.suncuoglu.fragmentexapmle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnFragmentAddListener {
    Button add, remove, secondremove;
    FragmentOne firstFragment;
    FragmentTwo secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        remove = findViewById(R.id.remove);
        secondremove = findViewById(R.id.secondremove);

        firstFragment = FragmentOne.newInstance(this);


        firstFragment.setArguments(getIntent().getExtras());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!firstFragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_one, firstFragment).commit();

                }
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().remove(firstFragment).commit();
            }
        });
        secondremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secondFragment != null) {
                    getSupportFragmentManager().beginTransaction().remove(secondFragment).commit();
                    secondFragment = null;
                }
            }
        });

    }

    @Override
    public void onButtonClicked(String name) {
        if (secondFragment == null) {
            secondFragment = FragmentTwo.newInstance(name);
            secondFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_two, secondFragment).commit();

        }
    }
}
