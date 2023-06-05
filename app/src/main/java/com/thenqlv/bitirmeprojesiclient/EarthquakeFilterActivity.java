package com.thenqlv.bitirmeprojesiclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.thenqlv.bitirmeprojesiclient.Filters.EarthquakeFilter;
import com.thenqlv.bitirmeprojesiclient.Validations.EarthquakeFilterValidation;
import com.thenqlv.bitirmeprojesiclient.Validations.Validation;

public class EarthquakeFilterActivity extends AppCompatActivity {



    private TextView startDateTextView;
    private TextView endDateTextView;
    private TextView minMagmitudeTextView;
    private TextView maxMagnitudeTextVeiew;
    private TextView minDepthTextView;
    private TextView maxDepthTextView;
    private TextView minLatTextView;
    private TextView maxLatTextView;
    private TextView minLonTextView;
    private TextView maxLonTextView;
    private TextView latTextView;
    private TextView lonTextView;
    private TextView minRadTextView;
    private TextView maxRadTextView;
    private TextView limitTextView;

    private EditText startDateEditText;
    private EditText endDateEditText;
    private EditText minMagnitudeEditText;
    private EditText maxMagnitudeEditText;
    private EditText minDepthEditText;
    private EditText maxDepthEditText;
    private EditText minLatEditText;
    private EditText maxLatEditText;
    private EditText minLonEditText;
    private EditText maxLonEditText;
    private EditText latEditText;
    private EditText lonEditText;
    private EditText minRadEditText;
    private EditText maxRadEditText;
    private EditText limitEditText;
    private RadioButton rectangleBoundsRadioButton;
    private RadioButton radialBoundsRadioButton;
    private Button filterButton;


    private void findViewsById(){
        startDateEditText = findViewById(R.id.editTextDateStart);
        endDateEditText = findViewById(R.id.editTextDateEnd);
        minMagnitudeEditText = findViewById(R.id.editTextNumberDecimalMinMangnitude);
        maxMagnitudeEditText = findViewById(R.id.editTextNumberDecimalMaxMangnitude);
        minDepthEditText = findViewById(R.id.editTextNumberSignedMinDepth);
        maxDepthEditText = findViewById(R.id.editTextNumberSignedMaxDepth);
        minLatEditText = findViewById(R.id.editTextNumberDecimalMinLat);
        maxLatEditText = findViewById(R.id.editTextNumberDecimalMaxLat);
        minLonEditText = findViewById(R.id.editTextNumberDecimalMinLon);
        maxLonEditText = findViewById(R.id.editTextNumberDecimalMaxLon);
        latEditText = findViewById(R.id.editTextNumberDecimalLat);
        lonEditText = findViewById(R.id.editTextNumberDecimalLon);
        minRadEditText = findViewById(R.id.editTextNumberDecimalMinRad);
        maxRadEditText = findViewById(R.id.editTextNumberDecimalMaxRad);
        limitEditText = findViewById(R.id.editTextNumberSignedLimit);
        filterButton = findViewById(R.id.filterButton);
        rectangleBoundsRadioButton = findViewById(R.id.rectangleBoundsRadioButton);
        radialBoundsRadioButton = findViewById(R.id.radialBoundsRadioButton);
        startDateTextView = findViewById(R.id.textViewDateStart);
        endDateTextView = findViewById(R.id.textViewDateEnd);
        minMagmitudeTextView = findViewById(R.id.textViewMinMangnitude);
        maxMagnitudeTextVeiew = findViewById(R.id.textViewMaxMangnitude);
        minDepthTextView = findViewById(R.id.textViewMinDepth);
        maxDepthTextView = findViewById(R.id.textViewMaxDepth);
        minLatTextView = findViewById(R.id.textViewMinLat);
        maxLatTextView = findViewById(R.id.textViewMaxLat);
        minLonTextView = findViewById(R.id.textViewMinLon);
        maxLonTextView = findViewById(R.id.textViewMaxLon);
        latTextView = findViewById(R.id.textViewLat);
        lonTextView = findViewById(R.id.textViewLon);
        minRadTextView = findViewById(R.id.textViewMinRad);
        maxRadTextView = findViewById(R.id.textViewMaxRad);
        limitTextView = findViewById(R.id.textViewLimit);

    }
    private void activateRectangleBounds(){
        latEditText.setEnabled(false);
        latEditText.setText("");
        latEditText.setHint("not editable");

        lonEditText.setEnabled(false);
        lonEditText.setText("");
        lonEditText.setHint("not editable");

        minRadEditText.setEnabled(false);
        minRadEditText.setText("");
        minRadEditText.setHint("not editable");

        maxRadEditText.setEnabled(false);
        maxRadEditText.setText("");
        maxRadEditText.setHint("not editable");

        minLatEditText.setEnabled(true);
        minLatEditText.setHint("min lat");

        maxLatEditText.setEnabled(true);
        maxLatEditText.setHint("max lat");

        minLonEditText.setEnabled(true);
        minLonEditText.setHint("min lon");

        maxLonEditText.setEnabled(true);
        maxLonEditText.setHint("max lon");
    }
    private void activateRadialBounds(){
        latEditText.setEnabled(true);
        latEditText.setHint("lat");

        lonEditText.setEnabled(true);
        lonEditText.setHint("lon");

        minRadEditText.setEnabled(true);
        minRadEditText.setHint("min rad");

        maxRadEditText.setEnabled(true);
        maxRadEditText.setHint("max rad");

        minLatEditText.setEnabled(false);
        minLatEditText.setText("");
        minLatEditText.setHint("not editable");

        maxLatEditText.setEnabled(false);
        maxLatEditText.setText("");
        maxLatEditText.setHint("not editable");

        minLonEditText.setEnabled(false);
        minLonEditText.setText("");
        minLonEditText.setHint("not editable");

        maxLonEditText.setEnabled(false);
        maxLonEditText.setText("");
        maxLonEditText.setHint("not editable");
    }
    public EarthquakeFilter getEarthquakeFilter(){
        EarthquakeFilter filter = new EarthquakeFilter();

        filter.setStartDate(startDateEditText.getText().toString());
        filter.setEndDate(endDateEditText.getText().toString());
        filter.setMinMagnitude(minMagnitudeEditText.getText().toString());
        filter.setMaxMagnitude(maxMagnitudeEditText.getText().toString());
        filter.setMinDepth(minDepthEditText.getText().toString());
        filter.setMaxDepth(maxDepthEditText.getText().toString());
        filter.setMinLat(minLatEditText.getText().toString());
        filter.setMaxLat(maxLatEditText.getText().toString());
        filter.setMinLon(minLonEditText.getText().toString());
        filter.setMaxLon(maxLonEditText.getText().toString());
        filter.setLat(latEditText.getText().toString());
        filter.setLon(lonEditText.getText().toString());
        filter.setMinRad(minRadEditText.getText().toString());
        filter.setMaxRad(maxRadEditText.getText().toString());
        filter.setLimit(limitEditText.getText().toString());
        return filter;
    }

    private boolean checkValidation(String value,TextView textView,String regex){
        boolean r = Validation.validateValue(
                regex,value
        );
        if(!r) {
            textView.setTextColor(Color.RED);
            textView.setText("gecersiz deger!!!");
        }
        else{
            textView.setText("");
        }
        return r;
    }

    private boolean checkValidations(){
        EarthquakeFilter earthquakeFilter = getEarthquakeFilter();
        boolean r0 = checkValidation(
                earthquakeFilter.getStartDate(),
                startDateTextView,
                EarthquakeFilterValidation.startDateRegex
        );
        boolean r1 = checkValidation(
                earthquakeFilter.getEndDate(),
                endDateTextView,
                EarthquakeFilterValidation.endDateRegex
        );
        boolean r2 = checkValidation(
                earthquakeFilter.getMinMagnitude(),
                minMagmitudeTextView,
                EarthquakeFilterValidation.minMagnitudeRegex
        );
        boolean r3 = checkValidation(
                earthquakeFilter.getMaxMagnitude(),
                maxMagnitudeTextVeiew,
                EarthquakeFilterValidation.maxMagnitudeRegex
        );
        boolean r4 = checkValidation(
                earthquakeFilter.getMinDepth(),
                minDepthTextView,
                EarthquakeFilterValidation.minDepthRegex
        );
        boolean r5 = checkValidation(
                earthquakeFilter.getMaxDepth(),
                maxDepthTextView,
                EarthquakeFilterValidation.maxDepthRegex
        );
        boolean r6 = checkValidation(
                earthquakeFilter.getMinLat(),
                minLatTextView,
                EarthquakeFilterValidation.minLatRegex
        );
        boolean r7 = checkValidation(
                earthquakeFilter.getMaxLat(),
                maxLatTextView,
                EarthquakeFilterValidation.maxLatRegex
        );
        boolean r8 = checkValidation(
                earthquakeFilter.getMinLon(),
                minLonTextView,
                EarthquakeFilterValidation.minLonRegex
        );
        boolean r9 = checkValidation(
                earthquakeFilter.getMaxLon(),
                maxLonTextView,
                EarthquakeFilterValidation.maxLonRegex
        );
        boolean r10 = checkValidation(
                earthquakeFilter.getLat(),
                latTextView,
                EarthquakeFilterValidation.minLatRegex
        );
        boolean r11 = checkValidation(
                earthquakeFilter.getLon(),
                lonTextView,
                EarthquakeFilterValidation.lonRegex
        );
        boolean r12 = checkValidation(
                earthquakeFilter.getMinRad(),
                minRadTextView,
                EarthquakeFilterValidation.minRadRegex
        );
        boolean r13 = checkValidation(
                earthquakeFilter.getMaxRad(),
                maxRadTextView,
                EarthquakeFilterValidation.maxRadRegex
        );
        boolean r14 = checkValidation(
                earthquakeFilter.getLimit(),
                limitTextView,
                EarthquakeFilterValidation.limitRegex
        );
        return r0 && r1 && r2 && r3 && r4 && r5 && r6 && r7 && r8 && r9 && r10 && r11 && r12 && r13 && r14;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_filter);
        findViewsById();

        rectangleBoundsRadioButton.setChecked(true);
        activateRectangleBounds();
        rectangleBoundsRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    activateRectangleBounds();
                }
            }
        });

        radialBoundsRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    activateRadialBounds();
                }
            }
        });
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkValidations()) {
                    Intent intent = new Intent(view.getContext(), MapsActivity.class);
                    intent.putExtra("filter", getEarthquakeFilter());
                    startActivity(intent);
                }
            }
        });
    }
}