package com.patryk1007.zoomviewpager;

public class TextAttr {

    private float hvTextSize;
    private int hvTextColor;
    private int hvTextColorActiveTab;
    private float hvTextAlpha;
    private float hvTextAlphaActiveTab;
    private float hvMinScale;
    private float hvMaxScale;
    private float hvPadding;

    public TextAttr() {
    }

    public float getHvPadding() {
        return hvPadding;
    }

    public void setHvPadding(float hvPadding) {
        this.hvPadding = hvPadding;
    }

    public float getHvTextSize() {
        return hvTextSize;
    }

    public void setHvTextSize(float hvTextSize) {
        this.hvTextSize = hvTextSize;
    }

    public int getHvTextColor() {
        return hvTextColor;
    }

    public void setHvTextColor(int hvTextColor) {
        this.hvTextColor = hvTextColor;
    }

    public int getHvTextColorActiveTab() {
        return hvTextColorActiveTab;
    }

    public void setHvTextColorActiveTab(int hvTextColorActiveTab) {
        this.hvTextColorActiveTab = hvTextColorActiveTab;
    }

    public float getHvTextAlpha() {
        if (hvTextAlphaActiveTab < hvTextAlpha) {
            return hvTextAlphaActiveTab;
        }
        return hvTextAlpha;
    }

    public void setHvTextAlpha(float hvTextAlpha) {
        this.hvTextAlpha = hvTextAlpha;
    }

    public float getHvTextAlphaActiveTab() {
        return hvTextAlphaActiveTab;
    }

    public void setHvTextAlphaActiveTab(float hvTextAlphaActiveTab) {
        this.hvTextAlphaActiveTab = hvTextAlphaActiveTab;
    }

    public float getHvMinScale() {
        if (hvMaxScale < hvMinScale) {
            return hvMaxScale;
        }
        return hvMinScale;
    }

    public void setHvMinScale(float hvMinScale) {
        this.hvMinScale = hvMinScale;
    }

    public float getHvMaxScale() {
        return hvMaxScale;
    }

    public void setHvMaxScale(float hvMaxScale) {
        this.hvMaxScale = hvMaxScale;
    }
}