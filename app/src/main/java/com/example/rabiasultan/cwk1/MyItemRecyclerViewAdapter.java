package com.example.rabiasultan.cwk1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.example.rabiasultan.cwk1.dummy.DummyContent1.DummyItem;
import com.example.rabiasultan.cwk1.model.Holiday;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Holiday} and makes a call to the
 * specified {@link HolidaysListFragment.OnHolidaysListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    //private final List<DummyItem> holidays;
    private final List<Holiday> holidays;
    private final HolidaysListFragment.OnHolidaysListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<Holiday> items, HolidaysListFragment.OnHolidaysListFragmentInteractionListener listener) {
        holidays = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = holidays.get(position);
        holder.mIdView.setText(holidays.get(position).getTitle());
        holder.mContentView.setText(holidays.get(position).getNotes());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.showEditHolidayFragment(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return holidays.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Holiday mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
