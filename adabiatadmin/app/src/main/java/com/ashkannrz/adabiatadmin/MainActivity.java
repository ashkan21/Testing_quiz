package com.ashkannrz.adabiatadmin;

import android.os.Build;
import android.os.CountDownTimer;
import android.os.PatternMatcher;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.util.EncodingUtils;
public class MainActivity extends AppCompatActivity {
    WebView webView;
    String[] truee = { "1", "2", "3", "4"};
    String[] book = { "ادبیات 2", "ادبیات 3", "ادبیات 4"};
    String[] cat = {  "قواعد", "تاریخ ادبیات", "لغات"};
    String s_book,s_cat,s_truee;
String saa,sbb,scc,sdd,title1 ="0";
String bo123ok,bo123ok1 ;
    EditText title,sa,sb,sc,sd;
    ProgressBar pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         title =(EditText)findViewById(R.id.editText2);
         sa =(EditText)findViewById(R.id.editText);
         sb =(EditText)findViewById(R.id.editText3);
         sc =(EditText)findViewById(R.id.editText4);
         sd =(EditText)findViewById(R.id.title);

        bo123ok = "0";
        bo123ok1 = "0";
        pr=(ProgressBar)findViewById(R.id.progressBar);
        pr.setVisibility(View.INVISIBLE);
        /*.....................................................................................*/


        webView = (WebView) findViewById(R.id.webView1);
        webView.setVisibility(View.INVISIBLE);


        Spinner trueee = (Spinner) findViewById(R.id.spinner);
        Spinner book1 = (Spinner) findViewById(R.id.spinner2);
        Spinner cat1 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adaptertrue = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line,truee);
        adaptertrue.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        ArrayAdapter<String> adapterbook = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line,book);
        adapterbook.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        ArrayAdapter<String> adaptercat = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line,cat);
        adaptercat.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);




        book1.setAdapter(adapterbook);

        book1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
// TODO Auto-generated method stub
                s_book = book[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

            }

        });


        trueee.setAdapter(adaptertrue);

        trueee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
// TODO Auto-generated method stub
                s_truee = truee[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

            }

        });


        cat1.setAdapter(adaptercat);

        cat1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
// TODO Auto-generated method stub
                s_cat = cat[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

            }

        });


        Button btn =(Button)findViewById(R.id.button) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                pr.setVisibility(View.VISIBLE);
                switch (s_book)
                {
                    case "ادبیات 2" : bo123ok="2";
                        break;
                    case "ادبیات 3" :bo123ok="3";
                        break;
                    case "ادبیات 4" :bo123ok="4";
                        break;
                    default:bo123ok="0";

                }
                bo123ok1 = "0";
                switch (s_cat)
                {
                    case "قواعد" : bo123ok1="2";
                        break;
                    case "تاریخ ادبیات" :bo123ok1="3";
                        break;
                    case "لغات" :bo123ok1="4";
                        break;
                    default:bo123ok1="0";
                }
                title1 = title.getText().toString();
                saa = sa.getText().toString();
                sbb = sb.getText().toString();
                scc= sc.getText().toString();
                sdd= sd.getText().toString();


                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.getSettings().setUseWideViewPort(true);
                webView.getSettings().setBuiltInZoomControls(true);
                String postData = "title="+ title1 +"&selecta=" + saa+"&selectb=" + sbb+"&selectc=" + scc+"&selectd=" + sdd+"&true=" + s_truee +"&cat=" + bo123ok1+"&book=" + bo123ok;
                webView.postUrl("https://serveradabiatt.000webhostapp.com/getdata/getdata.php", EncodingUtils.getBytes(postData, "utf-8"));
                webView.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onPageFinished(WebView view, String url)
                    {
                        webView.setVisibility(View.VISIBLE);
                        webView.evaluateJavascript(
                                "(function() { return ('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>'); })();",
                                new ValueCallback<String>() {
                                    @Override
                                    public void onReceiveValue(String html) {

                                        pr.setVisibility(View.INVISIBLE);


                                        }
                                });
                     
                    }
                    
                });




            }
        });

    }









    }

