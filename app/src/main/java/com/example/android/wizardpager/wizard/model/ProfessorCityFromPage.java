package com.example.android.wizardpager.wizard.model;

import com.example.android.wizardpager.wizard.ui.ProfessorCityFromFragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * A page asking for a name and an email.
 */
public class ProfessorCityFromPage extends Page {
	public static final String STATE_DATA_KEY = "state_from";
	public static final String MUNICIPALITY_DATA_KEY = "municipality_from";
	public static final String LOCALITY_DATA_KEY = "locality_from";

	public ProfessorCityFromPage(ModelCallbacks callbacks, String title) {
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return ProfessorCityFromFragment.create(getKey());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
		dest.add(new ReviewItem("TU ESTADO DE ORIGEN", mData.getString(STATE_DATA_KEY), STATE_DATA_KEY, -1));
		dest.add(new ReviewItem("TU MUNICIPIO DE ORIGEN", mData.getString(MUNICIPALITY_DATA_KEY), MUNICIPALITY_DATA_KEY, -1));
		dest.add(new ReviewItem("TU LOCALIDAD DE ORIGEN", mData.getString(LOCALITY_DATA_KEY), LOCALITY_DATA_KEY, -1));
	}

	@Override
	public boolean isCompleted() {
		return !TextUtils.isEmpty(mData.getString(LOCALITY_DATA_KEY));
	}
}