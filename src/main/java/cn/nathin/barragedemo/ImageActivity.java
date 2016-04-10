package cn.nathin.barragedemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import cn.nathin.barrage.BarrageCA;
import cn.nathin.barrage.BarrageViewImage;

public class ImageActivity extends Activity implements View.OnTouchListener{
BarrageViewImage barrageViewImage;
float x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        BarrageCA.register("abc");
        barrageViewImage= (BarrageViewImage) findViewById(R.id.barrageViewImage);
        barrageViewImage.setSourceId("sbb");
        barrageViewImage.setOnTouchListener(this);
        new Thread(){
            @Override
            public void run() {
                barrageViewImage.getText();
                barrageViewImage.updataBarrageView();
            }
        }.start();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_UP:
                x=event.getX();
                y=event.getY();
                final EditText editText=new EditText(this);
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("吐槽")
                        .setView(editText)
                        .setPositiveButton("吐", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                barrageViewImage.sendText(editText.getText().toString(),x,y);
                            }
                        })
                        .setNegativeButton("吞",null)
                        .create().show();
                break;
        }
        return false;
    }
}
