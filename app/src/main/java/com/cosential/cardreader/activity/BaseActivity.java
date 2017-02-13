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

    protected TextView txtTitle;
    protected LinearLayout llLeft, llRight;
    protected Button btnLeft, btnRight;
    protected ImageButton btnLeftImage, btnRightImage;

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
        txtTitle = (TextView) findViewById(R.id.topBarTitle);
        llLeft = (LinearLayout) findViewById(R.id.topLeftButtonLayout);
        btnLeft = (Button) findViewById(R.id.topBarLeftButton);
        btnLeftImage = (ImageButton) findViewById(R.id.topBarLeftImageButton);
        llRight = (LinearLayout) findViewById(R.id.topRightButtonLayout);
        btnRight = (Button) findViewById(R.id.topBarRightButton);
        btnRightImage = (ImageButton) findViewById(R.id.topBarRightImageButton);
    }

    protected void setTitle(String text) {
        txtTitle.setText(text);
    }

    protected void setTopLeftButtonImage(int imageResId) {
        btnLeft.setVisibility(View.GONE);
        btnLeftImage.setImageResource(imageResId);
        btnLeftImage.setVisibility(View.VISIBLE);
    }

    protected void setTopLeftButtonText(String text) {
        btnLeft.setText(text);
        btnLeft.setVisibility(View.VISIBLE);
        btnLeftImage.setVisibility(View.GONE);
    }

    protected void setTopLeftButtonVisibility(int visibility) {
        llLeft.setVisibility(visibility);
    }

    protected void setTopRightButtonImage(int imageResId) {
        btnRight.setVisibility(View.GONE);
        btnRightImage.setImageResource(imageResId);
        btnRightImage.setVisibility(View.VISIBLE);
    }

    protected void setTopRightButtonText(String text) {
        btnRight.setText(text);
        btnRight.setVisibility(View.VISIBLE);
        btnRightImage.setVisibility(View.GONE);
    }

    protected void setTopRightButtonVisibility(int visibility) {
        llRight.setVisibility(visibility);
    }

    protected void adjustTopBarLayout() {
        final LinearLayout layout = (LinearLayout)findViewById(R.id.topBarLayout);
        ViewTreeObserver vto = layout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int leftWidth = llLeft.getWidth();
                int rightWidth = llRight.getWidth();
                LinearLayout.LayoutParams lpLeft = (LinearLayout.LayoutParams) llLeft.getLayoutParams();
                LinearLayout.LayoutParams lpRight = (LinearLayout.LayoutParams) llRight.getLayoutParams();
                if (leftWidth > rightWidth) {
                    lpRight.width = leftWidth;
                    llRight.setLayoutParams(lpRight);
                }
                else {
                    lpLeft.width = rightWidth;
                    llLeft.setLayoutParams(lpLeft);
                }
            }
        });
    }
}
