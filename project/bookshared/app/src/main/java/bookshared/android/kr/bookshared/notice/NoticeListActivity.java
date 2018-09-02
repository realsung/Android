package bookshared.android.kr.bookshared.notice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bookshared.android.kr.bookshared.R;

public class NoticeListActivity extends BaseAdapter {

    private Context context;
    private List<NoticeDTO> noticeList;

    public NoticeListActivity(Context context, List<NoticeDTO> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int position) {
        return noticeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.activity_notice, null);
        TextView noticeText = v.findViewById(R.id.noticeText);
        TextView nameText = v.findViewById(R.id.nameText);
        TextView dateText = v.findViewById(R.id.dateText);

        noticeText.setText(noticeList.get(position).getNotice());
        nameText.setText(noticeList.get(position).getName());
        dateText.setText(noticeList.get(position).getDate());
        v.setTag(noticeList.get(position).getNotice());

        return v;

    }

}