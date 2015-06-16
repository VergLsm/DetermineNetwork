package com.example.vision.determinenetwork;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private Button btnCheck;
    private NetworkInfo info;
    private TextView tvNetSta;
    private ConnectivityManager connectMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectMgr = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        tvNetSta = (TextView) findViewById(R.id.tvNetSta);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info = connectMgr.getActiveNetworkInfo();
                if (null == info) {
                    tvNetSta.setText(String.valueOf("No Network."));
                    return;
                }
                if (info.getType() == ConnectivityManager.TYPE_WIFI)
                    tvNetSta.setText(String.valueOf("WIFI"));
                else if(info.getType() == ConnectivityManager.TYPE_MOBILE)
                    tvNetSta.setText(String.valueOf("MOBILE"));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
