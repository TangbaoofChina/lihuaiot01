package com.system.po.EChartsOptions;

import com.system.po.EChartsOptions.EChartsTBF.*;

public class EChartsToolBoxFeature {
    private EctbfMark mark;
    private EctbfDataView dataView;
    private EctbfMagicType magicType;
    private EctbfRestore restore;
    private EctbfDataZoom dataZoom;
    private EctbfSaveAsImage saveAsImage;

    public EctbfMark getMark() {
        return mark;
    }

    public void setMark(EctbfMark mark) {
        this.mark = mark;
    }

    public EctbfDataView getDataView() {
        return dataView;
    }

    public void setDataView(EctbfDataView dataView) {
        this.dataView = dataView;
    }

    public EctbfMagicType getMagicType() {
        return magicType;
    }

    public void setMagicType(EctbfMagicType magicType) {
        this.magicType = magicType;
    }

    public EctbfRestore getRestore() {
        return restore;
    }

    public void setRestore(EctbfRestore restore) {
        this.restore = restore;
    }

    public EctbfDataZoom getDataZoom() {
        return dataZoom;
    }

    public void setDataZoom(EctbfDataZoom dataZoom) {
        this.dataZoom = dataZoom;
    }

    public EctbfSaveAsImage getSaveAsImage() {
        return saveAsImage;
    }

    public void setSaveAsImage(EctbfSaveAsImage saveAsImage) {
        this.saveAsImage = saveAsImage;
    }

    public EChartsToolBoxFeature()
    {
        setMark(new EctbfMark());
        setDataView(new EctbfDataView());
        setMagicType(new EctbfMagicType());
        setRestore(new EctbfRestore());
        setDataZoom(new EctbfDataZoom());
        setSaveAsImage(new EctbfSaveAsImage());
    }
}
