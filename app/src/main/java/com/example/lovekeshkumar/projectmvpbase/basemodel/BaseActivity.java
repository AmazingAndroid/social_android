package com.example.lovekeshkumar.projectmvpbase.basemodel;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;


/***
 *
 */
abstract public class BaseActivity extends AppCompatActivity {

    public Toolbar toolbar;
    public ViewStub activityViewStub;
    public ActionBar actionBar;
    public TextView txtToolBarTitle;
    public Utility utility;
    public ImageButton icUser;
    public ImageView txtMyCoins;
    public ProgressDialog progressDialog;
    public ImageButton btn_back;
    /***
     * Sip Declaration
     */
    public String sipAddress = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_root_view);
        initialize();
        setData();
    }

    /***
     * Initialize views of  Activity
     */
    public void initialize() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        activityViewStub = (ViewStub) findViewById(R.id.activity_content_root_stub);
        txtToolBarTitle = (TextView) findViewById(R.id.txt_screen_title);
        utility = Utility.getInstance(getApplicationContext());
        icUser = (ImageButton) findViewById(R.id.btn_user_top_bar);
        txtMyCoins = (ImageView) findViewById(R.id.txt_my_coins);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /***
     * Bind data on Views
     */
    public void setData() {
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);

            actionBar.setTitle("");
        }
    }


    /***
     * Replace Current fragment with added fragment
     * @param fragment
     *          Fragment need to be add
     * @param containerId
     *          Container ID
     */
    public void replaceFragment(Fragment fragment, int containerId, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(containerId, fragment, tag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    /***
     * Replace Current fragment with added fragment and add current fragment to backstack
     * @param fragment
     *          Fragment need to be add
     * @param containerId
     *          Container ID
     */
    public void replaceFragmentAddBackStack(Fragment fragment, int containerId) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(containerId, fragment, fragment.getClass().getName());
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    abstract public void initializeViews();

    abstract public void bindData();

    abstract public void setListeners();

    /**
     * Show snackbar
     *
     * @param message
     */
    public void showSnackbar(String message) {
        Snackbar.make(((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0), message, Snackbar.LENGTH_LONG).show();
    }

    /**
     * Show snackbar
     *
     * @param message
     */
    public void showSnackbarShort(String message) {
        Snackbar.make(((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0), message, Snackbar.LENGTH_SHORT).show();
    }


}
