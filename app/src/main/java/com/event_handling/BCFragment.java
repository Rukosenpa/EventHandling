package com.event_handling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class BCFragment extends Fragment {


    private TextView tv;

    public BCFragment() {
        super(R.layout.activity_bc);
    }

    private final View.OnClickListener bClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            tv.setText("Нажатие произошло");
        }

    };

    private final View.OnLongClickListener bLongClickListener = new View.OnLongClickListener(){

        @Override
        public boolean onLongClick(View v) {
            tv.setText("Долгое нажатие произошло");
            return true;
        }

    };

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment

        return inflater.inflate(R.layout.activity_bc, parent, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tv = Objects.requireNonNull(getView()).findViewById(R.id.tv_bc);
        Button b = getView().findViewById(R.id.button);
        b.setOnClickListener(bClickListener);
        b.setOnLongClickListener(bLongClickListener);

    }

}
