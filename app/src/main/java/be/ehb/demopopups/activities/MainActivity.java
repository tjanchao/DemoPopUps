package be.ehb.demopopups.activities;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import be.ehb.demopopups.R;
import be.ehb.demopopups.fragments.ListDialogFragment;
import be.ehb.demopopups.fragments.SimpleDialogFragment;
import be.ehb.demopopups.interfaces.ListDialogListener;

public class MainActivity extends AppCompatActivity implements ListDialogListener {

    private Button btnSimpleDialog;
    private Button btnListDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpleDialog = findViewById(R.id.btn_simple_dialog);

        btnSimpleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDialogFragment simpleDialogFragment = SimpleDialogFragment.newInstance();
                simpleDialogFragment.show(getSupportFragmentManager(),"sdf");
            }
        });
        btnListDialog = findViewById(R.id.btn_list_dialog);
        btnListDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListDialogFragment listDialogFragment = ListDialogFragment.newInstance();
                listDialogFragment.show(getSupportFragmentManager(),"ldf");
            }
        });
    }

    @Override
    public void onOkClicked(ArrayList<String> items) {//deze methode verschijnt als ListDialogListener-interface wordt geimplementeerd. Overschrijf de body van de interface-methode
        Toast.makeText(getApplicationContext(), items.toString(),Toast.LENGTH_LONG).show();

        Snackbar sb = Snackbar.make(findViewById(R.id.my_container),"Placed order", Snackbar.LENGTH_INDEFINITE);
        sb.setActionTextColor(Color.RED);
        sb.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Cancelled order",Toast.LENGTH_LONG).show();
            }
        });
        sb.show();

    }
}
