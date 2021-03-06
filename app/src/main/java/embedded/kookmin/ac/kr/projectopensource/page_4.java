package embedded.kookmin.ac.kr.projectopensource;

/**
 * Created by 승수 on 2015-11-22.
 */
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import embedded.kookmin.ac.kr.database.DbOpenHelper;

/**
 * Created by 승수 on 2015-11-22.
 */
public class page_4 extends android.support.v4.app.Fragment { //슬라이드 4번째 페이지

    SQLiteDatabase database;
    DbOpenHelper dbOpenHelper;

    TextView textViewName;

    String tableName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbOpenHelper = new DbOpenHelper(getActivity());
        database = dbOpenHelper.getReadableDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.page, container, false);

        RelativeLayout background = (RelativeLayout)
                linearLayout.findViewById(R.id.background);
        background.setBackground(new ColorDrawable
                (Color.parseColor("#7FFFD4")));

        TextView page_num = (TextView) linearLayout.findViewById
                (R.id.page_num);
        page_num.setText(String.valueOf(4));

        Button bBack = (Button) linearLayout.findViewById(R.id.bt_backMain);
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        ImageButton imageButton = (ImageButton) linearLayout.findViewById(R.id.bt_contest);
        imageButton.setImageResource(R.drawable.design); //ImageButton의 이미지 설정
        imageButton.setScaleType(ImageButton.ScaleType.CENTER_CROP);//ImageButton의 이미지 크기 설정
        imageButton.setBackgroundColor(0x00000000);//ImageButton의 뒷배경 설정
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListActivity.class);
                intent.putExtra("contestTable", tableName);
                startActivity(intent);
            }
        });

        textViewName = (TextView) linearLayout.findViewById(R.id.DbData);

        String sql = "SELECT * from contestList";

        try {
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor.moveToPosition(3)) {
                tableName = cursor.getString(1);
                textViewName.append("\n" + tableName);
            }
        } catch (Exception e) {
            Log.d("page1 Fragment", "error in setAddress : " + e.toString());
        }

        return linearLayout;
    }
}
