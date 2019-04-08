package com.keszegrobert.owi535withcamera;


import android.util.Log;

class Owi535 {
    private String TAG="OWI535";

    public void rotateBaseClockwise() {
        Log.d(this.TAG,"base+");
    }

    public void rotateBaseAntiClockwise() {
        Log.d(this.TAG,"base-");
    }

    public void rotateShoulderClockwise() {
        Log.d(this.TAG,"shoulder+");
    }

    public void rotateShoulderAntiClockwise() {
        Log.d(this.TAG,"shoulder-");
    }

    public void rotateElbowClockwise() {
        Log.d(this.TAG,"elbow+");
    }

    public void rotateElbowAntiClockwise() {
        Log.d(this.TAG,"elbow-");
    }

    public void rotateWristClockwise() {
        Log.d(this.TAG,"wrist+");
    }

    public void rotateWristAntiClockwise() {
        Log.d(this.TAG,"wrist-");
    }

    public void openGrip() {
        Log.d(this.TAG,"grip+");
    }

    public void closeGrip() {
        Log.d(this.TAG,"grip-");
    }

    public void switchLedOn(){
        Log.d(TAG, "LED On");
    }
    public void switchLedOff(){
        Log.d(TAG, "LED Off");
    }
}
