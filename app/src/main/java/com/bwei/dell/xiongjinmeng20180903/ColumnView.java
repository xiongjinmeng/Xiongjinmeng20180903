package com.bwei.dell.xiongjinmeng20180903;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class ColumnView extends View {

    private final static int X_LAB = 0;
    private final static int Y_LAB = 1;
    private Paint mTabLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int color_label_line = Color.parseColor("#DDDDDD");
    private int mLineStroke = 1;
    private int mLabelCount = 10;
    private float maxValue = 100*1.2f;
    private float minValue = 20;
    private float[] mColumnData;
    private String mAxisXTitle = "X轴";
    private String mAxisYTitle = "Y轴";
    private String[] mColumnName;
    private String[] mAxisYName;
//    private int mAxisTitleSize =  DensityUtils.dp2px(getContext(),12);
//    private int mAxisNameTitleSize =  DensityUtils.dp2px(getContext(),20);
//    private int mAxisTaxtDistance =  DensityUtils.dp2px(getContext(),6);
//    private int mColumnMarginRight =  DensityUtils.dp2px(getContext(),3);
//    private int mMaxSubcolumnWidth =  DensityUtils.dp2px(getContext(),40);
//    private int mPaddingLabLine = mAxisTitleSize + mAxisNameTitleSize + 2*mAxisTaxtDistance;

    public ColumnView(Context context) {
        this(context,null);
    }

    public ColumnView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColumnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mTabLinePaint.setColor(color_label_line);
        mTabLinePaint.setStrokeWidth(mLineStroke);
        initData();
    }

    private void initData() {
        mColumnData = new float[8];
        for (int i = 0;i<mColumnData.length;i++){
            mColumnData[i] = new Random().nextInt(80) + 20;
        }
        mColumnName = new String[8];
        for (int i = 0;i<mColumnData.length;i++){
            mColumnName[i] = "数据"+String.valueOf(i+1);
        }
        mAxisYName =new String[mLabelCount];
        int v = (int) ((maxValue - minValue)/mLabelCount*100);
        float value = v/100f;
        for (int i = 0;i<mAxisYName.length;i++){
            String axisName = value*i+minValue+"";
            mAxisYName[i] = axisName;
        }
    }
    public void layout(int l,int t,int r,int b){
        super.layout(l,t,r,b);
        int width = getWidth();
    }
}
