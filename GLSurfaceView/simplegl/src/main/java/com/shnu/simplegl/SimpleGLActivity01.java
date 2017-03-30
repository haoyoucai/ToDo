package com.shnu.simplegl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by Dainel on 2017/3/29.
 */

public class SimpleGLActivity01 extends Activity {
    private Context mContext;
    private SimpleGLSurfaceView simpleGLSurfaceView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_gl_01);
        simpleGLSurfaceView=new SimpleGLSurfaceView(this);//创建myGLView
        LinearLayout ll=(LinearLayout) this.findViewById(R.id.mainLinear);//得到配制文件中LinearLayout的引用
        ll.addView(simpleGLSurfaceView);//在LinearLayout中加入myGLView
        //为背面剪裁按钮添加监听
        ToggleButton btn1=(ToggleButton) this.findViewById(R.id.ToggleButton01);
        btn1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                        simpleGLSurfaceView.setCullFaceFlag(!simpleGLSurfaceView.isCullFaceFlag());
                    }
                }
        );
        //为平滑着色按钮添加监听
        ToggleButton btn2=(ToggleButton) this.findViewById(R.id.ToggleButton02);
        btn2.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                        simpleGLSurfaceView.setSmoothFlag(!simpleGLSurfaceView.isSmoothFlag());
                    }
                }
        );
        //为卷绕方式按钮添加监听
        ToggleButton btn3=(ToggleButton) this.findViewById(R.id.ToggleButton03);
        btn3.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                        simpleGLSurfaceView.setCwFlag(!simpleGLSurfaceView.isCwFlag());
                    }
                }
        );
    }
    @Override
    protected void onResume() {
        super.onResume();
        simpleGLSurfaceView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        simpleGLSurfaceView.onPause();
    }
}