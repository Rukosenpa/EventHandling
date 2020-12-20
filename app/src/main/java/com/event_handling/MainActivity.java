package com.event_handling;

import android.text.Layout;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.*;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        //getLayoutInflater().inflate(R.layout.activity_bc,(LinearLayout) findViewById(R.layout.activity_main));
        //View view = LayoutInflater.from(this).inflate(R.layout.activity_bc,null);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, BCFragment.class, null)
                    .commit();
        }
        //(View)findViewById(R.id.view) = view;

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void menuStuff(MenuItem item){
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        Objects.requireNonNull(getSupportActionBar()).setSubtitle(item.getTitle());
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (item.getItemId()){
            case R.id.menuitem_bc:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, BCFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("name") // name can be null
                    .commit();
                return;
                case R.id.menuitem_me:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, MEFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("name") // name can be null
                    .commit();
                return;
            case R.id.menuitem_cg:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, CGFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("name") // name can be null
                    .commit();
        }

    }
}