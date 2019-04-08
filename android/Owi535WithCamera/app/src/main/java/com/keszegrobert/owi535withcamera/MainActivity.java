package com.keszegrobert.owi535withcamera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Owi535 robot;
    private Button btBaseMinus;
    private Button btBasePlus;
    private Button btShoulderMinus;
    private Button btShoulderPlus;
    private Button btElbowMinus;
    private Button btElbowPlus;
    private Button btWristMinus;
    private Button btWristPlus;
    private Button btGripOpen;
    private Button btGripClose;
    private Button btLedOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btBaseMinus = findViewById(R.id.btBaseMinus);
        btBaseMinus.setOnClickListener(this);
        btBasePlus = findViewById(R.id.btBasePlus);
        btBasePlus.setOnClickListener(this);
        btShoulderMinus = findViewById(R.id.btShoulderMinus);
        btShoulderMinus.setOnClickListener(this);
        btShoulderPlus = findViewById(R.id.btShoulderPlus);
        btShoulderPlus.setOnClickListener(this);
        btElbowMinus = findViewById(R.id.btElbowMinus);
        btElbowMinus.setOnClickListener(this);
        btElbowPlus = findViewById(R.id.btElbowPlus);
        btElbowPlus.setOnClickListener(this);
        btWristMinus = findViewById(R.id.btWristMinus);
        btWristMinus.setOnClickListener(this);
        btWristPlus = findViewById(R.id.btWristPlus);
        btWristPlus.setOnClickListener(this);
        btGripClose = findViewById(R.id.btGripClose);
        btGripClose.setOnClickListener(this);
        btGripOpen = findViewById(R.id.btGripOpen);
        btGripOpen.setOnClickListener(this);
        btLedOn = findViewById(R.id.btLedOn);
        btLedOn.setOnClickListener(this);
        robot = new Owi535();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btBaseMinus:
                robot.rotateBaseAntiClockwise();
                break;
            case R.id.btBasePlus:
                robot.rotateBaseClockwise();
                break;
            case R.id.btShoulderMinus:
                robot.rotateShoulderAntiClockwise();
                break;
            case R.id.btShoulderPlus:
                robot.rotateShoulderClockwise();
                break;
            case R.id.btElbowMinus:
                robot.rotateElbowAntiClockwise();
                break;
            case R.id.btElbowPlus:
                robot.rotateElbowClockwise();
                break;
            case R.id.btWristMinus:
                robot.rotateWristAntiClockwise();
                break;
            case R.id.btWristPlus:
                robot.rotateWristClockwise();
                break;
            case R.id.btGripOpen:
                robot.openGrip();
                break;
            case R.id.btGripClose:
                robot.closeGrip();
                break;
            case R.id.btLedOn:
                robot.switchLedOn();
                break;
        }
    }
}
