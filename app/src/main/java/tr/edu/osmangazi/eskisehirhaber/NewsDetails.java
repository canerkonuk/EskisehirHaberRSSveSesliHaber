package tr.edu.osmangazi.eskisehirhaber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import tr.edu.osmangazi.eskisehirhaber.R;

public class NewsDetails extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        webView= (WebView) findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        Bundle bundle=getIntent().getExtras();
        webView.loadUrl(bundle.getString("Link"));
    }
}
