package king.en.yyh.com.eventbustestsimple;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import king.en.yyh.com.eventbustestsimple.utils.GetToast;


/**
 * 类功能描述：</br>
 * 你可能不了解的ButterKnife8.8.1的新特性
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2017/9/15/015. </br> 修改备注：</br>
 */
public class Fragment1 extends Fragment{
    Unbinder unbinder;
    @BindColor(android.R.color.background_dark)
    @ColorInt
    int whiteColor;

    @BindString(R.string.string_value01)
    String stringResult01;

    @BindView(R.id.iv_f2)
    ImageView iv_f2;

    @BindView(R.id.view_test1)
    View view_test1;

    @BindArray(R.array.city)
    protected String [] mStrings;

    @BindBitmap(R.mipmap.rabot)
    Bitmap rabot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment1, container, false);
        //在非Activity 类（eg：Fragment、ViewHold）中绑定： 这里的this不能替换成getActivity（）。
        //unbinder =  ButterKnife.bind(getActivity(), view); --------->error
        unbinder =  ButterKnife.bind(this, view); // -------->right
        view_test1.setBackgroundColor(whiteColor);

        return view;
    }

    @OnClick({R.id.view_test1,R.id.btn_s01,R.id.btn_s02})
    public void onCLick1(View view){
        switch (view.getId()){
            case R.id.view_test1:
                iv_f2.setImageBitmap(rabot);
                break;
            case R.id.btn_s01:
                GetToast.useString(getActivity(),"按钮1");
                break;
            case R.id.btn_s02:
                GetToast.useString(getActivity(),"按钮2");
                break;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
