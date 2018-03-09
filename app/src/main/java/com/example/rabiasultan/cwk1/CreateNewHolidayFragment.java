package com.example.rabiasultan.cwk1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rabiasultan.cwk1.model.Holiday;
import com.example.rabiasultan.cwk1.model.HolidayData;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnCreateNewHolidayFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreateNewHolidayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateNewHolidayFragment extends Fragment {


    // TODO: Rename and change types of parameters

    private Holiday holiday;
    private OnCreateNewHolidayFragmentInteractionListener mListener;

    private TextView textView;
    private EditText editText;
    private Button save;

    public HolidayData holidayData;



    public CreateNewHolidayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CreateNewHolidayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateNewHolidayFragment newInstance(String param1, String param2) {
        CreateNewHolidayFragment fragment = new CreateNewHolidayFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        holiday = new Holiday(1, "Title", "notes");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create_new_holiday, container, false);

          /* Initializing views */
        textView = (EditText) v.findViewById(R.id.holiday_title);
        textView.addTextChangedListener(editWatcher);
        editText = (EditText) v.findViewById(R.id.holiday_title) ;

        holiday = new Holiday();

        save = (Button) v.findViewById(R.id.save_new_holiday);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "TEST", Toast.LENGTH_LONG).show();

                //creates a new holiday
                holidayData.getInstance().addHoliday(holiday);
            }

        });

        return v;
    }

    private final TextWatcher editWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Toast.makeText(getContext(), "The text changed", Toast.LENGTH_LONG).show();
        }

        public void afterTextChanged(Editable s) {
            String holiday_title = editText.getText().toString();
            holiday.setTitle(holiday_title);
        }
    };


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onCreateNewHolidayFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCreateNewHolidayFragmentInteractionListener) {
            mListener = (OnCreateNewHolidayFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCreateNewHolidayFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCreateNewHolidayFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCreateNewHolidayFragmentInteraction(Uri uri);
    }
}
