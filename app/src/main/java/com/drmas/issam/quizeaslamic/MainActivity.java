package com.drmas.issam.quizeaslamic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

public class MainActivity extends AppCompatActivity {

    private final static int FADE_DURATION = 1000;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        setAnimation();


    }//Main

    public void heightScore(View view){
        Intent intentScore = new Intent( MainActivity.this, HeightScore.class);
        startActivity( intentScore );
    }

    public void share(View view){

        String txtShare = " تحدى نفسك ";
        String shareLink = "https://play.google.com/store/apps/details?id=com.drmas.issam.quizeaslamic";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");

        share.putExtra(Intent.EXTRA_TEXT,txtShare + "\n" + shareLink);
        startActivity(share);

    }

    public void islamicClicked(View view){
      Intent intentIslamic = new Intent(MainActivity.this, IslamicActivity.class);
      startActivity( intentIslamic );
    }

    public void historyClicked(View view){
        Intent intentHistory = new Intent( MainActivity.this, HistoryActivity.class );
        startActivity( intentHistory );
    }

    public void geographicClicked(View view){
    Intent geographicIntent = new Intent( MainActivity.this, GeographicActivity.class );
    startActivity( geographicIntent );
    }

    public void capitalClicked(View view){
    Intent capitalIntent = new Intent( MainActivity.this, CapitalActivity.class );
    startActivity( capitalIntent );
    }

    public void scienceClicked(View view){
       Intent scienceIntent = new Intent( MainActivity.this, ScienceActivity.class );
       startActivity( scienceIntent );
    }

    public void artClicked(View view){
        Intent artIntent = new Intent( MainActivity.this, ArtActivity.class );
        startActivity( artIntent );

    }

    public void technologyClicked(View view){
        Intent intentTechnology = new Intent( MainActivity.this, TechnologyActivity.class );
        startActivity( intentTechnology );
    }

    public void sportClicked(View view){

        Intent intentSport = new Intent( MainActivity.this, SportActivity.class );
        startActivity( intentSport );

    }

    public void animalClicked(View view){
        Intent intentAnimals = new Intent( MainActivity.this, AnimalsActivity.class );
        startActivity( intentAnimals );
    }

    public void politicClicked(View view){
        Intent intentPolitic = new Intent( MainActivity.this, PoliticActivity.class );
        startActivity( intentPolitic );

    }

    public void culturalClicked(View view){
        Intent intentInventor = new Intent( MainActivity.this, CulturalActivity.class );
        startActivity( intentInventor );

    }

    public void generalClicked(View view){

        Intent intentGeneral = new Intent( MainActivity.this, GeneralActivity.class );
        startActivity( intentGeneral );
    }

    public void setAnimation(){

        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        anim.willChangeTransformationMatrix();
        anim.start();
    }

    @Override
    public void onBackPressed() {

    }
}
