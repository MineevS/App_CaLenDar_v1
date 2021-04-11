package com.example.app_calendar_v1.ui.home;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app_calendar_v1.MainActivity;
import com.example.app_calendar_v1.MainActivity2;
import com.example.app_calendar_v1.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    CalendarView cal;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        /*
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */

        cal = (CalendarView) root.findViewById(R.id.calendarView);


        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {


                    Toast.makeText(view.getContext(), "Year=" + year + " Month=" + month + " Day=" + dayOfMonth, Toast.LENGTH_LONG).show();
                    //cal.setBackgroundColor(Color.RED);

                    Intent intent = new Intent(HomeFragment.this.getActivity(), MainActivity2.class);

                    startActivityForResult(intent, 1);

            }
        });



        return root;
    }
}