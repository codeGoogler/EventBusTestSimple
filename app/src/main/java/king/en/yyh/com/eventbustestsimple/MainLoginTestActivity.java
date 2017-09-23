package king.en.yyh.com.eventbustestsimple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import king.en.yyh.com.eventbustestsimple.utils.GetToast;


/**
 * 类功能描述：</br>
 * 你可能不了解的ButterKnife8.8.1的新特性
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public class MainLoginTestActivity extends AppCompatActivity {
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_account)
    EditText et_account;
    @BindView(R.id.btn_cancle)
    Button btn_cancle;
    @BindView(R.id.btn_ok)
    Button btn_ok;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_cancle,R.id.btn_ok})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_cancle:
                String name = et_account .getText().toString();
                String pass = et_password .getText().toString();
                GetToast.useString(MainLoginTestActivity.this,name+""+pass);
                break;
            case R.id.btn_ok:

                break;
        }
    }

}
