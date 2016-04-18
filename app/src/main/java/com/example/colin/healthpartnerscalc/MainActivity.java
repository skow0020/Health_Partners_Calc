package com.example.colin.healthpartnerscalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    double outbrain;
    double fb;
    double aw;
    double spend;
    double sessions;
    double costPerSession;
    double lastMonth;
    double percentChange;

    TextView outbraintxt;
    TextView fbtxt;
    TextView awtxt;
    TextView spendtxt;
    TextView sessionstxt;
    TextView costPerSessiontxt;
    TextView lastMonthtxt;
    TextView percentChangetxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc(View view)
    {
        switch (view.getId()) {
            case R.id.calculateHIH:
                outbraintxt = (TextView) findViewById(R.id.outbrain1);
                fbtxt = (TextView) findViewById(R.id.fb1);
                awtxt = (TextView) findViewById(R.id.adwords1);
                spendtxt = (TextView) findViewById(R.id.spend1);
                sessionstxt = (TextView) findViewById(R.id.sessions1);
                costPerSessiontxt = (TextView) findViewById(R.id.sessionCost1);
                lastMonthtxt = (TextView) findViewById(R.id.lastMonth1);
                percentChangetxt = (TextView) findViewById(R.id.change1);

                calcStuff();
                break;
            case R.id.calculateHPMed:
                outbraintxt = (TextView) findViewById(R.id.outbrain2);
                fbtxt = (TextView) findViewById(R.id.fb2);
                awtxt = (TextView) findViewById(R.id.adwords2);
                spendtxt = (TextView) findViewById(R.id.spend2);
                sessionstxt = (TextView) findViewById(R.id.sessions2);
                costPerSessiontxt = (TextView) findViewById(R.id.sessionCost2);
                lastMonthtxt = (TextView) findViewById(R.id.lastMonth2);
                percentChangetxt = (TextView) findViewById(R.id.change2);

                calcStuff();
                break;
        }
    }

    public void calcStuff()
    {
        //Calculate the total spending and apply to spend text box
        outbrain = Double.parseDouble(outbraintxt.getText().toString());
        fb = Double.parseDouble(fbtxt.getText().toString());
        aw = Double.parseDouble(awtxt.getText().toString());

        spend = outbrain + fb + aw;
        spendtxt.setText(Double.toString(spend));

        //Calculate the cost per session if # of sessions is given and apply to cost per session textbox
        if (sessionstxt.getText().length() > 0)
        {
            sessions = Double.parseDouble(sessionstxt.getText().toString());
            costPerSession = spend/sessions;

            costPerSessiontxt.setText(String.format( "%.2f", costPerSession));
        }

        if (lastMonthtxt.getText().length() > 0 && costPerSession > 0)
        {
            lastMonth = Double.parseDouble(lastMonthtxt.getText().toString());
            percentChange = 100*(costPerSession - lastMonth)/lastMonth;

            percentChangetxt.setText(String.format( "%.2f", percentChange));
        }
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
