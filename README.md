# UiStatus 一个简单且强大的Android Ui视图状态控制库.

>**_我一直觉得程序员就像诗人一样，敲代码就像写诗，好的代码何尝不是一首优美的诗！  —— 装逼_**

所以我把项目中的视图控制部分抽取出来，单独封装成了UiStatus这个库。希望可以帮助大家简化这部分操作，也希望对大家有用。
话不多说先上效果图：

![演示gif](https://github.com/FengChenSunshine/UiStatus/blob/master/image/uistatus_demo_320.gif)

##目前该库包含的状态有9种：
    
| 常量名称 | 含义 | 使用场景 |
| :-: | :-: | :-: |
| LOADING | 加载中| 页面加载中状态 |
| NETWORK_ERROR | 网络错误 | 当网络连接错误时展示的界面 |
| LOAD_ERROR | 加载失败 | 接口请求失败时展示给用户的界面 |
| EMPTY | 空布局 | 当获取的数据为空时展示的界面 |
| NOT_FOUND | 未找到内容布局 | 有时获取的内容已被服务器删除，此时展示给用户一个404内容被删除的界面 |
| CONTENT|内容 | 真正需要展示给用户的内容视图，也是开发者在layout里实际布局的视图 |
| WIDGET_NETWORK_ERROR | 网络错误小部件 | 一个类似于QQ、微信断网时顶部显示的网络错误提示视图 |
| WIDGET_ELFIN | 小精灵(提示布局) | 一种顶部出现的提示布局，可以做类似于简书刷新时提醒推荐内容条数的小部件 |
| WIDGET_FLOAT | 底部Float | 一种底部弹出的浮动布局，可以实现底部弹出小组件的功能 |
 
其中，前6种状态不会同时显示，后main3种Widget组件状态的显示和前6种状态不冲突(可以同时显示)，
层次上视图Widget在前6种之上，WIDGET_ELFIN在WIDGET_NETWORK_ERROR之下。

 ##使用步骤
  ###1.添加依赖
**step one：**

    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
	    }
    }
  
**step two ：**

    dependencies {
            implementation 'com.github.FengChenSunshine:UiStatus:{version}'
    }
###2.全局配置
 UiStatus库不提供任何状态的视图，完全由开发者自己自定义提供。
 
 1.获取全局视图控制管理者.
 
 UiStatusManager.getInstance()
 
 2.配置状态视图.
  
    /**
    * @params uiStatus    视图状态.
    * @params layoutResId 开发者自定义的该状态视图.
    */
    addUiStatusConfig(@UiStatus int uiStatus, @LayoutRes int layoutResId);
 
    /**
    * @params uiStatus           视图状态.
    * @params layoutResId        开发者自定义的该状态视图.
    * @params retryTriggerViewId 该状态视图上点击事件的触发控件id.
    * @params retryListener      点击事件触发后的回调.
    */
    addUiStatusConfig(@UiStatus int uiStatus, @LayoutRes int layoutResId, @IdRes int retryTriggerViewId, OnRetryListener retryListener);
 
    /**
    * 该方法只针对Widget相关状态有效.
    * @params uiStatus       视图状态.
    * @params topMarginPx    widget相对于内容视图的顶部距离,比如可能需要预留出顶部Toolbar高度的距离.
    * @params bottomMarginPx widget相对于内容视图的底部距离,比如可能需要预留出底部导航栏高度的距离.
    */
    setWidgetMargin(@UiStatus @IntRange(from = 7L,to = 9L) int uiStatus, int topMarginPx, int bottomMarginPx);
 
  3.配置网络状态提供者.
  
    考虑到开发者项目中都有自己的网络状态监听、判断的工具类，
    所以UiStatus没有必要额外编辑这段功能代码，仅需要开发者配置一个回调即可。
    配置网络状态提供者后，在请求显示普通的状态时如果是没有网络那么将自动重定向到NETWORK_ERROR网络错误状态界面。
    具体配置方法如下:
    UiStatusNetworkStatusProvider
            .getInstance()
            .registerOnRequestNetworkStatusEvent(OnRequestNetworkStatusEvent networkStatusEvent);
  
###3.具体使用
    
**UiStatus可以使用在任何Activity、View以及Fragment中.**
  
  1.Activity中：
  
    UiStatusController.get().bind(activity);
    
  2.View中:
  
    UiStatusController.get().bind(view);
    
  3.Fragment中:
  
    由于Fragment的特殊性，所以这里稍微麻烦一点点：
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view;
            //你的视图初始化...
            mUiStatusController = UiStatusController.get();
            return mUiStatusController.bindFragment(view);
    }
    看以看出这里是使用bindFragment(view)方法将原本的内容视图传递给UiStatus，并将该方法返回的控件作为onCreateView的返回值即可。
    
  4.视图状态切换：
  
    对于普通视图切换使用UiStatusController.changeUiStatusIgnore(uiStatus)切换；
    对于Widget视图使用UiStatusController.showWidget(uiStatus)进行显示；
    或者使用其重载方法showWidget(uiStatus,duration)方法进行显示，使用该方法时会在duration时间后自动隐藏；
    其中第二个使用UiStatusController.hideWidget()方法进行隐藏。
  
##4.成功
经过上面的步骤之后您已经成功的集成并且可以使用UiStatus库了，并且您肯定也看到了想要看到的各种状态下的视图成功切换。
如果您不需要某些页面的个性化定制，那么到这里就OK了；否则请看下面的步骤会满足你的需求。
##5.个性化配置
一般情况下使用在Application中的全局配置已经能满足大部分页面视图状态的需求，
如果某些个别界面需要特殊配置那么UiStatus也是支持的。


