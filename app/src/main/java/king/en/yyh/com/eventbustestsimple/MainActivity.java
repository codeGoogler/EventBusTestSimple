package king.en.yyh.com.eventbustestsimple;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类功能描述：</br>
 * 你可能不了解的ButterKnife8.8.1的新特性
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2017/9/15/015. </br> 修改备注：</br>
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //很早出现的方法--》监听
    @OnClick({R.id.btn01,R.id.btn02,R.id.btn03})
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.btn01:
                startActivity(new Intent(this,MainLoginTestActivity.class));
                break;
            case R.id.btn02:
                startActivity(new Intent(this,MainLoginTestActivity.class));
                break;
            case R.id.btn03:
                startActivity(new Intent(this,MainLoginTestActivity.class));
                break;
        }
    }

    @OnClick(R.id.f1)
    public void f1() {//动态添加Fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        //transaction.add(R.id.fragment_container, fragment1);
        transaction.replace(R.id.fragment_container,fragment1);
        transaction.commit();
    }

    @OnClick( R.id.f2 )
    public void f2(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment2 fragment2 = new Fragment2();
        transaction.replace(R.id.fragment_container,fragment2);
        //  transaction.add(R.id.fragment_container, fragment2);
        transaction.commit();
    }
}
