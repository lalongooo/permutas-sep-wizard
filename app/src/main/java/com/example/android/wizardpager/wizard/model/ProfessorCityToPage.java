package com.example.android.wizardpager.wizard.model;


import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;

import com.example.android.wizardpager.wizard.ui.ProfessorCityToFragment;

/**
 * A page asking for a name and an email.
 */
public class ProfessorCityToPage extends Page {
	public static final String STATE_TO_DATA_KEY = "state_to";
	public static final String MUNICIPALITY_TO_DATA_KEY = "municipality_to";
	public static final String LOCALITY_TO_DATA_KEY = "locality_to";

	public ProfessorCityToPage(ModelCallbacks callbacks, String title) {
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return ProfessorCityToFragment.create(getKey());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
		dest.add(new ReviewItem("TU ESTADO DESEADO", mData.getString(STATE_TO_DATA_KEY), STATE_TO_DATA_KEY, -1));
		dest.add(new ReviewItem("TU MUNICIPIO DESEADO", mData.getString(MUNICIPALITY_TO_DATA_KEY), MUNICIPALITY_TO_DATA_KEY, -1));
		dest.add(new ReviewItem("TU LOCALIDAD DESEADO", mData.getString(LOCALITY_TO_DATA_KEY), LOCALITY_TO_DATA_KEY, -1));
	}

	@Override
	public boolean isCompleted() {
		return !TextUtils.isEmpty(mData.getString(STATE_TO_DATA_KEY));
	}
}