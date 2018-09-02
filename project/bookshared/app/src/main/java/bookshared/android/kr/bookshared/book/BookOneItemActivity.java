package bookshared.android.kr.bookshared.book;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import bookshared.android.kr.bookshared.R;

public class BookOneItemActivity extends AppCompatActivity {
    TextView textView, textView2, textView4;
    WebView webView, webView2;
    ImageView imageView;

    BookDTO bookDTO = new BookDTO();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_one_item);

        progressDialog = new ProgressDialog(BookOneItemActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        webView = (WebView) findViewById(R.id.webView);
        webView2 = (WebView) findViewById(R.id.webView2);
        textView4 = (TextView)findViewById(R.id.textView4);

        imageView = (ImageView)findViewById(R.id.imageView);

        Intent intent = new Intent(getIntent());
        bookDTO = (BookDTO)intent.getSerializableExtra("item");

        textView.setText(bookDTO.getTitle());
        Glide.with(this).load(bookDTO.getCover()).override(150, 200).skipMemoryCache(true).into(imageView);

        textView2.setText(bookDTO.getAuthor());

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.loadData(bookDTO.getDescription(), "text/html; charset=UTF-8", null);
        textView4.setText(bookDTO.getPrice());

        webView2.setWebViewClient(new WebViewClient());
        webView2.getSettings().setDefaultTextEncodingName("UTF-8");
        webView2.loadData(bookDTO.getLink(), "text/html; charset=UTF-8", null);


        progressDialog.dismiss();

    }
}
