# 科智AR Android开发规范（1.0）

#### 为了更好的协作，我参照一些文章书籍，制定了一个简单的开发规范，可能执行起来略有麻烦，不符合大家平时的编码习惯，但为了以后的开发和长久的维护，还请大家尽量按统一的此开发规范去执行。如果有建议，还请及时和和大家讨论或向我提出，多谢！

## 1.版本规范
- 最低支持版本（minSdkVersion）： 14 （4.0）
- 目标支持版本（targetSdkVersion）： 25 （7.1）
- 编译版本（compileSdkVersion）：25 （7.1）

## 2. 包名结构
- activity：所有Activity放在此文件夹下
- adapter：较复杂，代码较长以及其他需要分离的适配器可放在此文件夹下
- base：BaseActivity，BaseFragmetn放在这里，为易于管理，使结构清晰，所有Activity，所有Fragment需分别继承这两个类
- behavior：存放复杂的behavior文件
- business：存放业务逻辑
- cache：存放缓存相关的操作
- db：存放对数据库的封装
- engine：存放所有的业务逻辑对象，比如User，ClassicCase，ARModel，ShortVideo，Class等
- fragment：所有fragment均放在次文件夹下
- interfaces：所有公共接口均放在此文件夹下，命名以I作为开头
- litener：较复杂，代码较长以及其它需要分离的的listener放在此文件夹下，命名以On作为开头
- net：对网络底层的封装
- receiver：所有BroadCastReceiver放在此文件夹下
- service：所有Service放在此文件夹下
- ui：所有自定义控件，自定义动画等UI操作放在此文件夹下
- utils：将可抽离出来的公共方法放在此文件夹下，如SharedPreference，正则表达式等

## 3. 第三方库
- 目前已添加的第三方库：
- Glide：版本3.7.0，用于图片加载   [https://github.com/bumptech/glide](http://note.youdao.com/)
- OkHttp：版本3.6.0，用于网络请求（我可能会对这个进行封装） [https://github.com/square/okhttp](http://note.youdao.com/)
- Bugly：用于异常上报和运营统计
- CircleImageView：用于显示圆形图片，目前主要用于显示用户头像 [https://github.com/FishpondKing/CircleImageView](http://note.youdao.com/)
- BottomNavigation: 用于HomeActivity底部选择菜单（后期准备用Google官方的替换掉） [https://github.com/FishpondKing/BottomNavigation](http://note.youdao.com/)

> 注：如果已经添加的第三方库已经满足需求的话，如图片加载，网络请求，则尽量使用已经添加的第三方库；
如已经添加的第三方库不能满足需求，如短信注册SDK，邮箱注册SDK，第三方登录等，则及时说明并自行添加

## 4.BaseActvity 与 BaseFragment 使用
### 为便于管理所有需要使用的Activity和Fragment都需要分别集成BaseActivity与BaseFragment
### 继承自BaseActivity的Activity使用如下：

```java
public class MainActivity extends BaseActivity {
    private Button btn;

    @Override
    public void initVariables(Bundle parms) {
        //解析bundle内容,初始化变量
    }

    @Override
    public int bindLayout() {
        //返回activity的布局id
        return R.layout.activity_main;
    }

    @Override
    public void initViews(View view, Bundle savedInstanceState) {
        //初始化控件
        //快捷绑定
        btn = $(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void doBusiness(Context context) {
        //处理业务逻辑
    }

    @Override
    public void viewClick(View view) {
        //处理需实现View.OnClickListner的点击事件
        switch (v.getId()){
            case R.id.button:
                //处理点击事件
                //用简化了的toast
                showToast("toast");
                break;
            default:
                break;
        }
    }

}
```
>注：更多具体细节请查看BaseActivity源码，BaseActivity主要是对Activity的onCreate()方法进行解耦，使其更符合职责单一原则；继承自Fragment的BaseFragment与BaseActivity的使用方法基本一致，BaseFragment主要是对Fragment的onCreateView()方法进行解耦，使其更符合职责单一原则，具体细节可查看BaseFragment源码。

## 5.App中所需要用到的颜色（字体，背景），字体大小，控件间距（margin，padding），如无特殊需求，为便于修改，统一使用 colors.xml 和  dimens.xml 中定义的内容

## 6.所有要在xml或Java文件中使用的字符串，如确定不变，最好按模块分类定义在strings.xml中

## 7.其余变量命名，类命名，布局命名等请参考以下网址
1. [http://www.jianshu.com/p/419f5357357d](http://note.youdao.com/)
1. [http://www.jianshu.com/p/0a984f999592#](http://note.youdao.com/)

## 此规范还在不断完善中，如有不妥的内容或需要增改的内容（比如增加的第三方库）请大家在群里讨论，或者和我联系，多谢！
