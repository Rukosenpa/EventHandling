package com.event_handling;

import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.view.GestureDetectorCompat;


public class CGFragment extends Fragment  implements  GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private TextView tv;
    private GestureDetectorCompat gDetector;


    public CGFragment() {
            super(R.layout.activity_cg);
        }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.activity_cg, parent, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tv = getView().findViewById(R.id.tv_cg);
        this.gDetector = new GestureDetectorCompat(this.getContext(),this);
        gDetector.setOnDoubleTapListener(this);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                return gDetector.onTouchEvent(event);
            }
        });
    }




    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        tv.setText("Одиночное нажатие");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        tv.setText("Двойное нажатие");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        tv.setText("Двойное");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        tv.setText("Вниз");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        tv.setText("Подсветка нажатия");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        tv.setText("Одиночное нажатие");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        tv.setText("Прокрутка");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        tv.setText("Длинное нажатие");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        tv.setText("Резкое движение");
        return true;
    }


}
