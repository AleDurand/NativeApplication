package com.adurand.nativeapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.adurand.nativeapplication.fragments.HomeFragment;
import com.adurand.nativeapplication.fragments.MagazineListFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // First menu item
        navigationView.getMenu().getItem(0).setChecked(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.nav_home));
        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            if(navigationView.getMenu().getItem(0).isChecked()){
                super.onBackPressed();
            } else {
                navigationView.getMenu().getItem(0).setChecked(true);
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_home));
                Fragment fragment = new HomeFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_home));
                fragment = new HomeFragment();
                break;
            case R.id.nav_offers:
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_offers));
                fragment = new MagazineListFragment();
                break;
            case R.id.nav_magazines:
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_magazines));
                fragment = new MagazineListFragment();
                break;
            case R.id.nav_orders:
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_orders));
                fragment = new MagazineListFragment();
                break;
            case R.id.nav_stores:
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_stores));
                fragment = new MagazineListFragment();
                break;
            case R.id.nav_contact:
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_contact));
                fragment = new MagazineListFragment();
                break;
            case R.id.nav_settings:
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_settings));
                fragment = new MagazineListFragment();
                break;
            default:
                getSupportActionBar().setTitle(getResources().getString(R.string.nav_home));
                fragment = new HomeFragment();
                break;
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commitAllowingStateLoss();

        // Close the navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
