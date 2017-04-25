package com.cti_cert.cticalibration.Ativities;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cti_cert.cticalibration.Base.BaseActivity;
import com.cti_cert.cticalibration.R;

public class CopyrightActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copyright);
        ImageView selfie = (ImageView) findViewById(R.id.selfie);
        Glide.with(this).load(R.drawable.selfie).into(selfie);
    }
}
