package com.mrbhartiya.education.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.AssessmentModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    public int marks = 0, correct = 0, wrong = 0, skipped = 0;
    TextView tv, question_header, timer;
    Button submitbutton;
    RadioGroup answersgrp;
    TextView mTittle;
    ImageView mBack;
    int flag = 0;
    private List<AssessmentModel.DataBean> mAssessment = new ArrayList<>();
    private String selectedAnswer = "";
    private CountDownTimer questionTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        submitbutton = (Button) findViewById(R.id.submit_answer);
        question_header = findViewById(R.id.question_header);
        tv = (TextView) findViewById(R.id.tvque);
        answersgrp = findViewById(R.id.answersgrp);
        timer = findViewById(R.id.timer);
        mTittle = findViewById(R.id.toolbar_signup).findViewById(R.id.toolbar_title);
        mBack = findViewById(R.id.toolbar_signup).findViewById(R.id.toolbar_left_icon);
        mBack.setVisibility(View.GONE);
        mTittle.setText("Q/A time");
        getIntentData();
        setQuestion();

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionTimer.cancel();
                checkAnswer();
                flag++;
                setQuestion();
            }
        });


        answersgrp.setOnCheckedChangeListener(this);
    }

    private void checkAnswer() {
        if (selectedAnswer.equalsIgnoreCase(mAssessment.get(flag).getCorrect_answer())) {
            correct = correct + 1;
        } else if (!selectedAnswer.equalsIgnoreCase("") && !selectedAnswer.equalsIgnoreCase(mAssessment.get(flag).getCorrect_answer())) {
            wrong = wrong + 1;
        } else
            skipped = skipped + 1;
        selectedAnswer = "";
    }

    private void startTimer() {
        questionTimer = new CountDownTimer(30000, 1000) {                     //geriye sayma

            public void onTick(long millisUntilFinished) {
                timer.setText("Time remaining: " + millisUntilFinished / 1000);

            }
            public void onFinish() {
                questionTimer.cancel();
                submitbutton.performClick();
            }
        }.start();


    }

    private void setQuestion() {
        if (flag < mAssessment.size()) {
            question_header.setText("Question " + (flag + 1) + "/" + mAssessment.size());
            tv.setText(mAssessment.get(flag).getQuestion());
            setOption();
            startTimer();
        }
        if (flag + 1 == mAssessment.size()) {
            submitbutton.setText("Submit");
        } else if (submitbutton.getText().toString().equalsIgnoreCase("Submit")) {
            questionTimer.cancel();
            Intent questionResult = new Intent(this, ResultActivity.class);
            questionResult.putExtra("total", mAssessment.size());
            questionResult.putExtra("skipped", skipped);
            questionResult.putExtra("correct", correct);
            questionResult.putExtra("wrong", wrong);
            startActivity(questionResult);
            finish();
        }

    }

    private void setOption() {
        RadioGroup.LayoutParams rprms;
        answersgrp.removeAllViews();
        for (int i = 0; i < mAssessment.get(flag).getTotal_option(); i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setTextSize(24);
            radioButton.setTextColor(getResources().getColor(R.color.colorAccent));
            radioButton.setText(mAssessment.get(flag).getOptions().get(i).getOption());
            radioButton.setId(View.generateViewId());
            rprms = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rprms.setMargins(0, 30, 0, 0);
            answersgrp.addView(radioButton, rprms);
        }
    }

    private void getIntentData() {
        Intent i = getIntent();
        if (i.hasExtra("assessment")) {
            mAssessment = (ArrayList<AssessmentModel.DataBean>) getIntent().getSerializableExtra("assessment");
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        for (int i = 0; i < answersgrp.getChildCount(); i++) {
            RadioButton btn = (RadioButton) answersgrp.getChildAt(i);
            if (btn.getId() == checkedId) {
                selectedAnswer = btn.getText().toString();
                return;
            }

        }

    }

    @Override
    public void onBackPressed() {
    }
}