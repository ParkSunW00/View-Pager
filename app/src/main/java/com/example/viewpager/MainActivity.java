package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼을 통해 특정 프래그먼트로 전환
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(1);
            }
        });

        pager=findViewById(R.id.pager);
        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();
        ThirdFragment thirdFragment = new ThirdFragment();

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        adapter.addItem(firstFragment);
        adapter.addItem(secondFragment);
        adapter.addItem(thirdFragment);

        pager.setAdapter(adapter);
    }
    //페이저 구성을 위해 사용할  Adapter만들기
    class MyPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> items=new ArrayList<Fragment>();
        //생성자
        public MyPagerAdapter(FragmentManager fm) {super(fm);}

        @NonNull
        @Override
        //뷰페이저를 통해 보여줄 프래그먼트 객체를 반환
        public Fragment getItem(int position) {
            return items.get(position);
        }

        ;

        //프래그먼트를 ArrayList에 담기위한 메소드
        public void addItem (Fragment item) { items.add(item); }

        @Override
        //뷰페이저를 통해 보여줄 항목(프래그먼트)의 갯수
        public int getCount() {
            return 3;
        }
    }
}