package cn.nathin.barragedemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cn.nathin.barrage.BarrageCA;
import cn.nathin.barrage.BarrageViewVideo;

public class VideoActivity extends Activity implements View.OnClickListener,Runnable{
    BarrageViewVideo barrageViewVideo;
    EditText editText;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        BarrageCA.register("abc");
        barrageViewVideo= (BarrageViewVideo) findViewById(R.id.barrageViewVideo);
        barrageViewVideo.setSourceId("saa");
        findViewById(R.id.button_start).setOnClickListener(this);
        findViewById(R.id.button_send).setOnClickListener(this);
        editText= (EditText) findViewById(R.id.editText);
        readyDialog();
        new Thread(this).start();
    }

    private void readyDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false)
                .setTitle("加载弹幕中");
        alertDialog=builder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start:
                barrageViewVideo.start();
                break;
            case R.id.button_send:
                barrageViewVideo.sendText(editText.getText().toString());
                break;
        }
    }

    @Override
    public void run() {
        barrageViewVideo.getText();
        alertDialog.dismiss();
    }
}
