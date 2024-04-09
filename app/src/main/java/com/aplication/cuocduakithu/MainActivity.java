package com.aplication.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar sbOne, sbTwo, sbThree;
    ImageButton btnPlay;

    int soDiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        txtDiem.setText(soDiem + "");

        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                if(sbOne.getProgress() >= sbOne.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"ONE WIN",Toast.LENGTH_SHORT).show();
                    if(cbOne.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đã chiến thắng, Bạn được cộng 10 điểm",Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this,"Bạn đã thua cuộc, Bạn bị trừ 5 điểm",Toast.LENGTH_SHORT).show();
                    }   txtDiem.setText(soDiem+"");
                }
                if(sbTwo.getProgress() >= sbTwo.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"TWO WIN",Toast.LENGTH_SHORT).show();
                    if(cbTwo.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đã chiến thắng, Bạn được cộng 10 điểm",Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this,"Bạn đã thua cuộc, Bạn bị trừ 5 điểm",Toast.LENGTH_SHORT).show();
                    }   txtDiem.setText(soDiem+"");
                }
                if(sbThree.getProgress() >= sbThree.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"THREE WIN",Toast.LENGTH_SHORT).show();
                    if(cbThree.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đã chiến thắng, Bạn được cộng 10 điểm",Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this,"Bạn đã thua cuộc, Bạn bị trừ 5 điểm",Toast.LENGTH_SHORT).show();
                    }   txtDiem.setText(soDiem+"");
                }

                sbOne.setProgress(sbOne.getProgress() + one);
                sbTwo.setProgress(sbTwo.getProgress() + two);
                sbThree.setProgress(sbThree.getProgress() + three);
            }

            @Override
            public void onFinish() {

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbOne.isChecked()||cbTwo.isChecked()||cbThree.isChecked()){
                    sbOne.setProgress(0);
                    sbTwo.setProgress(0);
                    sbThree.setProgress(0);
                    btnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                } else {
                    Toast.makeText(MainActivity.this,"Vui lòng đặt cược trước khi chơi!!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });
    }
    private void AnhXa(){
        txtDiem = findViewById(R.id.textviewDiemSo);
        cbOne = findViewById(R.id.checkboxOne);
        cbTwo = findViewById(R.id.checkboxTwo);
        cbThree = findViewById(R.id.checkboxThree);
        sbOne = findViewById(R.id.seekbarOne);
        sbTwo = findViewById(R.id.seekbarTwo);
        sbThree = findViewById(R.id.seekbarThree);
        btnPlay = findViewById(R.id.buttonPlay);
    }
}