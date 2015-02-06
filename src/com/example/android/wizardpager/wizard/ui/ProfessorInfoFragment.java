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
import com.example.android.wizardpager.wizard.model.ProfessorInfoPage;

public class ProfessorInfoFragment extends Fragment {
    private static final String ARG_KEY = "key";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private Page mPage;
    
    private Spinner spnName;
    private Spinner spnEmail;
    private Spinner spnPhone;

    public static ProfessorInfoFragment create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        ProfessorInfoFragment fragment = new ProfessorInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ProfessorInfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (ProfessorInfoPage) mCallbacks.onGetPage(mKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page_professor_city_from, container, false);
        ((TextView) rootView.findViewById(android.R.id.title)).setText(mPage.getTitle());

//        mNameView = ((TextView) rootView.findViewById(R.id.your_name));
//        mNameView.setText(mPage.getData().getString(ProfessorInfoPage.NAME_DATA_KEY));
//
//        mEmailView = ((TextView) rootView.findViewById(R.id.your_email));
//        mEmailView.setText(mPage.getData().getString(ProfessorInfoPage.EMAIL_DATA_KEY));
//
//        mPhoneView = ((TextView) rootView.findViewById(R.id.your_phone));
//        mPhoneView.setText(mPage.getData().getString(ProfessorInfoPage.MOBILE_DATA_KEY));
        
		spnName = ((Spinner) rootView.findViewById(R.id.spn_your_name));
		spnEmail = ((Spinner) rootView.findViewById(R.id.spn_your_email));
		spnPhone = ((Spinner) rootView.findViewById(R.id.spn_your_phone));		
        
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

//        mNameView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                mPage.getData().putString(ProfessorInfoPage.NAME_DATA_KEY, (editable != null) ? editable.toString() : null);
//                mPage.notifyDataChanged();
//            }
//        });
//
//        mEmailView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { 
//            	Log.i("beforeTextChanged", charSequence.toString());
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { 
//            	Log.i("onTextChanged", charSequence.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                mPage.getData().putString(ProfessorInfoPage.EMAIL_DATA_KEY, (editable != null) ? editable.toString() : null);
//                mPage.notifyDataChanged();
//               Log.i("afterTextChanged", editable.toString());
//            }
//        });
//               
//        mPhoneView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                mPage.getData().putString(ProfessorInfoPage.MOBILE_DATA_KEY, (editable != null) ? editable.toString() : null);
//                mPage.notifyDataChanged();
//            }
//        });
    
        spnName.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedItemText = spnName.getSelectedItem().toString();
				Log.i("onItemSelected", selectedItemText);
				mPage.getData().putString(ProfessorInfoPage.NAME_DATA_KEY, (selectedItemText != null) ? selectedItemText.toString() : null);
                mPage.notifyDataChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});

        spnEmail.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedItemText = spnEmail.getSelectedItem().toString();
				Log.i("onItemSelected", selectedItemText);
				mPage.getData().putString(ProfessorInfoPage.EMAIL_DATA_KEY, (selectedItemText != null) ? selectedItemText.toString() : null);
                mPage.notifyDataChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
        
        spnPhone.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedItemText = spnPhone.getSelectedItem().toString();
				Log.i("onItemSelected", selectedItemText);
				mPage.getData().putString(ProfessorInfoPage.MOBILE_DATA_KEY, (selectedItemText != null) ? selectedItemText.toString() : null);
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
        if (spnPhone != null && spnPhone.getSelectedItem().toString() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (!menuVisible) {
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        }
    }
}
