package com.kurasaketh.lifecycle;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Variables vars;
    TextView textcreate;
    TextView textstart;
    TextView textresume;
    TextView textpause;
    TextView textstop;
    TextView textrestart;
    TextView textdestroy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        vars = new Variables();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vars.incCreate();
        int i = sharedPreferences.getInt("create", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("create", i + 1);
        editor.apply();
        Log.i("message", "Create " + sharedPreferences.getInt("create", 0));
        textcreate = findViewById(R.id.textcreate);
        textstart = findViewById(R.id.textstart);
        textresume = findViewById(R.id.textresume);
        textpause = findViewById(R.id.textpause);
        textstop = findViewById(R.id.textstop);
        textrestart = findViewById(R.id.textrestart);
        textdestroy = findViewById(R.id.textdestroy);
    }
    @Override
    protected void onStart() {
        super.onStart();
        vars.incStart();
        int i = sharedPreferences.getInt("start", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("start", i + 1);
        editor.apply();
        Log.i("message", "Start " + sharedPreferences.getInt("start", 0));
    }
    @Override
    protected void onResume() {
        super.onResume();
        vars.incResume();
        int i = sharedPreferences.getInt("resume", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("resume", i + 1);
        editor.apply();
        Log.i("message", "Resume " + sharedPreferences.getInt("resume", 0));
    }
    @Override
    protected void onPause() {
        super.onPause();
        vars.incPause();
        int i = sharedPreferences.getInt("pause", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("pause", i + 1);
        editor.apply();
        Log.i("message", "Pause " + sharedPreferences.getInt("pause", 0));
    }
    @Override
    protected void onStop() {
        super.onStop();
        vars.incStop();
        int i = sharedPreferences.getInt("stop", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("stop", i + 1);
        editor.apply();
        Log.i("message", "Stop " + sharedPreferences.getInt("stop", 0));

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        vars.incRestart();
        int i = sharedPreferences.getInt("restart", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("restart", i + 1);
        editor.apply();
        Log.i("message", "Restart " + sharedPreferences.getInt("restart", 0));

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        vars.incDestroy();
        int i = sharedPreferences.getInt("destroy", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("destroy", i + 1);
        editor.apply();
        Log.i("message", "Destroy " + sharedPreferences.getInt("destroy", 0));
    }
    public void reset(View v){
        vars.reset();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    public void display_info(View v){
//        text.setText("Create: " + vars.getCreate() + " Start: " + vars.getStart() + " Resume: " + vars.getResume() + " Pause: " + vars.getPause() + " Stop: " + vars.getStop() + " Restart: " + vars.getRestart() + " Destroy: ");
        textcreate.setText("Create: " + vars.getCreate());
        textstart.setText("Start: " + vars.getStart());
        textresume.setText("Resume: " + vars.getResume());
        textpause.setText("Pause: " + vars.getPause());
        textstop.setText("Stop: " + vars.getStop());
        textrestart.setText("Restart: " + vars.getRestart());
        textdestroy.setText("Destroy: " + vars.getDestroy());
    }
    public void display_info2(View v){
        textcreate.setText(String.format("Create: %d", sharedPreferences.getInt("create", 0)));
        textstart.setText(String.format("Start: %d", sharedPreferences.getInt("start", 0)));
        textresume.setText(String.format("Resume: %d", sharedPreferences.getInt("resume", 0)));
        textpause.setText(String.format("Pause: %d", sharedPreferences.getInt("pause", 0)));
        textstop.setText(String.format("Stop: %d", sharedPreferences.getInt("stop", 0)));
        textrestart.setText(String.format("Restart: %d", sharedPreferences.getInt("restart", 0)));
        textdestroy.setText(String.format("Destroy: %d", sharedPreferences.getInt("destroy", 0)));
    }

}
class Variables{
    private int create = 0;
    private int start = 0;
    private int resume = 0;
    private int pause = 0;
    private int stop = 0;
    private int restart = 0;
    private int destroy = 0;
    public void reset(){
        create = 0;
        start = 0;
        resume = 0;
        pause  = 0;
        stop = 0;
        restart = 0;
        destroy = 0;
    }

    public int getCreate() {
        return create;
    }

    public int getStart() {
        return start;
    }

    public int getResume() {
        return resume;
    }

    public int getPause() {
        return pause;
    }

    public int getStop() {
        return stop;
    }

    public int getRestart() {
        return restart;
    }

    public int getDestroy() {
        return destroy;
    }

    public void incCreate(){
        create +=1;
    }
    public void incStart(){
        start +=1;
    }
    public void incResume(){
        resume +=1;
    }
    public void incPause(){
        pause +=1;
    }
    public void incStop(){
        stop +=1;
    }
    public void incRestart(){
        restart +=1;
    }
    public void incDestroy(){
        destroy +=1;
    }

}
