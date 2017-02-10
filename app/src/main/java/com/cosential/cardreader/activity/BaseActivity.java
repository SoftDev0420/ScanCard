package com.cosential.cardreader.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cosential.cardreader.R;

public class BaseActivity extends Activity {

    protected TextView title;
    protected LinearLayout topLeftButtonLayout, topRightButtonLayout;
    protected Button topLeftButton, topRightButton;
    protected ImageButton topLeftImageButton, topRightImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupStatusBar();
    }

    private void setupStatusBar() {
        Window window = getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected void setupNavigationBar() {
        title = (TextView) findViewById(R.id.topBarTitle);
        topLeftButtonLayout = (LinearLayout) findViewById(R.id.topLeftButtonLayout);
        topLeftButton = (Button) findViewById(R.id.topBarLeftButton);
        topLeftImageButton = (ImageButton) findViewById(R.id.topBarLeftImageButton);
        topRightButtonLayout = (LinearLayout) findViewById(R.id.topRightButtonLayout);
        topRightButton = (Button) findViewById(R.id.topBarRightButton);
        topRightImageButton = (ImageButton) findViewById(R.id.topBarRightImageButton);
    }

    protected void setTitle(String text) {
        title.setText(text);
    }

    protected void setTopLeftButtonImage(int imageResId) {
        topLeftButton.setVisibility(View.GONE);
        topLeftImageButton.setImageResource(imageResId);
        topLeftImageButton.setVisibility(View.VISIBLE);
    }

    protected void setTopLeftButtonText(String text) {
        topLeftButton.setText(text);
        topLeftButton.setVisibility(View.VISIBLE);
        topLeftImageButton.setVisibility(View.GONE);
    }

    protected void setTopLeftButtonVisibility(int visibility) {
        topLeftButtonLayout.setVisibility(visibility);
    }

    protected void setTopRightButtonImage(int imageResId) {
        topRightButton.setVisibility(View.GONE);
        topRightImageButton.setImageResource(imageResId);
        topRightImageButton.setVisibility(View.VISIBLE);
    }

    protected void setTopRightButtonText(String text) {
        topRightButton.setText(text);
        topRightButton.setVisibility(View.VISIBLE);
        topRightImageButton.setVisibility(View.GONE);
    }

    protected void setTopRightButtonVisibility(int visibility) {
        topRightButtonLayout.setVisibility(visibility);
    }

    protected void adjustTopBarLayout() {
        final LinearLayout topBarLayout = (LinearLayout)findViewById(R.id.topBarLayout);
        ViewTreeObserver vto = topBarLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                topBarLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int leftWidth = topLeftButtonLayout.getWidth();
                int rightWidth = topRightButtonLayout.getWidth();
                LinearLayout.LayoutParams leftLayoutParams = (LinearLayout.LayoutParams) topLeftButtonLayout.getLayoutParams();
                LinearLayout.LayoutParams rightLayoutParams = (LinearLayout.LayoutParams) topRightButtonLayout.getLayoutParams();
                if (leftWidth > rightWidth) {
                    rightLayoutParams.width = leftWidth;
                    topRightButtonLayout.setLayoutParams(rightLayoutParams);
                }
                else {
                    leftLayoutParams.width = rightWidth;
                    topLeftButtonLayout.setLayoutParams(leftLayoutParams);
                }
            }
        });
    }
}
