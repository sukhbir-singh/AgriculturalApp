package akssmk.com.agriculturalapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import akssmk.com.agriculturalapp.R;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String link=getIntent().getStringExtra("link");

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        Toast.makeText(WebActivity.this, "Please Wait...", Toast.LENGTH_SHORT).show();

        if(link==null){
            webView.loadUrl("http://www.google.com");
        }else{
            webView.loadUrl(link);
        }
    }

}
