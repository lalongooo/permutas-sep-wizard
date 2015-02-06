package com.example.android.wizardpager;

import android.content.Context;

import com.example.android.wizardpager.wizard.model.AbstractWizardModel;
import com.example.android.wizardpager.wizard.model.BranchPage;
import com.example.android.wizardpager.wizard.model.ProfessorContactInfoPage;
import com.example.android.wizardpager.wizard.model.PageList;
import com.example.android.wizardpager.wizard.model.ProfessorCityFromPage;
import com.example.android.wizardpager.wizard.model.SingleFixedChoicePage;

public class PermutaSepWizardModel extends AbstractWizardModel {
	public PermutaSepWizardModel(Context context) {
		super(context);
	}

	@Override
	protected PageList onNewRootPageList() {
		return new PageList(new BranchPage(this, "Tipo de plaza")
				.addBranch(
						"Estatal",
						new SingleFixedChoicePage(this, "Tipo de jornada").setChoices("Jornada Regular", "Jornada ampliada", "Tiempo completo").setRequired(true),
						new SingleFixedChoicePage(this, "Carrera magisterial").setChoices("Si", "No").setRequired(true))

				.addBranch(
						"Federal",
						new SingleFixedChoicePage(this, "Tipo de jornada").setChoices("Jornada Regular", "Jornada ampliada", "Tiempo completo").setRequired(true),
						new SingleFixedChoicePage(this, "Carrera magisterial").setChoices("Si", "No").setRequired(true))

				.setRequired(true),
		new ProfessorCityFromPage(this, "Tu ciudad de origen").setRequired(true),
		new ProfessorContactInfoPage(this, "Tu información").setRequired(true));
	}
}
