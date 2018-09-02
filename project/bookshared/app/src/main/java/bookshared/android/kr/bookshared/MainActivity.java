package bookshared.android.kr.bookshared;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import bookshared.android.kr.bookshared.book.BookDTO;
import bookshared.android.kr.bookshared.book.BookOneItemActivity;
import bookshared.android.kr.bookshared.chat.ChatStartActivity;
import bookshared.android.kr.bookshared.notice.NoticeActionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button NoticeButton;
    Button RegisterButton;
    Button LoginButton;
    Button ProfileButton;
    //Button ChatButton;
    Button ChatButton;
    //개발자가 추천하는 책들
    TextView bookImpression, bookImpression2, bookImpression3, bookImpression4, bookImpression5;

    ImageView imageView, imageView2, imageView3, imageView4, imageView5;
    BookDTO bookDTO = new BookDTO();
    ArrayList<BookDTO> bookList = new ArrayList<>();

    String key = "ttbroropoly1227002";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RegisterButton = (Button)findViewById(R.id.RegisterButton);
        RegisterButton.setOnClickListener(this);

        LoginButton = (Button)findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(this);

        ProfileButton = (Button)findViewById(R.id.ProfileButton);
        ProfileButton.setOnClickListener(this);

        NoticeButton = (Button)findViewById(R.id.NoticeButton);
        NoticeButton.setOnClickListener(this);

        ChatButton = (Button)findViewById(R.id.ChatButton);
        ChatButton.setOnClickListener(this);

        bookImpression = (TextView)findViewById(R.id.bookImpression);
        bookImpression.setOnClickListener(this);

        bookImpression2 = (TextView)findViewById(R.id.bookImpression2);
        bookImpression2.setOnClickListener(this);

        bookImpression3 = (TextView)findViewById(R.id.bookImpression3);
        bookImpression3.setOnClickListener(this);

        bookImpression4 = (TextView)findViewById(R.id.bookImpression4);
        bookImpression4.setOnClickListener(this);

        bookImpression5 = (TextView)findViewById(R.id.bookImpression5);
        bookImpression5.setOnClickListener(this);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        imageView5 = (ImageView)findViewById(R.id.imageView5);

        new JsonLoadingTask().execute();

    }

    @Override
    public void onClick(View view) {

        if(view == NoticeButton){
            startActivity(new Intent(this, NoticeActionActivity.class));
        }

        if(view ==  RegisterButton){
            startActivity(new Intent(this , RegisterActivity.class));
        }

        if(view == LoginButton){
            startActivity(new Intent(this , LoginActivity.class));
        }

        if(view == ProfileButton){
            startActivity(new Intent(this , LoginActivity.class));
        }
        if(view == ChatButton){
            startActivity(new Intent(this, ChatStartActivity.class));
        }
        //수의 모험 책
        if(view == bookImpression){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aladin.co.kr/shop/wproduct.aspx?ItemId=50037227")));
        }
        //신경 끄기의 기술 책
        if(view == bookImpression2){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aladin.co.kr/shop/wproduct.aspx?ItemId=120057939")));
        }
        //블랙 코미디 책
        if(view == bookImpression3){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aladin.co.kr/shop/wproduct.aspx?ItemId=119979686")));
        }
        //악의 책
        if(view == bookImpression4){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aladin.co.kr/shop/wproduct.aspx?ItemId=2367160")));
        }
        //달콤한 노래 책
        if(view == bookImpression5){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aladin.co.kr/shop/wproduct.aspx?ItemId=122260182")));
        }

    }

   public ArrayList<BookDTO> getJson(){

        // 내부적으로 문자열 편집이 가능한 StringBuffer 생성자
        StringBuffer sb = new StringBuffer();

        //알라딘 API 요청 URL
        String queryUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=" +key
                +"&QueryType=Bestseller&MaxResults=6&start=1&" +
                "SearchTarget=Book&output=js&Version=20131101";


        try {
            String line = getStringFromUrl(queryUrl);
            Log.d("test...", line);

            // 원격에서 읽어온 데이터로 JSON 객체 생성
            JSONObject object = new JSONObject(line);
            // "item" 배열로 구성 되어있으므로 JSON 배열생성
            JSONArray Array = object.getJSONArray("item");

            for (int i = 0; i < Array.length(); i++) {
                //배열안에 내부 JSON 이므로 JSON 내부 객체 생성
                JSONObject insideObject = Array.getJSONObject(i);
                BookDTO bookDTO = new BookDTO();

                if(insideObject.has("cover")) {
                    bookDTO.setCover(insideObject.getString("cover"));
                }else{
                    bookDTO.setCover("내용 무");
                }
                if(insideObject.has("title")) {
                    bookDTO.setTitle(insideObject.getString("title"));
                }else{
                    bookDTO.setTitle("내용 무");
                }
                if(insideObject.has("description")) {
                    bookDTO.setDescription(insideObject.getString("description"));
                }else{
                    bookDTO.setDescription("내용 무");
                }
                if(insideObject.has("author")) {
                    bookDTO.setAuthor(insideObject.getString("author"));
                }else{
                    bookDTO.setAuthor("내용 무");
                }
                if(insideObject.has("priceStandard")) {
                    bookDTO.setPrice(insideObject.getString("priceStandard"));
                }else{
                    bookDTO.setPrice("내용 무");
                }
                if(insideObject.has("link")) {
                    bookDTO.setLink(insideObject.getString("link"));
                }else{
                    bookDTO.setPrice("내용 무");
                }

                bookList.add(bookDTO);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }


    public String getStringFromUrl(String url) throws UnsupportedEncodingException {
        // getStringFromUrl : 주어진 URL 페이지를 문자열 String타입으로 얻는다.

        // 입력스트림을 "UTF-8" 를 사용해서 읽은 후, 라인 단위로 데이터를 읽을 수 있는 BufferedReader 를 생성한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(getInputStreamFromUrl(url),"UTF-8"));

        // 읽은 데이터를 저장한 StringBuffer 를 생성한다.
        StringBuffer sb = new StringBuffer();

        try{
            // 라인 단위로 읽은 데이터를 임시 저장한 문자열 변수 line
            String line = null;

            // 라인 단위로 데이터를 읽어서 StringBuffer 에 저장한다.
            while ((line = br.readLine()) != null){
                sb.append(line);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static InputStream getInputStreamFromUrl(String url){
        // getInputStreamFromUrl : 주어진 URL 에 대한 입력 스트림(InputStream)을 얻는다.

        InputStream contentStream = null;

        try{
            URL urlObj = new URL(url);
            // URL을 연결한 객체를 생성
            HttpURLConnection conn = (HttpURLConnection)urlObj.openConnection();
            // Post방식x get방식 통신
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                //input스트림 개방
                contentStream = conn.getInputStream();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return contentStream;
    }

    // AsyncTask 를 이용 UI 처리 및 Background 작업 등을 하나의 클래스에서 작업 할 수 있도록 지원해준다.
    private class JsonLoadingTask extends AsyncTask<ArrayList<BookDTO>, Void, ArrayList<BookDTO>> {
        // doInBackground : 백그라운드 작업을 진행한다.

        @Override
        protected ArrayList<BookDTO> doInBackground(ArrayList<BookDTO>... bookDTOs) {
            return getJson();
        }

        @Override
        protected void onPostExecute(final ArrayList<BookDTO> arrayDTO) {

            setFirstimage(arrayDTO.get(0).getCover());
            setFirstimage2(arrayDTO.get(1).getCover());
            setFirstimage3(arrayDTO.get(2).getCover());
            setFirstimage4(arrayDTO.get(3).getCover());
            setFirstimage5(arrayDTO.get(4).getCover());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, BookOneItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item",arrayDTO.get(0));

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, BookOneItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item",arrayDTO.get(1));

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, BookOneItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item",arrayDTO.get(2));

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            imageView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, BookOneItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item",arrayDTO.get(3));

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            imageView5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, BookOneItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item",arrayDTO.get(4));

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }

    }
    public void setFirstimage(final String firstimage){
        Glide.with(this).load(firstimage).override(150, 200).skipMemoryCache(true).into(imageView);

    }
    public void setFirstimage2(final String firstimage2){

        Glide.with(this).load(firstimage2).override(150, 200).skipMemoryCache(true).into(imageView2);

    }
    public void setFirstimage3(final String firstimage3){

        Glide.with(this).load(firstimage3).override(150, 200).skipMemoryCache(true).into(imageView3);

    }
    public void setFirstimage4(final String firstimage4){

        Glide.with(this).load(firstimage4).override(150, 200).skipMemoryCache(true).into(imageView4);

    }
    public void setFirstimage5(final String firstimage5){

        Glide.with(this).load(firstimage5).override(150, 200).skipMemoryCache(true).into(imageView5);

    }

}