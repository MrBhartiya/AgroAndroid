package com.mrbhartiya.education.ui.activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.AssessmentModel;
import com.mrbhartiya.education.utility.PreferenceHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends BaseActivity implements
        OnChartValueSelectedListener {

    private PieChart chart;
    public static final int[] VORDIPLOM_COLORS = {
            Color.rgb(25, 111, 61), Color.rgb(192, 57, 43), Color.rgb(33, 97, 140)};
    int correct, wrong, skipped;
    int total;
    TextView mTittle;
    ImageView mBack;
    private TextView mSubmitResult;
    private int a;
    private TextView mQuestionStatus, skippedText, wrongText;

    private void submitResult() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("video_id", "MRV001");
        param.put("result", String.valueOf(a));
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<AssessmentModel> call = apiService.performResultOperation( param);
        call.enqueue(new Callback<AssessmentModel>() {
            @Override
            public void onResponse(Call<AssessmentModel> call, Response<AssessmentModel> response) {
                progressDialog.dismiss();

                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        Toast.makeText(ResultActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        finish();

                    } else {
                        Toast.makeText(ResultActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(ResultActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<AssessmentModel> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(ResultActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getIntentData() {
        correct = getIntent().getExtras().getInt("correct");
        wrong = getIntent().getExtras().getInt("wrong");
        skipped = getIntent().getExtras().getInt("skipped");
        total = getIntent().getExtras().getInt("total");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result);
        getIntentData();
        mSubmitResult = findViewById(R.id.submit_result);
        mTittle = findViewById(R.id.toolbar_signup).findViewById(R.id.toolbar_title);
        mBack = findViewById(R.id.toolbar_signup).findViewById(R.id.toolbar_left_icon);
        mBack.setVisibility(View.GONE);
        mTittle.setText("Your Score");
        mQuestionStatus = findViewById(R.id.correct);
        skippedText = findViewById(R.id.skipped);
        wrongText = findViewById(R.id.wrong);
        mQuestionStatus.setText(correct + " Correct");
        skippedText.setText(skipped + " Skipped");
        wrongText.setText(wrong + " Wrong");
        chart = findViewById(R.id.chart1);
        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(false);
        chart.setExtraOffsets(5, 10, 5, 5);
        chart.setDragDecelerationFrictionCoef(0.95f);

        chart.setCenterText(generateCenterSpannableText());

        chart.setDrawHoleEnabled(true);
        chart.setHoleColor(Color.TRANSPARENT);
        chart.setTransparentCircleColor(Color.WHITE);
        chart.setTransparentCircleAlpha(110);
        chart.setHoleRadius(58f);
        chart.setTransparentCircleRadius(61f);
        chart.setRotationAngle(0);
        chart.setRotationEnabled(true);
        chart.setHighlightPerTapEnabled(true);
        chart.setOnChartValueSelectedListener(this);
        chart.animateY(1400, Easing.EaseInOutQuad);
        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        chart.setEntryLabelColor(Color.WHITE);
        chart.setEntryLabelTextSize(12f);
        setData();
        mSubmitResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitResult();
            }
        });
    }

    private void setData() {

        chart.setRotationEnabled(false);

        int f1 = correct;
        int f2 = wrong;
        int f3 = skipped;
        int totalCountFloat = total;
        a = (f1 * 100) / totalCountFloat;
        int b = (f2 * 100) / totalCountFloat;
        int c = (f3 * 100) / totalCountFloat;
        //float c = (f3 * 100) / totalCountFloat;
        float[] VALUES = new float[]{a, b, c};
        List<PieEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        int j = 0;
        for (int i = 0; i < VALUES.length; i++) {
            if (VALUES[i] != 0.0) {
                entries.add(new PieEntry(VALUES[i], j));
                labels.add("");
                j++;
            }
        }

        PieDataSet dataSet = new PieDataSet(entries, "");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

//        for (int color : VORDIPLOM_COLORS)
//            colors.add(color);
//
        for (int i = 0; i < VORDIPLOM_COLORS.length; i++) {
            if (wrong == 0 && correct == 0) {
                colors.add(VORDIPLOM_COLORS[2]);
            } else
                colors.add(VORDIPLOM_COLORS[i]);
        }

        colors.add(ColorTemplate.getHoloBlue());

        PieDataSet dataset = new PieDataSet(entries, "");
        dataset.setValueFormatter(new PercentFormatter());
        dataset.setColors(colors);

        PieData data = new PieData(dataset);

        data.setValueFormatter(new PercentFormatter(chart));
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        chart.getLegend().setEnabled(false);
        chart.setData(data);
        chart.highlightValues(null);

        chart.invalidate();
    }
    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("Your Score");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), 0, s.length(), 0);
        return s;
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onBackPressed() {

    }
}
