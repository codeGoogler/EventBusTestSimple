package king.en.yyh.com.eventbustestsimple;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnLongClick;
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
public class Fragment2 extends Fragment{
    @BindView(R.id.lv_List)
    ListView lv_List;
    private String[] name = { "剑萧舞蝶", "张三", "hello", "诗情画意" };

    private String[] desc = { "魔域玩家", "百家执行", "高级的富一代", "妹子请过来..一个善于跑妹子的。。" };
    private Unbinder unbinder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment2, container, false);
        unbinder =  ButterKnife.bind(this, view);
        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("name", name[i]);
            listem.put("desc", desc[i]);
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(getActivity(), listems,
                R.layout.list_item, new String[] { "name",   "desc" },
                new int[] {R.id.name, R.id.desc});
        lv_List.setAdapter(simplead);
        return view;
    }

    @OnItemClick(R.id.lv_List)
    public void OnItemClick(int index){
        GetToast.useString(getActivity(),"this is OnItemClick the index :"+index);
    }
    @OnItemLongClick(R.id.lv_List)
    public boolean OnItemLongClick(int index){
        GetToast.useString(getActivity(),"this is the OnItemLongClick index :"+index);
        return  true;
    }

    @OnClick({R.id.btn0221,R.id.btn0222})
    public void onClickk(View v){
        switch (v.getId()){
            case R.id.btn0221:
                GetToast.useString(getActivity(),"按钮1");
                break;
            case R.id.btn0222:
                GetToast.useString(getActivity(),"按钮2");
                break;
        }
    }
    @OnCheckedChanged(R.id.cb_cjeck)
    public void OnCheckedChanged(boolean isChecked){
        if(isChecked){
            GetToast.useString(getActivity(),"选中了");
            return ;
        }
        GetToast.useString(getActivity(),"没选中...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
