package com.drmas.issam.quizeaslamic;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class HeightScore extends AppCompatActivity {

    private Toolbar heightScoreToolbar;
    SharedPreferences sharedPreferences;

    private TextView newScoreIslamicText;
    private Button heightScoreIslamicText;
    int scoreIslamic;

    int scoreHistory;
    private TextView newScoreHistoryText;
    private Button heightScoreHistoryText;

    int scoreGeographic;
    private TextView newScoreGeographicTxt;
    private Button heightScoreGeographicTxt;

    int scoreCapital;
    private TextView newScoreCapitalTxt;
    private Button heightScoreCapitalTxt;

    int scoreScience;
    private TextView newScoreScienceTxt;
    private Button heightScoreScienceTxt;

    int scoreTechnology;
    private TextView newScoreTechnologyTxt;
    private TextView heightScoreTechnologyTxt;

    int scoreArt;
    private TextView newScoreArtTxt;
    private Button heightScoreArtTxt;

    int scoreSport;
    private TextView newScoreSportTxt;
    private Button heightScoreSportTxt;

    int scoreAnimal;
    private TextView newScoreAnimalTxt;
    private Button heightScoreAnimalTxt;

    int scorePolitic;
    private TextView newScorePoliticTxt;
    private Button heightScorePoliticTxt;

    int scoreCultural;
    private TextView newScoreCulturalTxt;
    private Button heightScoreCulturalTxt;

    int scoreGeneral;
    private TextView newScoreGeneralTxt;
    private Button heightScoreGeneralTxt;

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_height_score );

        heightScoreToolbar = findViewById( R.id.islamicToolbar );
        setSupportActionBar( heightScoreToolbar );
        setTitle( null );

        AdRequest adRequest = new AdRequest.Builder().build();

        interstitialAd = new InterstitialAd( HeightScore.this );
        interstitialAd.setAdUnitId( "ca-app-pub-3940256099942544/1033173712" );
        interstitialAd.loadAd( adRequest );
        interstitialAd.setAdListener( new AdListener(){
            @Override
            public void onAdLoaded() {
                displayInterstitial();
            }

        } );

        Intent intentIslamic = getIntent();
        scoreIslamic = intentIslamic.getIntExtra( "scoreIslamic", (byte) 0 );

        newScoreIslamicText = (TextView) findViewById( R.id.niewScoreIslamicView);
        heightScoreIslamicText = (Button) findViewById( R.id.heightScoreIslamicView);
        heightScoreIslamicText.setEnabled( false );

        Intent intentHistory = getIntent();
        scoreHistory = intentHistory.getIntExtra( "scoreHistory", (byte) 0 );

        newScoreHistoryText = (TextView) findViewById( R.id.newScoreHistoryView );
        heightScoreHistoryText = (Button) findViewById( R.id.heigthScoreHistorycView);
        heightScoreHistoryText.setEnabled( false );

        Intent intentGeographic = getIntent();
        scoreGeographic = intentGeographic.getIntExtra( "scoreGeographic", (byte) 0 );

        newScoreGeographicTxt = (TextView) findViewById( R.id.newScoreGeographicView );
        heightScoreGeographicTxt = (Button) findViewById( R.id.heigthScoreGeographicView);
        heightScoreGeographicTxt.setEnabled( false );

        Intent intentCapital = getIntent();
        scoreCapital = intentCapital.getIntExtra( "scoreCapital", (byte) 0);

        newScoreCapitalTxt = (TextView) findViewById( R.id.newScoreCapitalView );
        heightScoreCapitalTxt = (Button) findViewById( R.id.heigthScoreCapitalView );
        heightScoreCapitalTxt.setEnabled( false );

        Intent intentScience = getIntent();
        scoreScience = intentScience.getIntExtra( "scoreScience", (byte) 0 );

        newScoreScienceTxt = (TextView) findViewById( R.id.newScoreScienceView );
        heightScoreScienceTxt = (Button) findViewById( R.id.heightScoreScienceView );
        heightScoreScienceTxt.setEnabled( false );

        Intent intentTechnology = getIntent();
        scoreTechnology = intentTechnology.getIntExtra( "scoreTechnology", (byte) 0);

        newScoreTechnologyTxt = (TextView) findViewById( R.id.newScoreTechView );
        heightScoreTechnologyTxt = (TextView) findViewById( R.id.heightScoreTechView );

        heightScoreTechnologyTxt.setEnabled( false );

        Intent intentArt = getIntent();
        scoreArt = intentArt.getIntExtra( "scoreArt", (byte) 0 );

        newScoreArtTxt = (TextView) findViewById( R.id.newScoreArtView );
        heightScoreArtTxt = (Button) findViewById( R.id.heightScoreArtView );
        heightScoreArtTxt.setEnabled( false );

        Intent intentSport = getIntent();
        scoreSport = intentSport.getIntExtra( "scoreSport", (byte) 0 );

        newScoreSportTxt = (TextView) findViewById( R.id.newScoreSportView );
        heightScoreSportTxt = (Button) findViewById( R.id.heightScoreSportView );

        heightScoreSportTxt.setEnabled( false );
        heightScoreSportTxt.setEnabled( false );

        Intent intentAnimals = getIntent();
        scoreAnimal = intentAnimals.getIntExtra( "scoreAnimal", (byte) 0);

        newScoreAnimalTxt = (TextView) findViewById( R.id.newScoreAnimalsView );
        heightScoreAnimalTxt = (Button) findViewById( R.id.heightScoreAnimalsView );

        heightScoreAnimalTxt.setEnabled( false );
        heightScoreAnimalTxt.setEnabled( false );

        Intent intentPolitic = getIntent();
        scorePolitic = intentPolitic.getIntExtra( "scorePolitic", (byte) 0 );

        newScorePoliticTxt = (TextView) findViewById( R.id.newScorePoliticView );
        heightScorePoliticTxt = (Button) findViewById( R.id.heightScorePoliticView );

        heightScorePoliticTxt.setEnabled( false );
        heightScorePoliticTxt.setEnabled( false );

        Intent intentInventor = getIntent();
        scoreCultural = intentInventor.getIntExtra( "scoreCultural", (byte) 0 );

        newScoreCulturalTxt = (TextView) findViewById( R.id.newScoreCulturalView);
        heightScoreCulturalTxt = (Button) findViewById( R.id.heightScoreCulturalView );

        heightScoreCulturalTxt.setEnabled( false );
        heightScoreCulturalTxt.setFocusable( false );

        Intent intentGeneral = getIntent();
        scoreGeneral = intentGeneral.getIntExtra( "scoreGeneral", (byte) 0 );

        newScoreGeneralTxt = (TextView) findViewById( R.id.newScoreGeneralView );
        heightScoreGeneralTxt = (Button) findViewById( R.id.heightScoreGeneralView );

        heightScoreGeneralTxt.setEnabled( false );
        heightScoreGeneralTxt.setFocusable( false );

        loadScoreIslamic();
        loadScoreHistory();

        loadScoreGeographic();
        loadScoreCapital();

        loadScoreScience();
        loadScoreTechnology();

        loadScoreArt();
        loadScoreSport();

        loadScoreAnimals();
        loadScorePolitic();

        loadScoreCultural();
        loadScoreGeneral();

    } /// End Main

    private void displayInterstitial() {

        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }

    private void loadScoreIslamic(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreIslamicText.setText(sharedPreferences.getString("scoreIslamic",String.valueOf( scoreIslamic+" / 100" )));

        newScoreIslamicText.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreIslamicText.setTextColor( Color.WHITE );

            heightScoreIslamicText.setEnabled( true );
            heightScoreIslamicText.setText( sharedPreferences.getString( "playNowIslamic", "Play now !" ));

            heightScoreIslamicText.setTextColor( Color.WHITE );
            heightScoreIslamicText.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreIslamic >= 1 && scoreIslamic <= 19){

            heightScoreIslamicText.setText( "  Bad  " );
            newScoreIslamicText.setText(scoreIslamic+" / 100");
            heightScoreIslamicText.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreIslamic >= 20 && scoreIslamic <= 39){

            heightScoreIslamicText.setText( " Good " );
            newScoreIslamicText.setText(scoreIslamic+" / 100");
            heightScoreIslamicText.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreIslamic >= 40 && scoreIslamic <= 59){

            heightScoreIslamicText.setText( " Awesome " );
            newScoreIslamicText.setText(scoreIslamic+" / 100");
            heightScoreIslamicText.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreIslamic >= 60 && scoreIslamic <= 79){

            heightScoreIslamicText.setText( " Amazing " );
            newScoreIslamicText.setText(scoreIslamic+" / 100");
            heightScoreIslamicText.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreIslamic >= 80 && scoreIslamic <= 99){

            heightScoreIslamicText.setText( " Wonderful " );
            newScoreIslamicText.setText(scoreIslamic+" / 100");
            heightScoreIslamicText.setBackgroundResource( R.drawable.awsome_score_normal );


        }
        else if (scoreIslamic == 100){

            heightScoreIslamicText.setText( "Finished" );
            newScoreIslamicText.setText( "100 / 100");
            heightScoreIslamicText.setBackgroundResource( R.drawable.finished_score_normal );

        }

    }

    private void loadScoreHistory(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreHistoryText.setText(sharedPreferences.getString("scoreHistory",String.valueOf( scoreHistory+" / 100" )));

        newScoreHistoryText.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreHistoryText.setTextColor( Color.WHITE );

        heightScoreHistoryText.setEnabled( true );
        heightScoreHistoryText.setText( sharedPreferences.getString( "playNowHistory", "Play now !" ));

        heightScoreHistoryText.setTextColor( Color.WHITE );
        heightScoreHistoryText.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreHistory >= 1 && scoreHistory <= 19){

            heightScoreHistoryText.setText( "  Bad  " );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreHistory >= 20 && scoreHistory <= 39){

            heightScoreHistoryText.setText( " Good " );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreHistory >= 40 && scoreHistory <= 59){

            heightScoreHistoryText.setText( " Awesome " );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreHistory >= 60 && scoreHistory <= 79){

            heightScoreHistoryText.setText( " Amazing " );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreHistory >= 80 && scoreHistory <= 99){

            heightScoreHistoryText.setText( " Wonderful " );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreHistory == 100){

            heightScoreHistoryText.setText( "Finished" );
            newScoreHistoryText.setText( "100 / 100");
            heightScoreHistoryText.setBackgroundResource( R.drawable.finished_score_normal );

        }
    }

    private void loadScoreCapital(){

             sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
             newScoreCapitalTxt.setText(sharedPreferences.getString("scoreCapital",String.valueOf( scoreCapital+" / 100" )));

             newScoreCapitalTxt.setBackgroundResource(R.drawable.custom_start_btn );
             newScoreCapitalTxt.setTextColor( Color.WHITE );

             heightScoreCapitalTxt.setEnabled( true );
             heightScoreCapitalTxt.setText( sharedPreferences.getString( "playNowCapital", "Play now !" ));

             heightScoreCapitalTxt.setTextColor( Color.WHITE );
             heightScoreCapitalTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

         if (scoreCapital >= 1 && scoreCapital <= 19 ){

            newScoreCapitalTxt.setText(scoreCapital+" / 100");
            heightScoreCapitalTxt.setText( "  Bad  " );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.custom_cancel_btn);
         }
         else if (scoreCapital >= 20 && scoreCapital <= 39){

            newScoreCapitalTxt.setText(scoreCapital+" / 100");
            heightScoreCapitalTxt.setText( " Good " );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.medium_score_normal );

         }
         else if (scoreCapital >= 40 && scoreCapital <= 59){

            newScoreCapitalTxt.setText(scoreCapital+" / 100");
            heightScoreCapitalTxt.setText( " Awesome " );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreCapital >= 60 && scoreCapital <= 79){

            newScoreCapitalTxt.setText(scoreCapital+" / 100");
            heightScoreCapitalTxt.setText( " Amazing " );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreCapital >= 80 && scoreCapital <= 99){

            newScoreCapitalTxt.setText(scoreCapital+" / 100");
            heightScoreCapitalTxt.setText( " Wonderful " );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreCapital == 100){

            newScoreCapitalTxt.setText( "100 / 100");
            heightScoreCapitalTxt.setText( "Finished" );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }
    }

    private void loadScoreGeographic(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreGeographicTxt.setText(sharedPreferences.getString("scoreGeographic",String.valueOf( scoreGeographic+" / 100" )));

        newScoreGeographicTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreGeographicTxt.setTextColor( Color.WHITE );


        heightScoreGeographicTxt.setEnabled( true );
        heightScoreGeographicTxt.setText( sharedPreferences.getString( "playNowGeographic", "Play now !" ));

        heightScoreGeographicTxt.setTextColor( Color.WHITE );
        heightScoreGeographicTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreGeographic >= 1 && scoreGeographic <= 19){

            heightScoreGeographicTxt.setText( "  Bad  " );
            newScoreGeographicTxt.setText(scoreGeographic+" / 100");
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreGeographic >= 20 && scoreGeographic <= 39){

            heightScoreGeographicTxt.setText( " Good " );
            newScoreGeographicTxt.setText(scoreGeographic+" / 100");
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreGeographic >= 40 && scoreGeographic <= 59){

            heightScoreGeographicTxt.setText( " Awesome " );
            newScoreGeographicTxt.setText(scoreGeographic+" / 100");
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreGeographic >= 60 && scoreGeographic <= 79){

            heightScoreGeographicTxt.setText( " Amazing " );
            newScoreGeographicTxt.setText(scoreGeographic+" / 100");
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreGeographic >= 80 && scoreGeographic <= 99){

            heightScoreGeographicTxt.setText( " Wonderful " );
            newScoreGeographicTxt.setText(scoreGeographic+" / 100");
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreGeographic == 100){

            heightScoreGeographicTxt.setText( "Finished" );
            newScoreGeographicTxt.setText( "100 / 100");
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }

    }

    private void loadScoreScience(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreScienceTxt.setText(sharedPreferences.getString("scoreScience",String.valueOf( scoreScience+" / 100" )));

        newScoreScienceTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreScienceTxt.setTextColor( Color.WHITE );


        heightScoreScienceTxt.setEnabled( true );
        heightScoreScienceTxt.setText( sharedPreferences.getString( "playNowScience", "Play now !" ));

        heightScoreScienceTxt.setTextColor( Color.WHITE );
        heightScoreScienceTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreScience >= 1 && scoreScience <= 19){

            heightScoreScienceTxt.setText( "  Bad  " );
            newScoreScienceTxt.setText(scoreScience+" / 100");
            heightScoreScienceTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreScience >= 20 && scoreScience <= 39){

            heightScoreScienceTxt.setText( " Good " );
            newScoreScienceTxt.setText(scoreScience+" / 100");
            heightScoreScienceTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreScience >= 40 && scoreScience <= 59){

            heightScoreScienceTxt.setText( " Awesome " );
            newScoreScienceTxt.setText(scoreIslamic+" / 100");
            heightScoreScienceTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreScience >= 60 && scoreScience <= 79){

            heightScoreScienceTxt.setText( " Amazing " );
            newScoreScienceTxt.setText(scoreScience+" / 100");
            heightScoreScienceTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreScience >= 80 && scoreScience <= 99){

            heightScoreScienceTxt.setText( " Wonderful " );
            newScoreScienceTxt.setText(scoreScience+" / 100");
            heightScoreScienceTxt.setBackgroundResource( R.drawable.awsome_score_normal );


        }
        else if (scoreScience == 100){

            heightScoreScienceTxt.setText( "Finished" );
            newScoreScienceTxt.setText( "100 / 100");
            heightScoreScienceTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }

    }

    private void loadScoreArt(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreArtTxt.setText(sharedPreferences.getString("scoreArt",String.valueOf( scoreArt+" / 100" )));

        newScoreArtTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreArtTxt.setTextColor( Color.WHITE );


        heightScoreArtTxt.setEnabled( true );
        heightScoreArtTxt.setText( sharedPreferences.getString( "playNowArt", "Play now !" ));

        heightScoreArtTxt.setTextColor( Color.WHITE );
        heightScoreArtTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreArt >= 1 && scoreArt <= 19){

            heightScoreArtTxt.setText( "  Bad  " );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreArt >= 20 && scoreArt <= 39){

            heightScoreArtTxt.setText( " Good " );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreArt >= 40 && scoreArt <= 59){

            heightScoreArtTxt.setText( " Awesome " );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreArt >= 60 && scoreArt <= 79){

            heightScoreArtTxt.setText( " Amazing " );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreArt >= 80 && scoreArt <= 99){

            heightScoreArtTxt.setText( " Wonderful " );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreArt == 100){

            heightScoreArtTxt.setText( "Finished" );
            newScoreArtTxt.setText( "100 / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }
    }

    private void loadScoreTechnology(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreTechnologyTxt.setText(sharedPreferences.getString("scoreTechnology",String.valueOf( scoreTechnology+" / 100" )));

        newScoreTechnologyTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreTechnologyTxt.setTextColor( Color.WHITE );

        heightScoreTechnologyTxt.setEnabled( true );
        heightScoreTechnologyTxt.setText( sharedPreferences.getString( "playNowTech", "Play now !" ));

        heightScoreTechnologyTxt.setTextColor( Color.WHITE );
        heightScoreTechnologyTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreTechnology >= 1 && scoreTechnology <= 19){

            heightScoreTechnologyTxt.setText( "  Bad  " );
            newScoreTechnologyTxt.setText(scoreTechnology+" / 100");
            heightScoreTechnologyTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreTechnology >= 20 && scoreTechnology <= 39){

            heightScoreTechnologyTxt.setText( " Good " );
            newScoreTechnologyTxt.setText(scoreTechnology+" / 100");
            heightScoreTechnologyTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreTechnology >= 40 && scoreTechnology <= 59){

            heightScoreTechnologyTxt.setText( " Awesome " );
            newScoreTechnologyTxt.setText(scoreTechnology+" / 100");
            heightScoreTechnologyTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreTechnology >= 60 && scoreTechnology <= 79){

            heightScoreTechnologyTxt.setText( " Amazing " );
            newScoreTechnologyTxt.setText(scoreTechnology+" / 100");
            heightScoreTechnologyTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreTechnology >= 80 && scoreTechnology <= 99){

            heightScoreTechnologyTxt.setText( " Wonderful " );
            newScoreTechnologyTxt.setText(scoreTechnology+" / 100");
            heightScoreTechnologyTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreTechnology == 100){

            heightScoreTechnologyTxt.setText( "Finished" );
            newScoreTechnologyTxt.setText( "100 / 100");
            heightScoreTechnologyTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    private void loadScoreSport(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreSportTxt.setText(sharedPreferences.getString("scoreSport",String.valueOf( scoreSport+" / 100" )));

        newScoreSportTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreSportTxt.setTextColor( Color.WHITE );

        heightScoreSportTxt.setEnabled( true );
        heightScoreSportTxt.setText( sharedPreferences.getString( "playNowSport", "Play now !" ));

        heightScoreSportTxt.setTextColor( Color.WHITE );
        heightScoreSportTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreSport >= 1 && scoreSport <= 100){

            heightScoreSportTxt.setFocusable(true);
            heightScoreSportTxt.setFocusableInTouchMode(true);
            heightScoreSportTxt.requestFocus();

        }

        if (scoreSport >= 1 && scoreSport <= 19){

            heightScoreSportTxt.setText( "  Bad  " );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreSport >= 20 && scoreSport <= 39){

            heightScoreSportTxt.setText( " Good " );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreSport >= 40 && scoreSport <= 59){

            heightScoreSportTxt.setText( " Awesome " );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreSport >= 60 && scoreSport <= 79){

            heightScoreSportTxt.setText( " Amazing " );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreSport >= 80 && scoreSport <= 99){

            heightScoreSportTxt.setText( " Wonderful " );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreSport == 100){

            heightScoreSportTxt.setText( "Finished" );
            newScoreSportTxt.setText( "100 / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    private void loadScoreAnimals(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreAnimalTxt.setText(sharedPreferences.getString("scoreAnimal",String.valueOf( scoreAnimal+" / 100" )));

        newScoreAnimalTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreAnimalTxt.setTextColor( Color.WHITE );

        heightScoreAnimalTxt.setEnabled( true );
        heightScoreAnimalTxt.setText( sharedPreferences.getString( "playNowAnimal", "Play now !" ));

        heightScoreAnimalTxt.setTextColor( Color.WHITE );
        heightScoreAnimalTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreAnimal >= 1 && scoreAnimal <= 100){

            heightScoreAnimalTxt.setFocusable(true);
            heightScoreAnimalTxt.setFocusableInTouchMode(true);
            heightScoreAnimalTxt.requestFocus();

        }

        if (scoreAnimal >= 1 && scoreAnimal <= 19){

            heightScoreAnimalTxt.setText( "  Bad  " );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreAnimal >= 20 && scoreAnimal <= 39){

            heightScoreAnimalTxt.setText( " Good " );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreAnimal >= 40 && scoreAnimal <= 59){

            heightScoreAnimalTxt.setText( " Awesome " );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreAnimal >= 60 && scoreAnimal <= 79){

            heightScoreAnimalTxt.setText( " Amazing " );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreAnimal >= 80 && scoreAnimal <= 99){

            heightScoreAnimalTxt.setText( " Wonderful " );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreAnimal == 100){

            heightScoreAnimalTxt.setText( "Finished" );
            newScoreAnimalTxt.setText( "100 / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }

    }

    private void loadScorePolitic(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScorePoliticTxt.setText(sharedPreferences.getString("scorePolitic",String.valueOf( scorePolitic+" / 100" )));

        newScorePoliticTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScorePoliticTxt.setTextColor( Color.WHITE );

        heightScorePoliticTxt.setEnabled( true );
        heightScorePoliticTxt.setText( sharedPreferences.getString( "playNowPolitic", "Play now !" ));

        heightScorePoliticTxt.setTextColor( Color.WHITE );
        heightScorePoliticTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scorePolitic >= 1 && scorePolitic <= 100){

            heightScorePoliticTxt.setFocusable(true);
            heightScorePoliticTxt.setFocusableInTouchMode(true);
            heightScorePoliticTxt.requestFocus();

        }

        if (scorePolitic >= 1 && scorePolitic <= 19){

            heightScorePoliticTxt.setText( "  Bad  " );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scorePolitic >= 20 && scorePolitic <= 39){

            heightScorePoliticTxt.setText( " Good " );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scorePolitic >= 40 && scorePolitic <= 59){

            heightScorePoliticTxt.setText( " Awesome " );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scorePolitic >= 60 && scorePolitic <= 79){

            heightScorePoliticTxt.setText( " Amazing " );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scorePolitic >= 80 && scorePolitic <= 99){

            heightScorePoliticTxt.setText( " Wonderful " );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scorePolitic == 100){

            heightScorePoliticTxt.setText( "Finished" );
            newScorePoliticTxt.setText( "100 / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    private void loadScoreCultural(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreCulturalTxt.setText(sharedPreferences.getString("scoreCultural",String.valueOf( scoreCultural+" / 100" )));

        newScoreCulturalTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreCulturalTxt.setTextColor( Color.WHITE );

        heightScoreCulturalTxt.setEnabled( true );
        heightScoreCulturalTxt.setText( sharedPreferences.getString( "playNowCultural", "Play now !" ));

        heightScoreCulturalTxt.setTextColor( Color.WHITE );
        heightScoreCulturalTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreCultural >= 1 && scoreCultural<= 100){

            heightScoreCulturalTxt.setFocusable(true);
            heightScoreCulturalTxt.setFocusableInTouchMode(true);
            heightScoreCulturalTxt.requestFocus();
        }

        if (scoreCultural >= 1 && scoreCultural <= 19){

            heightScoreCulturalTxt.setText( "  Bad  " );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreCultural >= 20 && scoreCultural <= 39){

            heightScoreCulturalTxt.setText( " Good " );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreCultural >= 40 && scoreCultural <= 59){

            heightScoreCulturalTxt.setText( " Awesome " );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreCultural >= 60 && scoreCultural <= 79){

            heightScoreCulturalTxt.setText( " Amazing " );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreCultural >= 80 && scoreCultural <= 99){

            heightScoreCulturalTxt.setText( " Wonderful " );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreCultural == 100){

            heightScoreCulturalTxt.setText( "Finished" );
            newScoreCulturalTxt.setText( "100 / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    private void loadScoreGeneral(){

              sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
              newScoreGeneralTxt.setText(sharedPreferences.getString("scoreGeneral",String.valueOf( scoreGeneral+" / 100" )));

              newScoreGeneralTxt.setBackgroundResource(R.drawable.custom_start_btn );
              newScoreGeneralTxt.setTextColor( Color.WHITE );


              heightScoreGeneralTxt.setEnabled( true );
              heightScoreGeneralTxt.setText( sharedPreferences.getString( "playNowGeneral", "Play now !" ));

              heightScoreGeneralTxt.setTextColor( Color.WHITE );
              heightScoreGeneralTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

              if (scoreGeneral >= 1 && scoreGeneral <= 100){

                  heightScoreGeneralTxt.setFocusable(true);
                  heightScoreGeneralTxt.setFocusableInTouchMode(true);
                  heightScoreGeneralTxt.requestFocus();

              }

        if (scoreGeneral >= 1 && scoreGeneral <= 19){

            heightScoreGeneralTxt.setText( "  Bad  " );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreGeneral >= 20 && scoreGeneral <= 39){

            heightScoreGeneralTxt.setText( " Good " );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreGeneral >= 40 && scoreGeneral <= 59){

            heightScoreGeneralTxt.setText( " Awesome " );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreGeneral >= 60 && scoreGeneral <= 79){

            heightScoreGeneralTxt.setText( " Amazing " );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreGeneral >= 80 && scoreGeneral <= 99){

            heightScoreGeneralTxt.setText( " Wonderful " );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreGeneral == 100){

            heightScoreGeneralTxt.setText( "Finished" );
            newScoreGeneralTxt.setText( "100 / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
          }

    private void savePreferences(String key, String value) {

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){

        savePreferences( "scoreIslamic", newScoreIslamicText.getText().toString() );
        savePreferences( "playNowIslamic", heightScoreIslamicText.getText().toString());

        savePreferences( "scoreHistory", newScoreHistoryText.getText().toString());
        savePreferences( "playNowHistory", heightScoreHistoryText.getText().toString());

        savePreferences( "scoreGeographic", newScoreGeographicTxt.getText().toString());
        savePreferences( "playNowGeographic", heightScoreGeographicTxt.getText().toString());

        savePreferences( "scoreCapital", newScoreCapitalTxt.getText().toString());
        savePreferences( "playNowCapital", heightScoreCapitalTxt.getText().toString());

        savePreferences( "scoreScience", newScoreScienceTxt.getText().toString());
        savePreferences( "playNowScience", heightScoreScienceTxt.getText().toString());

        savePreferences( "scoreTechnology", newScoreTechnologyTxt.getText().toString());
        savePreferences( "playNowTech", heightScoreTechnologyTxt.getText().toString());

        savePreferences( "scoreArt", newScoreArtTxt.getText().toString());
        savePreferences( "playNowArt", heightScoreArtTxt.getText().toString());

        savePreferences( "scoreSport", newScoreSportTxt.getText().toString());
        savePreferences( "playNowSport", heightScoreSportTxt.getText().toString());

        savePreferences( "scoreAnimal", newScoreAnimalTxt.getText().toString());
        savePreferences( "playNowAnimal", heightScoreAnimalTxt.getText().toString());

        savePreferences( "scorePolitic", newScorePoliticTxt.getText().toString());
        savePreferences( "playNowPolitic", heightScorePoliticTxt.getText().toString());

        savePreferences( "scoreCultural", newScoreCulturalTxt.getText().toString());
        savePreferences( "playNowCultural", heightScoreCulturalTxt.getText().toString());

        savePreferences("scoreGeneral", newScoreGeneralTxt.getText().toString());
        savePreferences( "playNowGeneral", heightScoreGeneralTxt.getText().toString());

    }

    public void mainActivity(){

        Intent mainIntent = new Intent( HeightScore.this, MainActivity.class );
        startActivity( mainIntent );
    }

    public void startNewIslamic(View view){

        Intent intent = new Intent( HeightScore.this, IslamicActivity.class );
        startActivity( intent );
    }

    public void startNewHistory(View view){

        Intent intent = new Intent( HeightScore.this, HistoryActivity.class );
        startActivity( intent );

    }

    public void startNewCapital(View view){

     Intent intent = new Intent( HeightScore.this, CapitalActivity.class );
     startActivity( intent );

    }

    public void startNewGeographic(View view){

    Intent intent = new Intent( HeightScore.this, GeographicActivity.class );
    startActivity( intent );

    }

    public void startNewTechnology(View view){

      Intent intent = new Intent( HeightScore.this, TechnologyActivity.class );
      startActivity( intent );

    }

    public void startNewScience(View view){

     Intent intent = new Intent( HeightScore.this, ScienceActivity.class );
     startActivity( intent );

    }

    public void startNewArt(View view){

    Intent intent = new Intent( HeightScore.this, ArtActivity.class );
    startActivity( intent );

    }

    public void startNewSport(View view){

      Intent intent = new Intent( HeightScore.this, SportActivity.class );
      startActivity( intent );

    }

    public void startNewAnimals(View view){
      Intent intent = new Intent( HeightScore.this, AnimalsActivity.class );
      startActivity( intent );
    }

    public void startNewPolitic(View view) {

        Intent intent = new Intent( HeightScore.this, PoliticActivity.class );
        startActivity( intent );
    }

    public void startNowCultural(View view){

        Intent intent = new Intent( HeightScore.this, CulturalActivity.class );
        startActivity( intent );

    }

    public void startNewGeneral(View view){

        Intent intent = new Intent( HeightScore.this, GeneralActivity.class );
        startActivity( intent );

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        saveData();

        mainActivity();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }

    public void goToMainActivity(View view){
        Intent mainIntent = new Intent( HeightScore.this, MainActivity.class );
        startActivity( mainIntent );
    }
}
