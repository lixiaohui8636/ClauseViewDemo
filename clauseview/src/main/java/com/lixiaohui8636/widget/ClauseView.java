package com.lixiaohui8636.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lixiaohui8636.R;
/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑   永无BUG
         auth:lixiaohui
         email:lixiaohui8636@163.com
*/
public class ClauseView extends LinearLayout {

    private int underlineColor, overlineColor ,titleTextColor,remarkTextColor;
    private float underlineHeight,overlineHeight,overlinePaddingLeft,overlinePaddingRight,underlinePaddingLeft,underlinePaddingRight;
    private int drawLeft,drawRight;
    private boolean showUnderline,showOverline;
    private String title,remark;
    private float titleTextSize,remarkTextSize;

    private ImageView leftImageView,rightImageView;
    private TextView titleTextView,remarkTextView;
    private View topLineView,bottomLineView;
    private float leftImageViewMargin,rightImageViewMargin;

    private float padding;

    public ClauseView(Context context) {
        super(context);
    }

    public ClauseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a=context.getTheme().obtainStyledAttributes(attrs, R.styleable.ClausesView,0,0);
        try {
            underlineColor=a.getColor(R.styleable.ClausesView_cv_underlineColor,0xFF727272);
            overlineColor=a.getColor(R.styleable.ClausesView_cv_overlineColor,0xFF727272);
            titleTextColor=a.getColor(R.styleable.ClausesView_cv_titleTextColor,0xFF212121);
            remarkTextColor=a.getColor(R.styleable.ClausesView_cv_remarkTextColor,0xFF727272);
            underlineHeight=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_underlineHeight,1);
            overlineHeight=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_overlineHeight,1);
            drawLeft=a.getResourceId(R.styleable.ClausesView_cv_drawLeft,-1);
            drawRight=a.getResourceId(R.styleable.ClausesView_cv_drawRight,-1);
            title=a.getString(R.styleable.ClausesView_cv_title);
            remark=a.getString(R.styleable.ClausesView_cv_remark);
            titleTextSize=a.getDimension(R.styleable.ClausesView_cv_titleTextSize,16);
            remarkTextSize=a.getDimension(R.styleable.ClausesView_cv_remarkTextSize,14);
            showUnderline=a.getBoolean(R.styleable.ClausesView_cv_showUnderline,true);
            showOverline=a.getBoolean(R.styleable.ClausesView_cv_showOverline,false);
            overlinePaddingLeft=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_overlinePaddingLeft,0);
            overlinePaddingRight=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_overlinePaddingRight,0);
            underlinePaddingLeft=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_underlinePaddingLeft,0);
            underlinePaddingRight=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_underlinePaddingRight,0);
            padding=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_padding,0);
            leftImageViewMargin=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_drawLeftMargin,0);
            rightImageViewMargin=a.getDimensionPixelOffset(R.styleable.ClausesView_cv_drawRightMargin,0);
            super.setOrientation(VERTICAL);
            initView(context);
        }finally {
            a.recycle();
        }
    }
    public void initView(Context context){
        View view=inflate(context,R.layout.clauses_view,null);
        if(view==null)return;
        leftImageView= (ImageView) view.findViewById(R.id.draw_left);
        titleTextView= (TextView) view.findViewById(R.id.title);
        remarkTextView= (TextView) view.findViewById(R.id.remark);
        rightImageView= (ImageView) view.findViewById(R.id.draw_right);
        topLineView=view.findViewById(R.id.top_line);
        bottomLineView=view.findViewById(R.id.bottom_line);
        LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,(int)overlineHeight);
        layoutParams.setMargins((int)overlinePaddingLeft,0,(int)overlinePaddingRight,0);
        topLineView.setLayoutParams(layoutParams);
        LayoutParams layoutParams1=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,(int)underlineHeight);
        layoutParams1.setMargins((int)underlinePaddingLeft,0,(int)underlinePaddingRight,0);
        bottomLineView.setLayoutParams(layoutParams1);
        topLineView.setBackgroundColor(overlineColor);
        bottomLineView.setBackgroundColor(underlineColor);
        leftImageView.setImageResource(drawLeft);
        rightImageView.setImageResource(drawRight);
        RelativeLayout.LayoutParams layoutParams3= (RelativeLayout.LayoutParams) leftImageView.getLayoutParams();
        layoutParams3.setMargins((int)leftImageViewMargin,(int)leftImageViewMargin,(int)leftImageViewMargin,(int)leftImageViewMargin);
        leftImageView.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4= (RelativeLayout.LayoutParams) rightImageView.getLayoutParams();
        layoutParams4.setMargins((int)rightImageViewMargin,(int)rightImageViewMargin,(int)rightImageViewMargin,(int)rightImageViewMargin);
        rightImageView.setLayoutParams(layoutParams4);
        titleTextView.setText(title);
        titleTextView.setTextSize(titleTextSize);
        titleTextView.setTextColor(titleTextColor);
        remarkTextView.setText(remark);
        remarkTextView.setTextSize(remarkTextSize);
        remarkTextView.setTextColor(remarkTextColor);
        topLineView.setVisibility(showOverline?VISIBLE:GONE);
        bottomLineView.setVisibility(showUnderline?VISIBLE:GONE);
        RelativeLayout relativeLayout= (RelativeLayout) view.findViewById(R.id.content_view);
        LayoutParams layoutParams2= (LayoutParams) relativeLayout.getLayoutParams();
        layoutParams2.setMargins((int)padding,0,(int)padding,0);
        relativeLayout.setLayoutParams(layoutParams2);
        addView(view);
    }
    public void setUnderlineColor(int underlineColor) {
        this.underlineColor = underlineColor;
        bottomLineView.setBackgroundColor(getResources().getColor(underlineColor));
    }

    public void setOverlineColor(int overlineColor) {
        this.overlineColor = overlineColor;
        topLineView.setBackgroundColor(getResources().getColor(overlineColor));
    }

    public void setTitleTextColor(int titleTextColor) {
        this.titleTextColor = titleTextColor;
        titleTextView.setTextColor(getResources().getColor(titleTextColor));
    }

    public void setRemarkTextColor(int remarkTextColor) {
        this.remarkTextColor = remarkTextColor;
        remarkTextView.setTextColor(getResources().getColor(remarkTextColor));
    }

    public void setUnderlineHeight(int underlineHeight) {
        this.underlineHeight = underlineHeight;
        LayoutParams layoutParams= (LayoutParams) bottomLineView.getLayoutParams();
        layoutParams.height=underlineHeight;
        bottomLineView.setLayoutParams(layoutParams);
    }

    public void setOverlineHeight(int overlineHeight) {
        this.overlineHeight = overlineHeight;
        LayoutParams layoutParams= (LayoutParams) topLineView.getLayoutParams();
        layoutParams.height=overlineHeight;
        topLineView.setLayoutParams(layoutParams);
    }

    public void setDrawLeft(int drawLeft) {
        this.drawLeft = drawLeft;
        leftImageView.setImageResource(drawLeft);
    }

    public void setDrawRight(int drawRight) {
        this.drawRight = drawRight;
        rightImageView.setImageResource(drawRight);
    }

    public void setShowUnderline(boolean showUnderline) {
        this.showUnderline = showUnderline;
        bottomLineView.setVisibility(showUnderline?VISIBLE:GONE);
    }

    public void setShowOverline(boolean showOverline) {
        this.showOverline = showOverline;
        topLineView.setVisibility(showUnderline?VISIBLE:GONE);
    }

    public void setTitle(String title) {
        this.title = title;
        titleTextView.setText(title);
    }
    public void setTitle(int title) {
        this.title=getResources().getString(title);
        titleTextView.setText(title);
    }

    public void setRemark(String remark) {
        this.remark = remark;
        remarkTextView.setText(remark);
    }
    public void setRemark(int remark) {
        this.remark = getResources().getString(remark);
        remarkTextView.setText(remark);
    }

    public void setTitleTextSize(float titleTextSize) {
        this.titleTextSize = titleTextSize;
        titleTextView.setTextSize(titleTextSize);
    }

    public void setRemarkTextSize(float remarkTextSize) {
        this.remarkTextSize = remarkTextSize;
        remarkTextView.setTextSize(remarkTextSize);
    }

    public void setOverlinePaddingLeft(float overlinePaddingLeft) {
        this.overlinePaddingLeft = overlinePaddingLeft;
        LayoutParams layoutParams= (LayoutParams) topLineView.getLayoutParams();
        layoutParams.leftMargin=(int)overlinePaddingLeft;
        topLineView.setLayoutParams(layoutParams);
    }

    public void setOverlinePaddingRight(float overlinePaddingRight) {
        this.overlinePaddingRight = overlinePaddingRight;
        LayoutParams layoutParams= (LayoutParams) topLineView.getLayoutParams();
        layoutParams.rightMargin=(int)overlinePaddingRight;
        topLineView.setLayoutParams(layoutParams);
    }

    public void setUnderlinePaddingLeft(float underlinePaddingLeft) {
        this.underlinePaddingLeft = underlinePaddingLeft;
        LayoutParams layoutParams= (LayoutParams) bottomLineView.getLayoutParams();
        layoutParams.leftMargin=(int)underlinePaddingLeft;
        bottomLineView.setLayoutParams(layoutParams);
    }

    public void setUnderlinePaddingRight(float underlinePaddingRight) {
        this.underlinePaddingRight = underlinePaddingRight;
        LayoutParams layoutParams= (LayoutParams) bottomLineView.getLayoutParams();
        layoutParams.rightMargin=(int)underlinePaddingRight;
        bottomLineView.setLayoutParams(layoutParams);
    }

    public void setLeftImageViewMargin(float leftImageViewMargin) {
        this.leftImageViewMargin = leftImageViewMargin;
        RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) leftImageView.getLayoutParams();
        layoutParams.setMargins((int)leftImageViewMargin,(int)leftImageViewMargin,(int)leftImageViewMargin,(int)leftImageViewMargin);
        leftImageView.setLayoutParams(layoutParams);
    }

    public void setRightImageViewMargin(float rightImageViewMargin) {
        this.rightImageViewMargin = rightImageViewMargin;
        RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) rightImageView.getLayoutParams();
        layoutParams.setMargins((int)rightImageViewMargin,(int)rightImageViewMargin,(int)rightImageViewMargin,(int)rightImageViewMargin);
        rightImageView.setLayoutParams(layoutParams);
    }
}

