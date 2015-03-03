package com.example.android.wizardpager.wizard.model;

import com.example.android.wizardpager.wizard.ui.ProfessorCityFromFragment;
import com.permutassep.inegifacil.model.City;
import com.permutassep.inegifacil.model.State;
import com.permutassep.inegifacil.model.Town;

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
        State state = (State) mData.getParcelable(STATE_DATA_KEY);
		dest.add(new ReviewItem("ESTADO ORIGEN", state.getStateName(), STATE_DATA_KEY, -1));

        City city = (City) mData.getParcelable(MUNICIPALITY_DATA_KEY);
        dest.add(new ReviewItem("MUNICIPIO ORIGEN", city.getNombreMunicipio(), MUNICIPALITY_DATA_KEY, -1));

        Town town = (Town) mData.getParcelable(LOCALITY_DATA_KEY);
		dest.add(new ReviewItem("LOCALIDAD ORIGEN", town.getNombre(), LOCALITY_DATA_KEY, -1));
	}

	@Override
	public boolean isCompleted() {
		return mData.containsKey(LOCALITY_DATA_KEY);
	}
}