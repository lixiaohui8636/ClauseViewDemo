# ClauseViewDemo
封装了一个条目的view，广泛用于个人中心，设置等场景


---------------------------------------------------------------------------------------------------
## 效果图
![image](https://github.com/lixiaohui8636/ClauseViewDemo/blob/master/snashot.png)  
---------------------------------------------------------------------------------------------------

## 引用方法
### 1,AndroidStudio
     在build.gradle的dependencies中加入如下代码
```xml
    compile 'com.lixiaohui8636:clauseview:1.0'
```
###2，eclipse
    添加arr文件到libs
[点击下载arr文件](http://pan.baidu.com/s/1kVtpW3P)

---------------------------------------------------------------------------------------------------
## 示例代码
### 1,在Layout里面设置
```xml
<com.lixiaohui8636.widget.ClauseView
    xmlns:clause="http://schemas.android.com/apk/res-auto"
    android:id="@+id/aaa"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@android:color/white"
    android:layout_marginTop="@dimen/activity_horizontal_margin"
    clause:cv_title="@string/app_name"
    clause:cv_remark="@string/app_name"
    clause:cv_titleTextColor="@color/clauses_view_default_title_color"
    clause:cv_showUnderline="true"
    clause:cv_showOverline="true"
    clause:cv_underlinePaddingLeft="20dp"
    clause:cv_underlinePaddingRight="20dp"
    clause:cv_drawRight="@drawable/right_dark"
    clause:cv_drawLeft="@drawable/draw_left"
    clause:cv_drawLeftMargin="10dp"
    clause:cv_drawRightMargin="10dp"
    clause:cv_remarkTextColor="@color/colorAccent"
    />
```
### 2,java代码设置属性
```java
    ClausesView clausesView= (ClausesView) findViewById(R.id.aaa);
    clausesView.setUnderlineColor(R.color.colorAccent);
    clausesView.setTitleTextColor(R.color.colorAccent);
    clausesView.setTitle(R.string.app_name);
```
---------------------------------------------------------------------------------------------------
##参数说明
```xml
    cv_drawLeft： 左边的图标  默认图标
    cv_title：左边的文字 TITLE
    cv_remark：右边的文字 REMARK
    cv_drawRight：右边的图标  提供两种颜色的箭头 right_dark 灰色的向右箭头  right_light 白色的向右箭头 默认为灰色
    cv_showUnderline：是否显示下划线  默认下划线为灰色 高度为1dp
    cv_underlineColor：下划线颜色
    cv_underlineHeight：下划线高度
    cv_showOverline：是否显示上划线
    cv_overlineColor：上划线颜色
    cv_overlineHeight：上划线高度
    cv_titleTextColor：titile文字颜色
    cv_titleTextSize：title文字大小
    cv_remarkTextColor：remark文字颜色
    cv_remarkTextSize：remark文字大小
    cv_overlinePaddingLeft：上划线与左边的距离
    cv_overlinePaddingRight：上划线与右边的距离
    cv_underlinePaddingLeft：下划线与左边的距离
    cv_underlinePaddingRight：下划线与右边的距离
    cv_padding：控件的padding
    cv_drawLeftMargin：左边图标的margin
    cv_drawRightMargin：右边图标的margin
```
---------------------------------------------------------------------------------------------------


