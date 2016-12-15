package com.example.asad.homebuyerproject;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.net.Uri;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Asad on 11/16/2016.
 */

public class Fragment_Sell_Commercial_Shop extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button GetReady;

    private LinearLayout mPanle3;
    private TextView mMore;

    private TextView mFloorinc, mFloordec, mTotalFloorinc, mTotalFloordec;
    private TextView mValueFloor, mTotalFloorValue;
    private Integer FloorCounter = 1, TotalFloorCounter = 1;

    private OnFragmentInteractionListener mListener;

    public Fragment_Sell_Commercial_Shop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResidentialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResidentialFragment newInstance(String param1, String param2) {
        ResidentialFragment fragment = new ResidentialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_sell_commercial_shop, container, false);
        TypeCasting(view);
        ButtonClick();

            /*
        *do not use these methods its not for your use
         */
        MoreTextViewclickEvent();
        MoreTextEvent();




        /*
        On Click for Counters on first panel
         */

        //////////////////////////////////////////////////////////////////////////////////

        /////////////////////////////////
        mFloordec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int copy = DecrementFunction(FloorCounter);
                mValueFloor.setText(String.valueOf(copy));
                FloorCounter = copy;
            }
        });
        mFloorinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer copy = IncrementFunction(FloorCounter);
                mValueFloor.setText(String.valueOf(copy));
                FloorCounter = copy;
            }
        });


        ///////////////////////////////////////////////
        mTotalFloorinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer copy = IncrementFunction(TotalFloorCounter);
                mTotalFloorValue.setText(String.valueOf(copy));
                TotalFloorCounter = copy;
            }
        });

        mTotalFloordec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int copy = DecrementFunction(TotalFloorCounter);
                mTotalFloorValue.setText(String.valueOf(copy));
                TotalFloorCounter = copy;
            }
        });


        ///////////////////////////////////////////////////////////////////////////////////////////

        return view;
    }


    //Increment Counter for all counters
    private Integer IncrementFunction(int Counter) {


        if (Counter < 40) {
            Counter++;
            // mValueBathroom.setText(String.valueOf(Counter));
            // BathroomCounter++;
        } else {

            Toast.makeText(getActivity(), "Full", Toast.LENGTH_SHORT).show();
        }

        return Counter;
    }


    //Decrement Counter for all Counters
    private Integer DecrementFunction(int Counter) {

        if (Counter > 1) {
            Counter--;
            // mValueBathroom.setText(String.valueOf(Counter));
            // BathroomCounter--;
        } else {
            Toast.makeText(getActivity(), "Nothng Happen", Toast.LENGTH_SHORT).show();
        }

        return Counter;
    }


    private void MoreTextEvent() {

        mMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPanle3.setVisibility(View.VISIBLE);
                mMore.setVisibility(View.GONE);
            }
        });
    }

    private void MoreTextViewclickEvent() {


        mPanle3.setVisibility(View.GONE);

    }

    private void ButtonClick() {
        GetReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getActivity(), Activity_Uplaod_Property_Part2.class);
                String r = "Sell";
                next.putExtra("Sell", r);
                startActivity(next);
            }
        });
    }

    private void TypeCasting(View view) {
        GetReady = (Button) view.findViewById(R.id.Readytogo);


        mFloordec = (TextView) view.findViewById(R.id.incfloor);
        mFloorinc = (TextView) view.findViewById(R.id.decfloor);
        mTotalFloordec = (TextView) view.findViewById(R.id.inctotalfloor);
        mTotalFloorinc = (TextView) view.findViewById(R.id.dectotalfloor);
        mValueFloor = (TextView) view.findViewById(R.id.valuefloor);
        mTotalFloorValue = (TextView) view.findViewById(R.id.valuetotalfloor);

         /*
        Not for your use
         */
        mPanle3 = (LinearLayout) view.findViewById(R.id.panle3);
        mMore = (TextView) view.findViewById(R.id.more);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}