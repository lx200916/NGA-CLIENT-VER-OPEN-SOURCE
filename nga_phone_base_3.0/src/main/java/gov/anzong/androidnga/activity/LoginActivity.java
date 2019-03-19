package gov.anzong.androidnga.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.alibaba.android.arouter.facade.annotation.Route;

import gov.anzong.androidnga.arouter.ARouterConstants;
import sp.phone.fragment.BaseFragment;
import sp.phone.fragment.LoginWebFragment;

@Route(path = ARouterConstants.ACTIVITY_LOGIN)
public class LoginActivity extends BaseActivity {

    private BaseFragment mLoginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginFragment = new LoginWebFragment();
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, mLoginFragment).commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        if (!mLoginFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public void finish() {
        setResult(Activity.RESULT_OK);
        super.finish();
    }
}
