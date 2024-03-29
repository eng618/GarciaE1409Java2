package com.garciaericn.weather.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garciaericn.weather.R;
import com.garciaericn.weather.objects.CurrentWeather;

import java.util.List;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 9/25/14.
 */
public class ForecastWeatherFragment extends Fragment{
    private static final String ARG_SECTION_NUMBER = "section_number";

    // Callback
    public interface ForecastFragmentCallback{
        public List<CurrentWeather> getForecastWeather(String requestType);
    }

    public static ForecastWeatherFragment newInstance(int sectionNumber) {
        ForecastWeatherFragment fragment = new ForecastWeatherFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forecast_weather, container, false);
        return rootView;
    }
}
