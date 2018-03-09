package com.example.rabiasultan.cwk1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.rabiasultan.cwk1.model.Holiday;
import com.example.rabiasultan.cwk1.model.HolidayData;

public class MainActivity extends AppCompatActivity implements

        NavigationView.OnNavigationItemSelectedListener,
        GalleryFragment.OnGalleryFragmentInteractionListener,
        HolidayDetailsFragment.OnHolidayDetailsFragmentInteractionListener,
        MyJournalPlacesVisitedFragment.OnMyJournalPlacesVisitedFragmentInteractionListener,
        TakePhotoFragment.OnTakePhotoInteractionListener,
        CreateNewHolidayFragment.OnCreateNewHolidayFragmentInteractionListener,
        CreateNewPlaceVisitedFragment.OnCreateNewPlaceVisitedFragmentInteractionListener,
        PlacesNearbyFragment.OnNearbyPlacesFragmentInteractionListener,
        MyProfileFragment.OnMyProfileFragmentInteractionListener,
        MyJournalFragment.OnMyJournalFragmentInteractionListener,
        HolidaysListFragment.OnHolidaysListFragmentInteractionListener//,
        //View.OnClickListener
{

    private FloatingActionButton fab;
    private boolean isFabVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Button button = (Button) this.findViewById(R.id.my_profile_button);
        //button.setOnClickListener(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // the FLOATING ACTION BUTTON will call the act button - from each activity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        isFabVisible = true;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if (f instanceof FabActionInterface) {
                    ((FabActionInterface) f).act();
                }
            }

        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        GalleryFragment firstFragment = new GalleryFragment();
        insertDefaultFragment(firstFragment);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void currentFragment () {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if (frag instanceof FabRespond) {
                    ((FabRespond)frag).fabClick();
                }
            }
        });
    }


    /* use this only to hide/show the FAB
    @Override
    public void toggleFab() {
        if (isFabVisible) {
            fab.hide();
        } else {
            fab.show();
        }
        isFabVisible = !isFabVisible;
    }
    */


    public void insertDefaultFragment(Fragment firstFragment) {
        // Create a new Fragment to be placed in the activity layout

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        firstFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, firstFragment).commit();
    }


    // this method should ensure that the back button goes back to the page open before the current one
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

                //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.travel_gallery) {

            // clicking on the travel gallery option
            GalleryFragment firstFragment = new GalleryFragment();
            insertDefaultFragment(firstFragment);

            // clicking on the My Journal option
        } else if (id == R.id.my_journal) {
            MyJournalFragment firstFragment = new MyJournalFragment();
            insertDefaultFragment(firstFragment);

            // clicking on the My Journal - holidays option
        } else if (id == R.id.my_holidays) {
            HolidaysListFragment firstFragment = new HolidaysListFragment();
            insertDefaultFragment(firstFragment);
            //HolidayDetailsFragment firstFragment = new HolidayDetailsFragment();
            //insertDefaultFragment(firstFragment);

            // clicking on the My Journal - places visited option
        } else if (id == R.id.my_places_visited) {
            MyJournalPlacesVisitedFragment firstFragment = new MyJournalPlacesVisitedFragment();
            insertDefaultFragment(firstFragment);

            // clicking on the Take photo option
        } else if (id == R.id.take_photo) {
            TakePhotoFragment firstFragment = new TakePhotoFragment();
            insertDefaultFragment(firstFragment);

            // clicking on the Create new holiday option
        } else if (id == R.id.create_new_holiday) {
            CreateNewHolidayFragment firstFragment = new CreateNewHolidayFragment();
            insertDefaultFragment(firstFragment);

            // clicking on the create new place visited option
        } else if (id == R.id.create_new_place_visited) {
            CreateNewPlaceVisitedFragment firstFragment = new CreateNewPlaceVisitedFragment();
            insertDefaultFragment(firstFragment);

            // clicking on the places nearby option
        } else if (id == R.id.places_nearby) {
            PlacesNearbyFragment firstFragment = new PlacesNearbyFragment();
            insertDefaultFragment(firstFragment);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onGalleryFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened My Gallery", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onHolidayDetailsFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened My Journal - Holidays", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMyJournalPlacesVisitedFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened My Journal - Places Visited", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTakePhotoFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened Take New photo ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateNewHolidayFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened Create New Holiday", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateNewPlaceVisitedFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened Create New Place Visited", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNearbyPlacesFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened Places Nearby", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMyProfileFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened My Profile", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMyJournalFragmentInteraction(Uri uri) {
        Toast.makeText(this, "opened My Journal - Full", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showEditHolidayFragment(Holiday item) {
        //Toast.makeText(this, "opened Holidays List", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "You clicked " + item.toString(), Toast.LENGTH_LONG).show();

        // add code here
        HolidayDetailsFragment newFragment = new HolidayDetailsFragment();
        //HolidayDetailsFragment newFragment = HolidayDetailsFragment.newInstance(item);

        // add an argument specifying the item it should show
        // note that the DummyItem class must implement Serializable
        Bundle args = new Bundle();
        //data item is added to the arguments bundle using:
        args.putSerializable("Item", item);
        newFragment.setArguments(args);

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }



    //@Override
    //public void onClick(View view) {
    //    Toast.makeText(this.getApplicationContext(),R.string.toastString, Toast.LENGTH_LONG).show();
    //}
}
