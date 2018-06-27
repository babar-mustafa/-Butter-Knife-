package salonistan.ghazanfar.com.butterknife;


import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.text_display_view)
    TextView text_display_view;
    @BindDrawable(R.drawable.ic_launcher_background)
    Drawable drawable;
    @BindString(R.string.display_Text)
    String text;
    @BindColor(R.color.colorAccent)
    int color;


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);
        text_display_view.setText(text);
        text_display_view.setTextColor(color);
        return view;

    }

    @OnClick(R.id.checkbutton)
    public void OnClick(Button f) {
        f.setBackground(drawable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // unbind the view to free some memory
        unbinder.unbind();
    }

}
