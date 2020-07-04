package project.ksb.gogagakaranbhati.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.appyvet.materialrangebar.RangeBar;

import java.util.ArrayList;

import project.ksb.gogagakaranbhati.R;

public class MatchPrefrences extends Fragment {
    ToggleButton maleBtm;
    ToggleButton femaleBtn;
    ScaleAnimation scaleAnimation;
    TextView start,end;
    ImageView genderImage;
    ArrayList<Integer> selectedGender = new ArrayList<>();
    ArrayList<Integer> maleImg = new ArrayList<>();
    ArrayList<Integer> femaleImg = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_match, container, false);

        maleBtm = v.findViewById(R.id.male);
        femaleBtn = v.findViewById(R.id.female);

        start = v.findViewById(R.id.agefrom);
        end = v.findViewById(R.id.ageEnd);

        maleImg.add(R.drawable.m1);
        maleImg.add(R.drawable.m2);
        maleImg.add(R.drawable.m3);

        femaleImg.add(R.drawable.f1);
        femaleImg.add(R.drawable.f2);
        femaleImg.add(R.drawable.f3);

        initAnim();

        heartButtons();
        selectedGender = maleImg;
     //   maleBtm.setChecked(true);


        genderImage = v.findViewById(R.id.genderImage);
        genderImage.setImageDrawable(getResources().getDrawable(R.drawable.f1));

        RangeBar rangeBar = v.findViewById(R.id.rangeBar);

        rangeBar.setRangePinsByValue(25,35);

        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
//                if(leftPinIndex>rightPinIndex)
//                    rangeBar.setRangeBarEnabled(false);
//                else
//                    rangeBar.setRangeBarEnabled(false);


                int left = Integer.parseInt(leftPinValue);
                int right = Integer.parseInt(rightPinValue);

                if(selectedGender!=null && selectedGender.size()>0)
                {
                    if (left >= 18)
                        genderImage.setImageResource(selectedGender.get(0));


                    if (left > 25)
                        genderImage.setImageResource(selectedGender.get(1));

                    if (left > 50)
                        genderImage.setImageResource(selectedGender.get(2));
                }

                start.setText(Integer.toString(left));
                end.setText(Integer.toString(right));

            }

            @Override
            public void onTouchEnded(RangeBar rangeBar) {

            }

            @Override
            public void onTouchStarted(RangeBar rangeBar) {

            }
        });


        return v;
    }

    private void heartButtons() {

        maleBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (maleBtm.isChecked())
                    femaleBtn.setChecked(false);
            }
        });

        femaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (femaleBtn.isChecked())
                    maleBtm.setChecked(false);
            }
        });

        maleBtm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.startAnimation(scaleAnimation);
                    selectedGender = maleImg;
                    genderImage.setImageResource(R.drawable.m1);
                }
            }
        });

        femaleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.startAnimation(scaleAnimation);
                    selectedGender = femaleImg;
                    genderImage.setImageResource(R.drawable.f1);
                }
            }
        });
    }

    private void initAnim() {
        scaleAnimation = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new BounceInterpolator());
    }
}
