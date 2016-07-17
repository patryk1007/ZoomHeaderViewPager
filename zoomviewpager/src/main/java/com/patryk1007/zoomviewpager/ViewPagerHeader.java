package com.patryk1007.zoomviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerHeader extends HorizontalScrollView implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

    private TextAttr textViewAttr;
    private TextView[] textViews = new TextView[0];
    private int headerPerView = 3;
    private int headerWidth;
    private ViewPager viewPager;


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return false;
            default:
                return super.onTouchEvent(ev);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        setCurrentPosition(position, positionOffsetPixels, positionOffset);

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {
        prepareHeaders();
    }

    public ViewPagerHeader(Context context, TextAttr textViewAttr) {
        super(context);
        this.textViewAttr = textViewAttr;
        defaultSettings();
    }

    public ViewPagerHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        viewPager.addOnAdapterChangeListener(this);
        prepareHeaders();
    }

    private void defaultSettings() {
        setHorizontalScrollBarEnabled(false);
    }

    private void prepareHeaders() {
        PagerAdapter adapter = viewPager.getAdapter();
        List<String> headers = new ArrayList<>();
        headers.add("");
        for (int i = 0; i < adapter.getCount(); i++) {
            CharSequence header = adapter.getPageTitle(i);
            headers.add(String.valueOf(header == null ? "" : header));
        }
        headers.add("");
        createHeader(headers);
    }

    private void createHeader(List<String> headers) {
        textViews = new TextView[headers.size()];
        headerWidth = getContext().getResources().getDisplayMetrics().widthPixels;

        this.removeAllViews();
        LinearLayout rootContainer = createRootContainer();
        for (int i = 0; i < headers.size(); i++) {
            rootContainer.addView(createHeaderItem(i, headers.get(i)));
        }
        this.addView(rootContainer);
    }

    private LinearLayout createRootContainer() {
        LinearLayout container = new LinearLayout(getContext());
        container.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        container.setOrientation(LinearLayout.HORIZONTAL);
        return container;
    }

    private TextView createHeaderItem(int position, String headerText) {

        TextView header = new TextView(getContext());
        LayoutParams linearParams = new LayoutParams(headerWidth / headerPerView, LayoutParams.WRAP_CONTENT);
        header.setLayoutParams(linearParams);

        header.setScaleX(textViewAttr.getHvMinScale());
        header.setScaleY(textViewAttr.getHvMinScale());
        header.setAlpha(textViewAttr.getHvTextAlpha());
        header.setTextColor(textViewAttr.getHvTextColor());
        header.setPadding(0, (int) textViewAttr.getHvPadding(), 0, (int) textViewAttr.getHvPadding());

        header.setMaxLines(1);
        header.setGravity(Gravity.CENTER);
        header.setEllipsize(TextUtils.TruncateAt.END);
        header.setText(headerText);
        header.setTextSize(TypedValue.COMPLEX_UNIT_PX, textViewAttr.getHvTextSize());

        textViews[position] = header;

        return header;
    }

    public void setCurrentPosition(int viewPagerPosition, int offset, float scale) {
        int currentPosition = viewPagerPosition + 1;
        updateScale(currentPosition, scale);
        scrollTo(viewPagerPosition * headerWidth / headerPerView + offset / headerPerView, 0);
    }

    private void updateScale(int current, float offset) {
        current = Math.round(current + offset);
        float position = 1 - (offset > 0.5f ? 1 - offset : offset);
        if (textViews != null && textViews.length > current) {
            updateTextView(textViews[current], getScale(position - 0.5f), getAlpha(position - 0.5f), textViewAttr.getHvTextColorActiveTab());
            updateNextAndPrev(current);
        }
    }

    private float getAlpha(float scale) {
        float range = textViewAttr.getHvTextAlphaActiveTab() - textViewAttr.getHvTextAlpha();
        return textViewAttr.getHvTextAlpha() + range * scale / 0.5f;
    }

    private float getScale(float scale) {
        float range = textViewAttr.getHvMaxScale() - textViewAttr.getHvMinScale();
        return textViewAttr.getHvMinScale() + range * scale / 0.5f;
    }

    private void updateNextAndPrev(int current) {
        float scale = textViewAttr.getHvMinScale();
        float alpha = textViewAttr.getHvTextAlpha();
        int color = textViewAttr.getHvTextColor();

        if (current > 0 && textViews != null && textViews.length > 0) {
            updateTextView(textViews[current - 1], scale, alpha, color);
        }

        if (textViews != null && textViews.length > current + 1) {
            updateTextView(textViews[current + 1], scale, alpha, color);
        }
    }

    private void updateTextView(TextView textView, float scale, float alpha, int color) {
        textView.setScaleX(scale);
        textView.setScaleY(scale);
        textView.setAlpha(alpha);
        textView.setTextColor(color);
    }

}
