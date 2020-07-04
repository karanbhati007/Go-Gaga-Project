package project.ksb.gogagakaranbhati.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.chip.ChipGroup;

import project.ksb.gogagakaranbhati.R;

public class AppPrefrences extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_app,container,false);

        Switch s1 = v.findViewById(R.id.switch1);
        Switch s2 = v.findViewById(R.id.switch2);

        final RelativeLayout r1 = v.findViewById(R.id.card1);
        final RelativeLayout r2 = v.findViewById(R.id.card2);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                    r1.setBackgroundColor(getResources().getColor(R.color.whiteColour));
                else
                    r1.setBackgroundColor(getResources().getColor(R.color.colorLight));

            }
        });

        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                    r2.setBackgroundColor(getResources().getColor(R.color.whiteColour));
                else
                    r2.setBackgroundColor(getResources().getColor(R.color.colorLight));

            }
        });


        return v;
    }
}
