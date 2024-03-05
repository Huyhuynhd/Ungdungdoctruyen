package com.example.ungdungdoctruyen;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView,listViewNew, listViewThongTin;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AnhXa();
        ActionViewFlipper();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Phương thức cho chạy quảng cáo với ViewFlipper
    private void ActionViewFlipper(){
        //mảng chứa tấm ảnh cho quảng cáo
        ArrayList<String> mangquangcao = new ArrayList<>();
        //Add ảnh vào mảng
        mangquangcao.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-ke-cho-be-nghe.jpg?w=828&q=75");
        mangquangcao.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-y-nghia-ban-ke-cho-be-nghe-moi-dem-4-e1511109098651.jpg");
        mangquangcao.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-y-nghia-ban-ke-cho-be-nghe-moi-dem-1.jpg");
        mangquangcao.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/12/ke-chuyen-be-nghe-deo-chuong-cho-meo.jpg");

        //thực hiện vòng lặp for gán ảnh vào imageView, rồi từ imgView lên app
        for(int i=0; i < mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            //Sử dụng hàm thư viện Picasso
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            //Phuơng thức chỉnh tấm hình vừa khung quảng cáo
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //Thêm ảnh từ imageView vào ViewFlipper
            viewFlipper.addView(imageView);
        }
        //Thiết lập tự động chạy cho viewFlipper chạy trong 4 giây
        viewFlipper.setFlipInterval(4000);
        //run auto ViewFlipper
        viewFlipper.setAutoStart(true);

        //Gọi animation cho vào và ra
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);

        //Gọi animation vào ViewFlipper
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setInAnimation(animation_slide_out);

        //run......
    }

    //Phương thức ánh xạ
    private void AnhXa(){
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewFlipper);
        listViewNew = findViewById(R.id.listViewNew);
        listView = findViewById(R.id.listviewmanhinhchinh);
        listViewThongTin = findViewById(R.id.listViewThongTin);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerlayout);
    }
}