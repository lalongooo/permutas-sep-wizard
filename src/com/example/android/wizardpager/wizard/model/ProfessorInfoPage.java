package com.example.android.wizardpager.wizard.model;

import com.example.android.wizardpager.wizard.ui.ProfessorInfoFragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * A page asking for a name and an email.
 */
public class ProfessorInfoPage extends Page {
	public static final String STATE_DATA_KEY = "state";
	public static final String MUNICIPALITY_DATA_KEY = "municipality";
	public static final String LOCALITY_DATA_KEY = "locality";

	public ProfessorInfoPage(ModelCallbacks callbacks, String title) {
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return ProfessorInfoFragment.create(getKey());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
		dest.add(new ReviewItem("TU ESTADO", mData.getString(STATE_DATA_KEY), getKey(), -1));
		dest.add(new ReviewItem("TU MUNICIPIO", mData.getString(MUNICIPALITY_DATA_KEY), getKey(), -1));
		dest.add(new ReviewItem("TU LOCALIDAD", mData.getString(LOCALITY_DATA_KEY), getKey(), -1));
	}

	@Override
	public boolean isCompleted() {
		return !TextUtils.isEmpty(mData.getString(STATE_DATA_KEY));
	}
}
