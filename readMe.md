## ButterKnife8.8.1的用法


#### 什么是ButterKnife




ButterKnife是目前常用的一种依托Java注解机制实现辅助代码生成的框架；用到了注解处理器。
它是一个专注于Android系统的View注入框架,将Android视图和回调方法绑定到成员变量和方法上；可视化一键生成；可以减少大量的findViewById以及setOnClickListener代码，是注解中相对简单易懂的开源框架 。


一句话概括：依赖注入框架，主要用于注解，减少代码。butterknife表面意思黄油刀


### ButterKnife 优势：
- 1.强大的View绑定和Click事件处理功能，简化代码，提升开发效率
- 2.方便的处理Adapter里的ViewHolder绑定问题
- 3.运行时不会影响APP效率，使用配置方便
- 4.代码清晰，可读性强

### 使用心得：
- 1.Activity ButterKnife.bind(this);必须在setContentView();之后，且父类bind绑定后，子类不需要再bind，Activity不需要unbind
- 2.Fragment ButterKnife.bind(this, mRootView);
- 3.属性布局不能用private or static 修饰，否则会报错
- 4.setContentView()不能通过注解实现。（其他的有些注解框架可以）

## 使用方法
- 导入

    ![导入.png](http://upload-images.jianshu.io/upload_images/4614633-5918f19e9f2ad3ea.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
    ![gradle中需要进行导入](http://upload-images.jianshu.io/upload_images/4614633-f49ada857dab7381.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 一键生成资源id

    ![一键生成资源id.gif](http://upload-images.jianshu.io/upload_images/4614633-98787b5ef33759cf.gif?imageMogr2/auto-orient/strip)

> 英文使用说明地址：http://jakewharton.github.io/butterknife/

> API文档地址：
>http://jakewharton.github.io/butterknife/javadoc/

>GitHub源码地址：
>https://github.com/JakeWharton/butterknife




![很早出现的方法onCLick监听.png](http://upload-images.jianshu.io/upload_images/4614633-fdff7aa1f10be9db.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

测试效果如下

![butterKnife8.8.1Framgment测试](http://upload-images.jianshu.io/upload_images/4614633-46cee0d3a544f90e.gif?imageMogr2/auto-orient/strip)

![butterKnife8.8.1绑定View测试](http://upload-images.jianshu.io/upload_images/4614633-41c66f3c6dae6729.gif?imageMogr2/auto-orient/strip)

### 注意事项

- 1）在Activity 类中绑定 ：ButterKnife.bind(this);

    必须在setContentView();之后绑定；且父类bind绑定后，子类不需要再bind。
- 2）在非Activity 类（eg：Fragment、ViewHold）中绑定：

    ButterKnife.bind(this，view);

    这里的this不能替换成getActivity（）。
- 3）activity中不需要解绑

    在Activity中不需要做解绑操作，在Fragment 中必须在onDestroyView()中做解绑操作。

- 4）ButterKnife的修饰符

    使用ButterKnife修饰的方法和控件，不能用private or static 修饰，否则会报错。
- 5）setContentView()不能通过注解实现。（其他的有些注解框架可以）

- 6）对于mvc设计模式

    使用Activity为根视图绑定任意对象时，如果你使用类似MVC的设计模式你可以在Activity 调用ButterKnife.bind(this, activity)，来绑定Controller。
- 7）子View的相关绑定

    使用ButterKnife.bind(this，view)绑定一个view的子节点字段。如果你在子View的布局里或者自定义view的构造方法里 使用了inflate,你可以立刻调用此方法。或者，从XML inflate来的自定义view类型可以在onFinishInflate回调方法中使用它。

- 8）修饰类型不能是：private 或者 static
    ```
    否则会报错：错误:
    @BindView fields must not be private or static. (com.ButterknifeActivity.button)
    ```
### bind资源
- 绑定颜色
    ```
    @BindColor(android.R.color.background_dark)
    @ColorInt
    int whiteColor;
    ```

- 绑定View
    ```
    @BindView(android.R.id.button3)
    View button3;
    ```
- 绑定多个View
    ```
    @BindViews({R2.id.first_name, R2.id.middle_name, R2.id.last_name})
    List<EditText> nameViews;
    ```
- 绑定String资源数组
    ```
     <string-array name="city">
        <item>北京市</item>
        <item>天津市</item>
        <item>哈尔滨市</item>
        <item>大连市</item>
        <item>香港市</item>
    </string-array>
     @BindArray(R.array.city)
    protected String [] mStrings;
    ```
-  绑定Bitmap 资源
    ```

    ```

#### 事件的bind注解

- @OnClick---->点击事件

- @OnCheckedChanged ---->选中，取消选中
- @OnEditorAction ---->软键盘的功能键
- @OnFocusChange ---->焦点改变
- @OnItemClick item---->条目被点击(
    ```
    注意这里有坑，如果item里面有Button等这些有点击    的控件事件的，需要设置这些控件属性focusable为false)
    ```
- @OnItemLongClick item---->长按(返回真可以拦截onItemClick)
- @OnItemSelected ---->item被选择事件
- @OnLongClick ---->长按事件
- @OnPageChange ---->页面改变事件
- @OnTextChanged ---->EditText里面的文本变化事件
- @OnTouch ---->触摸事件
- @Optional ---->




### 设置多个View重点讲解
绑定多个OnCLick
```
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
```

绑定listView的OnItemClick

```
    @OnItemClick(R.id.lv_List)
    public void OnItemClick(int index){
        GetToast.useString(getActivity(),"this is OnItemClick the index :"+index);
    }
```
绑定listView的OnItemLongClick
```
 @OnItemLongClick(R.id.lv_List)
    public boolean OnItemLongClick(int index){
        GetToast.useString(getActivity(),"this is the OnItemLongClick index :"+index);
        return  true;
    }
```
绑定ChexkBox的OnItemLongClick
```
 @OnCheckedChanged(R.id.cb_cjeck)
    public void OnCheckedChanged(boolean isChecked){
        if(isChecked){
            GetToast.useString(getActivity(),"选中了");
            return ;
        }
        GetToast.useString(getActivity(),"没选中...");
    }

```
单个绑定onClick事件
```
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
```

> 项目地址：
>
> https://github.com/androidstarjack/MyShowHonorSimple

### 更多文章

[ 2017上半年技术文章集合—184篇文章分类汇总](http://blog.csdn.net/androidstarjack/article/details/77923753)

[ NDK项目实战—高仿360手机助手之卸载监听](http://blog.csdn.net/androidstarjack/article/details/77984865)


[高级UI特效仿直播点赞效果—一个优美炫酷的点赞动画](http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=100000969&idx=1&sn=626d821d16346764fdce33e65f372031&chksm=6b4768575c30e14163ae8fb9f0406db0b3295ce47c4bc27b1df7a3abee1fa0bb71ef27b4e959#rd)

[一个实现录音和播放的小案例](http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=100000959&idx=1&sn=a5acb0f44fbadeaa9351df067438922c&chksm=6b4768215c30e1371a3c750f2b826f38b3a263c937272ae208717f73f92ed3e8fd8b6a674686#rd)

#### 相信自己，没有做不到的，只有想不到的

![加入大牛圈](http://img.blog.csdn.net/20170910215455020?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYW5kcm9pZHN0YXJqYWNr/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

 如果你觉得此文对您有所帮助，欢迎入群 QQ交流群 ：644196190
微信公众号：终端研发部

![技术+职场](https://user-gold-cdn.xitu.io/2017/8/1/d354d51a5c58fb8a5ba576f2d9ea7a8e)





