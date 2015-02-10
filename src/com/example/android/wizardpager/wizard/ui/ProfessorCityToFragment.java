/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.wizardpager.wizard.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.wizardpager.R;
import com.example.android.wizardpager.wizard.model.Page;
import com.example.android.wizardpager.wizard.model.ProfessorCityToPage;

public class ProfessorCityToFragment extends Fragment {
    private static final String ARG_KEY = "key";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private Page mPage;
    
    private Spinner spnState;
    private Spinner spnMunicipality;
    private Spinner spnLocality;

    public static ProfessorCityToFragment create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        ProfessorCityToFragment fragment = new ProfessorCityToFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ProfessorCityToFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (ProfessorCityToPage) mCallbacks.onGetPage(mKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page_professor_city_to, container, false);
        ((TextView) rootView.findViewById(android.R.id.title)).setText(mPage.getTitle());
        
		spnState = ((Spinner) rootView.findViewById(R.id.spn_your_state));
		spnMunicipality = ((Spinner) rootView.findViewById(R.id.spn_your_municipality));
		spnLocality = ((Spinner) rootView.findViewById(R.id.spn_your_locality));		
        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof PageFragmentCallbacks)) {
            throw new ClassCastException("Activity must implement PageFragmentCallbacks");
        }

        mCallbacks = (PageFragmentCallbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    
        spnState.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedItemText = spnState.getSelectedItem().toString();
				Log.i("onItemSelected", selectedItemText);
				mPage.getData().putString(ProfessorCityToPage.STATE_TO_DATA_KEY, (selectedItemText != null) ? selectedItemText.toString() : null);
                mPage.notifyDataChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});

        spnMunicipality.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedItemText = spnMunicipality.getSelectedItem().toString();
				Log.i("onItemSelected", selectedItemText);
				mPage.getData().putString(ProfessorCityToPage.MUNICIPALITY_TO_DATA_KEY, (selectedItemText != null) ? selectedItemText.toString() : null);
                mPage.notifyDataChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
        
        spnLocality.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedItemText = spnLocality.getSelectedItem().toString();
				Log.i("onItemSelected", selectedItemText);
				mPage.getData().putString(ProfessorCityToPage.LOCALITY_TO_DATA_KEY, (selectedItemText != null) ? selectedItemText.toString() : null);
                mPage.notifyDataChanged();				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);

        // In a future update to the support library, this should override setUserVisibleHint
        // instead of setMenuVisibility.
        if (spnLocality != null && spnLocality.getSelectedItem().toString() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (!menuVisible) {
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        }
    }
}
