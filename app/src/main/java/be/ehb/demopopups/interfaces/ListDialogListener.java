package be.ehb.demopopups.interfaces;

import java.util.ArrayList;

/**
 * Created by Q on 1-3-2018.
 */

public interface ListDialogListener { //in interface alleen final waarden en methodes , GEEN variabelen in interfaces

    public void onOkClicked(ArrayList<String> items); //body van deze methode wordt in de implementerende klasse overschreven
}
