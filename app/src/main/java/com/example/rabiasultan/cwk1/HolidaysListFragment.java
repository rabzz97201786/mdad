package com.example.rabiasultan.cwk1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.example.rabiasultan.cwk1.dummy.DummyContent1;
//import com.example.rabiasultan.cwk1.dummy.DummyContent1.DummyItem;
import com.example.rabiasultan.cwk1.model.Holiday;
import com.example.rabiasultan.cwk1.model.HolidayData;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnHolidaysListFragmentInteractionListener}
 * interface.
 */
public class HolidaysListFragment extends Fragment implements FabActionInterface, FabRespond {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnHolidaysListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    public HolidaysListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static HolidaysListFragment newInstance(int columnCount) {
        HolidaysListFragment fragment = new HolidaysListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_holidays_list, container, false);

        // Set the adapter
        if (v instanceof RecyclerView) {
            Context context = v.getContext();
            RecyclerView recyclerView = (RecyclerView) v;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(HolidayData.getInstance().getHolidays(), mListener));
        }
        return v;

    }

    /*public void addNewHoliday() {
        holidayData.getInstance().addHoliday(holiday);
        newInstance(CreateNewHolidayFragment);
    }
    */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHolidaysListFragmentInteractionListener) {
            mListener = (OnHolidaysListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnHolidaysListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // FOR THIS PAGE ONLY use this method to determine what happens when clicked
    @Override
    public void act() {

        //put the fabRespond method here..

        //this will not work
        // this method needs to call the main activity --> to create a new holiday
        // /HolidayData.getInstance().addHoliday();


        // fab.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View view) {
        //      mListener.showEditHolidayFragment(new Holiday(1, "title", "notes"));
        //  }
        // });

    }

    @Override
    public void fabClick() {
        mListener.showEditHolidayFragment(new Holiday(1, "Title", "Notes"));
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnHolidaysListFragmentInteractionListener {
        // TODO: Update argument type and name

    //refactored...
        void showEditHolidayFragment(Holiday item);
    }


}
