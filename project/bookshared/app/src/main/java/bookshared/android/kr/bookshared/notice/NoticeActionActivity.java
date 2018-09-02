package bookshared.android.kr.bookshared.notice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bookshared.android.kr.bookshared.R;

public class NoticeActionActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListActivity noticeList;
    private List<NoticeDTO> notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        noticeListView = (ListView)findViewById(R.id.NoticeListView);
        notice = new ArrayList<NoticeDTO>();
        notice.add(new NoticeDTO("작성자 : 관리자","공지사항 테스트" , "2017/10/12"));
        notice.add(new NoticeDTO("작성자 : 매니저","공지사항 테스트" , "2017/10/13"));
        notice.add(new NoticeDTO("작성자 : 부관리자","공지사항 테스트" , "2017/10/14"));
        notice.add(new NoticeDTO("작성자 : 관리자","공지사항 테스트" , "2017/10/15"));
        notice.add(new NoticeDTO("작성자 : 매니저","공지사항 테스트" , "2017/10/16"));
        notice.add(new NoticeDTO("작성자 : 관리자","공지사항 테스트" , "2017/10/17"));
        notice.add(new NoticeDTO("작성자 : 매니저","공지사항 테스트" , "2017/10/18"));
        notice.add(new NoticeDTO("작성자 : 부관리자","공지사항 테스트" , "2017/10/19"));
        notice.add(new NoticeDTO("작성자 : 매니저","공지사항 테스트" , "2017/10/20"));
        notice.add(new NoticeDTO("작성자 : 관리자","공지사항 테스트" , "2017/10/21"));
        noticeList = new NoticeListActivity(getApplicationContext() , notice);
        noticeListView.setAdapter(noticeList);
    }
}
