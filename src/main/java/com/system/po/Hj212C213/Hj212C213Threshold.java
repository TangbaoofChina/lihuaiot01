package com.system.po.Hj212C213;

public class Hj212C213Threshold {
    float minPh;
    float maxPh;
    float maxCOD;
    float maxNh3N;
    float maxTp;
    float maxFlowwater;

    public float getMinPh() {
        return minPh;
    }

    public void setMinPh(float minPh) {
        this.minPh = minPh;
    }

    public float getMaxPh() {
        return maxPh;
    }

    public void setMaxPh(float maxPh) {
        this.maxPh = maxPh;
    }

    public float getMaxCOD() {
        return maxCOD;
    }

    public void setMaxCOD(float maxCOD) {
        this.maxCOD = maxCOD;
    }

    public float getMaxNh3N() {
        return maxNh3N;
    }

    public void setMaxNh3N(float maxNh3N) {
        this.maxNh3N = maxNh3N;
    }

    public float getMaxTp() {
        return maxTp;
    }

    public void setMaxTp(float maxTp) {
        this.maxTp = maxTp;
    }

    public float getMaxFlowwater() {
        return maxFlowwater;
    }

    public void setMaxFlowwater(float maxFlowwater) {
        this.maxFlowwater = maxFlowwater;
    }

    public Hj212C213Threshold(){
        this.setMaxCOD(70f);
        this.setMaxNh3N(15f);
        this.setMaxTp(0.5f);
        this.setMinPh(6f);
        this.setMaxPh(9f);
        this.setMaxFlowwater(13f);
    }
}
