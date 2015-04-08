package edu.osu.cse.healthapp.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import healthapp.cse.osu.edu.healthapp.R;

/**
 * Created by siddhi on 4/7/15.
 * Linear layout : type : text_view edit_view
 */
public class EnterFieldLayout extends LinearLayout {


    private TextView mLabel;

    public EnterFieldLayout(Context context) {
        super(context, null);
    }

    public EnterFieldLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EnterFieldLayout, 0 , 0);
                //R.styleable.ColorOptionsView, 0, 0);
        String titleText = a.getString(R.styleable.EnterFieldLayout_titleText);
        a.recycle();
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.enter_field_layout, this, true);
        mLabel = (TextView) getChildAt(0);
        mLabel.setText(titleText); // set label
    }
}
