package com.event_handling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.constraintlayout.widget.ConstraintLayout;



public class MEFragment extends Fragment {
    private TextView tv1;
    private TextView tv2;

        public MEFragment() {
            super(R.layout.activity_me);
        }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.activity_me, parent, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tv1 = getView().findViewById(R.id.tv_me_1);
        tv2 = getView().findViewById(R.id.tv_me_2);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                handleTouch(event);
                return true;
            }
        });


    }


    void handleTouch(MotionEvent m) {
        int pointerCount = m.getPointerCount();

        for (int i = 0; i < pointerCount; i++)
        {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;


            switch (action)
            {
                case MotionEvent.ACTION_DOWN:
                    actionString = "Кнопка нажата";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "Кнопка отжата";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "Указатель вниз";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "Указатель вверх";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "Движение";
                    break;
                default:
                    actionString = "";
            }

            String touchStatus = "Действие: " + actionString + " Индекс: " +
                    actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
            if (id == 0)
                tv1.setText(touchStatus);
            else
                tv2.setText(touchStatus);
        }
    }

}
