package be.ehb.demopopups.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;

import be.ehb.demopopups.interfaces.ListDialogListener;

/**
 * Created by Q on 1-3-2018.
 */

public class ListDialogFragment extends DialogFragment {

    private String[] toppingsList = {"sla","tomaat","kaas","komkommer","gerookte zalm","hesp","mayo","ei"};
    private boolean[] selectedToppingsList = new boolean[toppingsList.length];

    private ListDialogListener mListDialogListener;

    public ListDialogFragment(){//deze lege constructor kan je optioneel weglaten omdat java achterliggend al een lege constructor aanmaakt zonder dat je er zelf iets voor hoeft te doen.
    }

    public static ListDialogFragment newInstance(){
        return new ListDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final ArrayList<String> gekozenToppings = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose topping");
        builder.setMultiChoiceItems(toppingsList, selectedToppingsList, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) { //i is index van item (int which); b is boolean of item gechecked is of niet (boolean isChecked)
                if (b){
                    gekozenToppings.add(toppingsList[i]);
                }else{
                    gekozenToppings.remove(toppingsList[i]);
                }

            }
        });
        builder.setNegativeButton("Cancel",null);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListDialogListener.onOkClicked(gekozenToppings);
            }
        });


        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mListDialogListener = (ListDialogListener) context;
    }
}
