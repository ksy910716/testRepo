package com.example.ksy.t4_20150105;

/**
 * Created by ksy on 2016-01-05.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public final class TestFragment extends Fragment {
    private static final String KEY_CONTENT = "TestFragment:Content";

    int mNum;

    public static TestFragment newInstance(String content) {
        TestFragment fragment = new TestFragment();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            builder.append(content).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        fragment.mContent = builder.toString();
        return fragment;
    }

    /*public static TestFragment newInstance(int position) {
        TestFragment fragment = new TestFragment();
        test = position;
        return fragment;
    }*/

    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static TestFragment newInstance(int num) {
        TestFragment f = new TestFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    private String mContent = "???";

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
        /*TextView text = new TextView(getActivity());
        text.setText(mContent);
        text.setTextSize(20 * getResources().getDisplayMetrics().density);
        text.setPadding(20, 20, 20, 20);
        text.setGravity(Gravity.CENTER);*/

        /*ImageView img = new ImageView(getActivity());
        img.setImageResource(R.drawable.gametitle_01+mNum);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.addView(img);*/

        View view = inflater.inflate(R.layout.viewpager_childview, container, false);
        ImageView img = (ImageView) view.findViewById(R.id.img_viewpager_childimage);
        img.setImageResource(R.drawable.gametitle_01 + mNum);




        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onDown(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                           float velocityY) {
                        final int SWIPE_MIN_DISTANCE = 120;
                        final int SWIPE_MAX_OFF_PATH = 250;
                        final int SWIPE_THRESHOLD_VELOCITY = 200;
                        try {
                            // 오른쪽->왼쪽
                            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                            {
                                Toast.makeText(getActivity().getApplicationContext(), "왼쪽으로", Toast.LENGTH_SHORT).show();
                            }
                            // 왼쪽->오른쪽
                            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                            {
                                Toast.makeText(getActivity().getApplicationContext(), "오른쪽으로", Toast.LENGTH_SHORT).show();
                                //((MainActivity) getActivity()).test();
                            }
                            // 아래->위로
                            else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
                            {
                                ((MainActivity) getActivity()).verticalPage();
                            }
                            // 위->아래
                            else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
                            {
                                ((MainActivity) getActivity()).verticalPage();
                            }
                        } catch (Exception e) {
                            // nothing
                        }
                        return true;
                    }
                });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }
}