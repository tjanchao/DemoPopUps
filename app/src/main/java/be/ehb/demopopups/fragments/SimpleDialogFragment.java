package be.ehb.demopopups.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Q on 1-3-2018.
 */

public class SimpleDialogFragment extends DialogFragment {
    //lege constructor
    public SimpleDialogFragment() {
    }

    public static SimpleDialogFragment newInstance(){
        return new SimpleDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Alert");
        builder.setMessage("Pas op!");
        builder.setNegativeButton("Cancel",null);


        return builder.create(); //create-methode zet al je settings om naar een dialoogvenster


    }
}
