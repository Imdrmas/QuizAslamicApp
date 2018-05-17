package com.drmas.issam.quizeaslamic;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class GeneralActivity extends AppCompatActivity {

    private Toolbar generalToolbar;
    public Button textCounterDownGeneral;

    private GeneralQuestions generalQuestions = new GeneralQuestions();

    private TextView mQuestionViewGeneral;
    private Button mButtonChoice1General, mButtonChoice2General;
    private Button mButtonChoice3General, mButtonChoice4General;

    private TextView textCorrectCountGeneral, textWrongCountGeneral;
    private TextView countQuestionDownGeneral;
    /// ending of main page

    private Button btnTry, btnCancel;
    private TextView textCorrectCountResult, textWrongCountResult;
    /// Start Dialog Page
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    private MediaPlayer mp, mpc, mpCount;
    private CountDownTimer countDownTimer;
    private TextView mScoreView, textResultUser;

    private int correctCountCounter = 0;
    private int wrongCountCounter = 0;
    private int questionsDown = 100;

    private int heightScore;

    public RatingBar ratingBar;
    private Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_general );

        generalToolbar = findViewById( R.id.generalToolbar );
        setSupportActionBar( generalToolbar );
        setTitle( null );

        myDialog = new Dialog( this );

        textCorrectCountGeneral = (TextView) findViewById( R.id.textCorrectCountGeneral);
        textWrongCountGeneral = (TextView) findViewById( R.id.textWrongCountGeneral );
        countQuestionDownGeneral = (TextView) findViewById( R.id.countQuestionDownGeneral);

        textCounterDownGeneral = (Button) findViewById( R.id.counterDownGeneral );
        countDownTimer = new CountDownTimer(16000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textCounterDownGeneral.setText(""+ millisUntilFinished/1000 );
            }

            @Override
            public void onFinish() {
                textCounterDownGeneral.setText( "done" );

                countDownTimer.cancel();
                mpCount.pause();
                ShowPopup();

            }
        };

        mp = MediaPlayer.create( this, R.raw.correct );
        mpc = MediaPlayer.create( this, R.raw.incorrect );
        mpCount = MediaPlayer.create( this, R.raw.timercount );

        mQuestionViewGeneral = (TextView) findViewById( R.id.textQuestionGeneral );

        mButtonChoice1General = (Button) findViewById( R.id.ButtonChoice1General );
        mButtonChoice2General = (Button) findViewById( R.id.ButtonChoice2General );
        mButtonChoice3General = (Button) findViewById( R.id.ButtonChoice3General );
        mButtonChoice4General = (Button) findViewById( R.id.ButtonChoice4General );

        updateQuestions();

    } /// Main

    private void ShowPopup() {

        myDialog.setContentView(R.layout.custon_resulat);
        myDialog.setCancelable( false );

        textResultUser = (TextView) myDialog.findViewById( R.id.textResultUser );
        textResultUser.setText( "No answer" );

        mScoreView = (TextView) myDialog.findViewById( R.id.textScore );
        mScoreView.setText( "Score "+ mScore+ "/" +generalQuestions.getLength()+ " ");

        textCorrectCountResult = (TextView) myDialog.findViewById( R.id.textCorrectCountResult );
        textWrongCountResult = (TextView) myDialog.findViewById( R.id.textWrongCountResult );

        textCorrectCountResult.setText( String.valueOf( correctCountCounter+" Correct" ));
        textWrongCountResult.setText( String.valueOf( wrongCountCounter+" Wrong" ));

        ratingBar = (RatingBar) myDialog.findViewById( R.id.ratingBarResult );
        Button submitRating = (Button) myDialog.findViewById( R.id.submitRating );
        submitRating.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(), String.valueOf( ratingBar.getRating()), Toast.LENGTH_LONG ).show();
            }
        });

        btnTry = (Button) myDialog.findViewById( R.id.custom_result_try );
        btnTry.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.dismiss();
                countDownTimer.start();
                mpCount.start();

            }
        });

        btnCancel = (Button) myDialog.findViewById(R.id.custom_result_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( GeneralActivity.this, HeightScore.class );
                intent.putExtra( "scoreGeneral", mScore );
                startActivity( intent );
            }
        });

        if (mQuestionNumber == 100){

            btnTry = (Button) myDialog.findViewById( R.id.custom_result_try );
            btnTry.setText( " Try again " );
            btnTry.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish();startActivity( getIntent());

                }
            });

            btnCancel = (Button) myDialog.findViewById(R.id.custom_result_cancel);
            btnCancel.setBackgroundResource( R.drawable.not_stared_score_normal );
            btnCancel.setText( " Height score " );
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent( GeneralActivity.this, HeightScore.class );
                    intent.putExtra( "scoreGeneral", mScore );
                    startActivity( intent );
                }
            });

        }

        SharedPreferences sharedPreferences = getPreferences( MODE_PRIVATE );
        heightScore = sharedPreferences.getInt( "heightScore", 0);

        if (heightScore >= mScore){

            if (heightScore == 0){

                textResultUser.setText( "No answer" );

            } else {

                textResultUser.setText( "Height score: "+heightScore );
                btnCancel = (Button) myDialog.findViewById(R.id.custom_result_cancel);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent( GeneralActivity.this, HeightScore.class );
                        intent.putExtra( "scoreGeneral", heightScore );
                        startActivity( intent );

                    }
                });
            }
        }
        else {

            textResultUser.setText( "New Score: "+mScore );
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt( "heightScore", mScore );
            editor.commit();

            if (mScore >= 0 && mScore == 100){

                myDialog.setContentView(R.layout.custom_new_finish);

                TextView txtQuestionFinish = (TextView) myDialog.findViewById( R.id.txtQuestionFinish );
                TextView txtScoreFinish = (TextView) myDialog.findViewById( R.id.txtScoreFinish );
                TextView txtFinish = (TextView) myDialog.findViewById( R.id.txtFinish );

                txtQuestionFinish.setText( " Questions " );
                txtScoreFinish.setText( " Finished " );

                txtFinish.setText( " You did a great job !" );

                Button btnAnswer = (Button) myDialog.findViewById( R.id.btnNewFinishAnswer) ;
                btnAnswer.setText( "Show answer" );
                btnAnswer.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        showAnswer();
                    }
                } );

                Button btnFinishScore = (Button) myDialog.findViewById( R.id.btnNewFinishScore);
                btnFinishScore.setText( "Height score" );
                btnFinishScore.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent( GeneralActivity.this, HeightScore.class );
                        intent.putExtra( "scoreGeneral", mScore );
                        startActivity( intent );
                    }
                });
            }

        }
        if (heightScore == 100){

            myDialog.setContentView(R.layout.custom_finished);

            TextView txtQuestionFinish = (TextView) myDialog.findViewById( R.id.txtQuestionFinish );
            TextView txtScoreFinish = (TextView) myDialog.findViewById( R.id.txtScoreFinish );
            TextView txtFinish = (TextView) myDialog.findViewById( R.id.txtFinish );

            txtQuestionFinish.setText( " Questions " );
            txtScoreFinish.setText( " Finished " );

            txtFinish.setText( " You did a great job !" );

            Button btnAnswer = (Button) myDialog.findViewById( R.id.btnFinishAnswer) ;
            btnAnswer.setText( "Answer" );
            btnAnswer.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showAnswer();
                }
            } );

            Button btnFinishScore = (Button) myDialog.findViewById( R.id.btnFinishScore );
            btnFinishScore.setText( "Score" );
            btnFinishScore.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent( GeneralActivity.this, HeightScore.class );
                    intent.putExtra( "scoreGeneral", 100 );
                    startActivity( intent );
                }
            });

            Button btnFinishCancel = (Button) myDialog.findViewById( R.id.btnFinishCancel );
            btnFinishCancel.setText( "Home" );
            btnFinishCancel.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity();
                }
            });
        }

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable( Color.TRANSPARENT));
        myDialog.show();
    }

    public void correctCount(){

        correctCountCounter++;
        textCorrectCountGeneral.setText(String.valueOf( correctCountCounter ));

    }

    public void wrongCount(){

        wrongCountCounter++;
        textWrongCountGeneral.setText(String.valueOf( wrongCountCounter ));

    }

    public void countQuestionDown(){
        questionsDown--;
        countQuestionDownGeneral.setText( String.valueOf( questionsDown ));
    }

    public void playSongCorrect(View view){
        mp.start();
    }

    public void playSongIncorrect(View view){
        mpc.start();
    }

    private void playSoundCounter(View view){
        mpCount.start();
    }

    private void updateQuestions(){


        // Check if we are not outside array bounds for questions
        if (mQuestionNumber<generalQuestions.getLength()){

            mQuestionViewGeneral.setText( generalQuestions.getQuestions( mQuestionNumber ));

            mButtonChoice1General.setText( generalQuestions.getChoice( mQuestionNumber, 1));
            mButtonChoice2General.setText( generalQuestions.getChoice( mQuestionNumber, 2));
            mButtonChoice3General.setText( generalQuestions.getChoice( mQuestionNumber, 3));
            mButtonChoice4General.setText( generalQuestions.getChoice( mQuestionNumber, 4));

            mAnswer = generalQuestions.getCorrectAnswer( mQuestionNumber );
            mQuestionNumber++;

        }
        else {

            mpCount.stop();
            toastLastQuestion();
            countDownTimer.onFinish();

        }
    }

    public void onClickBtnGeneral(View view){

        // All logic for all answers buttons in one method
        Button answer = (Button) view;

        if (answer.getText() == mAnswer){
            mScore = mScore + 1;

            playSongCorrect(view);

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate( R.layout.toast_correct, (ViewGroup) findViewById( R.id.toast_correct ));
            final Toast toast = new Toast( getApplicationContext() );
            toast.setGravity( Gravity.BOTTOM, 10, 10);
            toast.setDuration( toast.LENGTH_SHORT );
            toast.setView( layout );
            toast.show();
            new CountDownTimer(400, 100)
            {
                public void onTick(long millisUntilFinished) {toast.show();}
                public void onFinish() {toast.cancel();}
            }.start();

            correctCount();
            countQuestionDown();

            countDownTimer.start();
            mpCount.setLooping( true );

        }
        else {
            playSongIncorrect(view);

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate( R.layout.toas_incorrect, (ViewGroup) findViewById( R.id.toast_incorrect));
            final Toast toast = new Toast( getApplicationContext() );
            toast.setGravity( Gravity.BOTTOM, 10, 10);
            toast.setDuration( Toast.LENGTH_SHORT);
            toast.setView( layout );
            toast.show();
            new CountDownTimer(400, 100)
            {
                public void onTick(long millisUntilFinished) {toast.show();}
                public void onFinish() {toast.cancel();}
            }.start();

            wrongCount();
            countQuestionDown();

            countDownTimer.start();
            mpCount.setLooping( true );

        }

        updateQuestions();
    }

    public void goToBack(){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.custom_dialog, null );

        TextView titleTextDialog = (TextView) layout.findViewById( R.id.titleTextDialog );
        titleTextDialog.setText( "Are you sure want to go back");
        titleTextDialog.setTextSize( 18 );

        final AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setView( layout);
        builder.setCancelable( false);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnStart = (Button) layout.findViewById( R.id.custom_dialog_btn_start );
        btnStart.setText( "Try" );
        btnStart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                countDownTimer.start();
                mpCount.start();

            }
        });

        Button btnConcel = (Button) layout.findViewById( R.id.btnCancel );
        btnConcel.setText( "Back" );
        btnConcel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity();
                finish();
            }
        });

    }

    public void toastLastQuestion(){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_last_question,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        ImageView image = (ImageView) layout.findViewById(R.id.image_toast);
        image.setImageResource(R.mipmap.icon_app);
        TextView text = (TextView) layout.findViewById(R.id.text_toast);
        text.setText(" هذا كان اخر سؤال ! ");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity( Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void mainActivity(){
        Intent intentMain = new Intent(GeneralActivity.this, MainActivity.class);
        startActivity( intentMain );
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.custom_dialog, null );

        TextView titleTextDialog = (TextView) layout.findViewById( R.id.titleTextDialog );
        titleTextDialog.setText( "أسئلة عامة");

        final AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setView( layout);
        builder.setCancelable( false);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnStart = (Button) layout.findViewById( R.id.custom_dialog_btn_start );
        btnStart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

                countDownTimer.start();
                mpCount.start();

            }
        });

        Button btnCancel = (Button) layout.findViewById( R.id.btnCancel );
        btnCancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity();
                finish();
            }
        });


    }

    private void showAnswer() {


        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int choice) {
                switch (choice) {
                    case DialogInterface.BUTTON_NEUTRAL:
                        break;
                    case DialogInterface.BUTTON_POSITIVE:
                        myDialog.dismiss();

                        String txtShare = " تحدى نفسك ";
                        String shareLink = "https://play.google.com/store/apps/details?id=com.drmas.issam.quizeaslamic";

                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");

                        share.putExtra(Intent.EXTRA_TEXT,txtShare + "\n" + shareLink);
                        startActivity(share);

                        break;
                }
            }
        };

        String general = "general";

        WebView webView = new WebView(this );
        webView.loadUrl("file:///android_asset/"+general+".html");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(webView)
                .setNeutralButton("OK", dialogClickListener)
                .setPositiveButton( "Share", dialogClickListener )
                .show();

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        mpCount.stop();
        countDownTimer.cancel();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mpCount.stop();
        countDownTimer.cancel();
        finish();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        //replaces the default 'Back' button action
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            mpCount.stop();
            countDownTimer.cancel();
            goToBack();
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
