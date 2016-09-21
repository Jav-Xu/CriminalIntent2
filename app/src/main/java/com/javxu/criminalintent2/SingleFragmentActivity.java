package com.javxu.criminalintent2;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jav-Xu on 16/9/18.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {
    //AppCompatActivity就是FragmentActivity的子类

    protected abstract Fragment createFragment();

    //让该类的子类重写该方法以自行提供布局资源ID,注解@LayoutRes是告诉AS,任何时候该实现方法都应该返回有效的布局资源ID
    @LayoutRes
    protected int getLayoutId(){
        return R.layout.activity_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }

    }
}
