package salonistan.ghazanfar.com.butterknife;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    //refencing textview
    @BindView(R.id.text_display_view)
    TextView text_display_view;

    //refrencing the string
    @BindString(R.string.display_Text)
    String text;

    @BindColor(R.color.colorAccent)
    int color;

    @BindDrawable(R.drawable.ic_launcher_background)
    Drawable drawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //seeting text to textview
        text_display_view.setText(text);
        text_display_view.setTextColor(color);


    }
    public void FragmentTransitionNotes(android.app.Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.addToBackStack(null);
            transaction.replace(R.id.containerForHistory, fragment);
            transaction.commit();

        }
    }
    @OnClick(R.id.fragemnt)
    public void onClick(Button button) {

        FragmentTransitionNotes(new TestFragment());

    }

    //seeting the rrfrence and button click

    //ist way
    // click event with specific type param
    @OnClick(R.id.checkbutton)
    public void onButtonClick(Button button) {
        Toast.makeText(getApplicationContext(), "Check 123",
                Toast.LENGTH_SHORT).show();
        button.setBackground(drawable);
    }
    //second way
    // click event with source view params
//    @OnClick(R.id.checkbutton)
//    public void onButtonClick(View view) {
//        Toast.makeText(getApplicationContext(), "Check 123",
//                Toast.LENGTH_SHORT).show();
//    }

    //third
// click event without params
//    @OnClick(R.id.checkbutton)
//    public void onButtonClick() {
//        Toast.makeText(getApplicationContext(), "Check 123",
//                Toast.LENGTH_SHORT).show();
//    }
}
