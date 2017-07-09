package com.acadgild.contextmenuxml;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    //private Activity mActivity;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mTextView = (TextView) findViewById(R.id.tv);

        // First step to show a custom context menu on text view
        registerForContextMenu(mTextView);

    }

    @Override
    public void onCreateContextMenu(
            ContextMenu menu,
            View v,
            ContextMenu.ContextMenuInfo menuInfo
    ){
        super.onCreateContextMenu(menu, v, menuInfo);

        //This class is used to instantiate menu XML files into Menu objects.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Context Menu");//setting menu title
    }


    @Override
    public boolean onContextItemSelected(MenuItem item){
        // Handle the menu item selection and showing toast
        switch(item.getItemId()){
            case R.id.Action_1:
                Toast.makeText(mContext,"Action 1 Selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Action_2:
                Toast.makeText(mContext,"Action 2 Selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Action_3:
                Toast.makeText(mContext,"Action 3 Selected",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}