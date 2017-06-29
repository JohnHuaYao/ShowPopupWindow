package com.yao.john.showpopupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    View view;
    PopupWindow pop;
    Button btnShowAsDrawDown;
    Button btnShowAsDrawDown1;
    Button btnShowAtLocation;
    @Override
    public void onClick(View v) {
     switch (v.getId()) {
         case R.id.btnShowAsDrawDown:
            if(pop.isShowing()){
               pop.dismiss();
            }else{
            pop.showAsDropDown(v);
            }
             break;
         case R.id.btnShowAsDrawDown1:
             if (pop.isShowing()) {
                 pop.dismiss();
             } else {
                 pop.showAsDropDown(v, 0, -160);
             }
             break;

         default:
             if(pop.isShowing())
             {
                 pop.dismiss();
             }else {
             pop.showAtLocation(findViewById(R.id.main), Gravity.CENTER_HORIZONTAL,0,0);
             }
             break;
 }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowAsDrawDown = (Button) findViewById(R.id.btnShowAsDrawDown);
        btnShowAsDrawDown.setOnClickListener(this);
        btnShowAsDrawDown1 = (Button) findViewById(R.id.btnShowAsDrawDown1);
        btnShowAsDrawDown1.setOnClickListener(this);
        btnShowAtLocation = (Button) findViewById(R.id.btnShowAt);
        btnShowAtLocation.setOnClickListener(this);
        initPopupWindow();
    }
    private  void initPopupWindow()
    {
        view = this.getLayoutInflater().inflate(R.layout.activity_main, null);
        pop = new PopupWindow(view, ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setOutsideTouchable(true);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pop.dismiss();
            }
        });
    }
}
