package com.example.android.wizardpager.wizard.model;

import com.example.android.wizardpager.wizard.ui.ProfessorInfoFragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * A page asking for a name and an email.
 */
public class ProfessorInfoPage extends Page {
	public static final String NAME_DATA_KEY = "name";
	public static final String EMAIL_DATA_KEY = "email";
	public static final String MOBILE_DATA_KEY = "mobile";

	public ProfessorInfoPage(ModelCallbacks callbacks, String title) {
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return ProfessorInfoFragment.create(getKey());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
		dest.add(new ReviewItem("Tu nombre", mData.getString(NAME_DATA_KEY), getKey(), -1));
		dest.add(new ReviewItem("Tu correo", mData.getString(EMAIL_DATA_KEY), getKey(), -1));
		dest.add(new ReviewItem("Tu teléfono", mData.getString(MOBILE_DATA_KEY), getKey(), -1));
	}

	@Override
	public boolean isCompleted() {
		return !TextUtils.isEmpty(mData.getString(NAME_DATA_KEY));
	}
}
