package com.system.po.Device;

import com.system.po.Device.FeedC411.FeedC411DMBase;
import com.system.po.FeedC411.*;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.List;

public class FeedC411DM extends FeedC411DMBase {

    /**
     * 筒仓电缆
     */
    List<FC411Cable> cableList=new ArrayList<>();
    /**
     * 筒仓层
     */
    List<FC411Floor> floors = new ArrayList<>();

    /**最高温*/
    float high=0f;
    /**最低温*/
    float low=0f;
    /**平均温*/
    float avg=0f;
    /**
     * 最高温颜色
     */
    String highColor="000000";
    /**
     * 最低温颜色
     */
    String lowColor="000000";
    /**
     * 平均温颜色
     */
    String avgColor="000000";

    public List<FC411Cable> getCableList() {
        return cableList;
    }

    public void setCableList(List<FC411Cable> cableList) {
        this.cableList = cableList;
    }

    public List<FC411Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<FC411Floor> floors) {
        this.floors = floors;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public String getHighColor() {
        return highColor;
    }

    public void setHighColor(String highColor) {
        this.highColor = highColor;
    }

    public String getLowColor() {
        return lowColor;
    }

    public void setLowColor(String lowColor) {
        this.lowColor = lowColor;
    }

    public String getAvgColor() {
        return avgColor;
    }

    public void setAvgColor(String avgColor) {
        this.avgColor = avgColor;
    }

    public FeedC411DM(){
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("useState");
        phoneRealMsgInfo01.setTitle("状态：");
        if(this.getUseState() == 1){
            phoneRealMsgInfo01.setValue("缓用");
        }else{
            phoneRealMsgInfo01.setValue("使用");
        }
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("avg");
        phoneRealMsgInfo02.setTitle("平均温：");
        phoneRealMsgInfo02.setValue(String.valueOf(this.getAvg())+ "℃");
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("high");
        phoneRealMsgInfo03.setTitle("最高温：");
        phoneRealMsgInfo03.setValue(String.valueOf(this.getHigh())+ "℃");
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("low");
        phoneRealMsgInfo04.setTitle("最低温：");
        phoneRealMsgInfo04.setValue(String.valueOf(this.getLow())+ "℃");
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("stock");
        phoneRealMsgInfo07.setTitle("库存：");
        phoneRealMsgInfo07.setValue(String.valueOf(this.getStock()) + "吨");
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        PhoneRealMsgInfo phoneRealMsgInfo08 = new PhoneRealMsgInfo();
        phoneRealMsgInfo08.setId("water");
        phoneRealMsgInfo08.setTitle("水份：");
        phoneRealMsgInfo08.setValue(String.valueOf(this.getWater()) + "%");
        phoneRealMsgInfo08.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo08);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("sendDate");
        phoneRealMsgInfo06.setTitle("");
        phoneRealMsgInfo06.setValue(this.getSendDate());
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        return phoneRealMsgInfoList;
    }

    public PFC411TempInfo getPhoneRealMsgInfoDetail(){
        PFC411TempInfo siloTempInfo = new PFC411TempInfo();
        siloTempInfo.setNum(String.valueOf(this.getSiloNum()));
        if(this.getUseState() == 0)
            siloTempInfo.setUseState("使用");
        else
            siloTempInfo.setUseState("缓用");
        //层数
        siloTempInfo.setFloorNum(this.getFloors().size());
        //库存
        siloTempInfo.setStock(String.valueOf(this.getStock()));
        //水份
        siloTempInfo.setWater(String.valueOf(this.getWater()));
        //湿度
        siloTempInfo.setHumidity(String.valueOf(this.getHumidity01()));
        //环境湿度
        siloTempInfo.setEnvHumidity(String.valueOf(this.getEnvHumidity()));
        //最高温
        PFC411Temp high = new PFC411Temp(String.valueOf(this.getHigh()),this.getHighColor());
        siloTempInfo.setHigh(high);
        //最低温
        PFC411Temp low = new PFC411Temp(String.valueOf(this.getLow()),this.getLowColor());
        siloTempInfo.setLow(low);
        //平均温
        PFC411Temp avg = new PFC411Temp(String.valueOf(this.getAvg()),this.getAvgColor());
        siloTempInfo.setAvg(avg);

        //测温电缆
        List<PFC411Cable> cables = formatPhoneSiloCables();
        siloTempInfo.setCables(cables);

        return siloTempInfo;
    }

    /**
     * 合成测温电缆+最高温、最低温、平均温
     * @return
     */
    private List<PFC411Cable> formatPhoneSiloCables(){
        List<PFC411Cable> phoneSiloCables = new ArrayList<>();
        //合成测温电缆
        for(int i=0;i<getCableList().size();i++){
            FC411Cable cable = this.getCableList().get(i);
            PFC411Cable phoneSiloCable = cable.formatPhoneSiloCable();
            phoneSiloCables.add(phoneSiloCable);
        }
        //合成最高温、最低温、平均温
        List<PFC411Cable> phoneSiloCables01 = formatPhoneSiloHighLowAvg();
        phoneSiloCables.addAll(phoneSiloCables01);
        return phoneSiloCables;
    }

    /**
     * 合成手机端--最高温；最低温；平均温
     * @return
     */
    private List<PFC411Cable> formatPhoneSiloHighLowAvg(){
        PFC411Cable cableHigh = new PFC411Cable();
        PFC411Cable cableLow = new PFC411Cable();
        PFC411Cable cableAvg = new PFC411Cable();
        List<PFC411Temp> tempsHigh = new ArrayList<>();
        List<PFC411Temp> tempsLow = new ArrayList<>();
        List<PFC411Temp> tempsAvg = new ArrayList<>();
        for(int i=0;i<this.floors.size();i++){
            FC411Floor FC411Floor = this.floors.get(i);
            PFC411Temp tempHigh = new PFC411Temp(String.valueOf(FC411Floor.getHigh()), FC411Floor.getHighColor());
            PFC411Temp tempLow = new PFC411Temp(String.valueOf(FC411Floor.getLow()), FC411Floor.getLowColor());
            PFC411Temp tempAvg = new PFC411Temp(String.valueOf(FC411Floor.getAvg()), FC411Floor.getAvgColor());
            tempsHigh.add(tempHigh);
            tempsLow.add(tempLow);
            tempsAvg.add(tempAvg);
        }
        cableHigh.setNum("最高");
        cableHigh.setBgColor("FF0000");
        cableHigh.setTemps(tempsHigh);
        cableLow.setNum("最低");
        cableLow.setBgColor("FFFF00");
        cableLow.setTemps(tempsLow);
        cableAvg.setNum("平均");
        cableAvg.setBgColor("00FF00");
        cableAvg.setTemps(tempsAvg);
        List<PFC411Cable> phoneSiloCables = new ArrayList<>();
        phoneSiloCables.add(cableHigh);
        phoneSiloCables.add(cableLow);
        phoneSiloCables.add(cableAvg);
        return phoneSiloCables;
    }

    /**
     * 对筒仓电缆温度进行格式化计算，生成电缆温度和层温度
     */
    public void formatTemp(){
        //判断电缆数
        if(this.getCables() < 1)
            return;
        if(this.getCable01Nums() > 0){
            //筒仓电缆
            this.setCableList(formatSC());
            //每一层 这里一共10层，为了显示服务
            this.setFloors(formatFloor());
            //全仓最高温
            this.setHigh(countHigh(this.getCableList()));
            //全仓最低温
            this.setLow(countLow(this.getCableList()));
            //全仓平均温度
            this.setAvg(countAvg(this.getCableList()));
            if(this.getHigh() > this.getHighThreshold())
                this.setHighColor("FF0000");
            else
                this.setHighColor("000000");
            if(this.getLow() > this.getHighThreshold())
                this.setLowColor("FF0000");
            else
                this.setLowColor("000000");
            if(this.getAvg() > this.getHighThreshold())
                this.setAvgColor("FF0000");
            else
                this.setAvgColor("000000");
        }
    }

    /**
     * 所有电缆的温度值获取
     * @return
     */
    private List<FC411Cable> formatSC(){
        List<FC411Cable> FC411CableList = new ArrayList<>();
        int indexAll = 0;
        //第一根电缆
        if(this.getCable01Nums() > 0) {
            FC411Cable FC411Cable01 = new FC411Cable(1, this.getCable01Nums(), formatST01());
            FC411CableList.add(FC411Cable01);
        }
        indexAll = this.getCable01Nums();
        //第二根电缆
        if(this.getCable02Nums() > 0) {
            FC411Cable FC411Cable02 = new FC411Cable(2, this.getCable02Nums(), formatST02());
            FC411CableList.add(FC411Cable02);
        }
        indexAll = indexAll + this.getCable02Nums();
        //第三根电缆
        if(this.getCable03Nums() > 0){
            FC411Cable FC411Cable03 = new FC411Cable(3,this.getCable03Nums(),formatST03());
            FC411CableList.add(FC411Cable03);
        }
        indexAll = indexAll + this.getCable03Nums();
        //第四根电缆
        if(this.getCable04Nums() > 0) {
            FC411Cable FC411Cable04 = new FC411Cable(4, this.getCable04Nums(), formatST04());
            FC411CableList.add(FC411Cable04);
        }
        indexAll = indexAll + this.getCable04Nums();
        //第五根电缆
        if(this.getCable05Nums() > 0) {
            FC411Cable FC411Cable05 = new FC411Cable(5, this.getCable05Nums(), formatST05());
            FC411CableList.add(FC411Cable05);
        }
        indexAll = indexAll + this.getCable05Nums();
        //第六根电缆
        if(this.getCable06Nums() > 0) {
            FC411Cable FC411Cable06 = new FC411Cable(6, this.getCable06Nums(), formatST06());
            FC411CableList.add(FC411Cable06);
        }

        return FC411CableList;
    }

    //获取第一根电缆的温度值
    private List<FC411Temp> formatST01(){
        List<FC411Temp> fC411TempList = new ArrayList<>();
        for(int i=0;i<this.getCable01Nums();i++){
            FC411Temp fC411Temp = new FC411Temp(1,i,this);
            fC411TempList.add(fC411Temp);
        }
        return fC411TempList;
    }

    //获取第二根电缆的温度值
    private List<FC411Temp> formatST02(){
        List<FC411Temp> fC411TempList = new ArrayList<>();
        for(int i=0;i<this.getCable02Nums();i++){
            FC411Temp fC411Temp = new FC411Temp(2,i,this);
            fC411TempList.add(fC411Temp);
        }
        return fC411TempList;
    }

    //获取第三根电缆的温度值
    private List<FC411Temp> formatST03(){
        List<FC411Temp> fC411TempList = new ArrayList<>();
        for(int i=0;i<this.getCable03Nums();i++){
            FC411Temp fC411Temp = new FC411Temp(3,i,this);
            fC411TempList.add(fC411Temp);
        }
        return fC411TempList;
    }

    //获取第四根电缆的温度值
    private List<FC411Temp> formatST04(){
        List<FC411Temp> fC411TempList = new ArrayList<>();
        for(int i=0;i<this.getCable04Nums();i++){
            FC411Temp fC411Temp = new FC411Temp(4,i,this);
            fC411TempList.add(fC411Temp);
        }
        return fC411TempList;
    }

    //获取第五根电缆的温度值
    private List<FC411Temp> formatST05(){
        List<FC411Temp> fC411TempList = new ArrayList<>();
        for(int i=0;i<this.getCable05Nums();i++){
            FC411Temp fC411Temp = new FC411Temp(5,i,this);
            fC411TempList.add(fC411Temp);
        }
        return fC411TempList;
    }

    //获取第六根电缆的温度值
    private List<FC411Temp> formatST06(){
        List<FC411Temp> fC411TempList = new ArrayList<>();
        for(int i=0;i<this.getCable06Nums();i++){
            FC411Temp fC411Temp = new FC411Temp(6,i,this);
            fC411TempList.add(fC411Temp);
        }
        return fC411TempList;
    }

    /**
     * 合成层的温度 主要是最高温、最低温、平均温
     * @return
     */
    private List<FC411Floor> formatFloor(){
        List<FC411Floor> fC411FloorList = new ArrayList<>();
        int floorNumsMax = countMaxFloor();
        for(int i=0;i<16;i++){
            if(i >= floorNumsMax)
                break;
            //层号从1开始
            FC411Floor fc411Floor = new FC411Floor(i+1, this.getCableList(),this.getHighThreshold());
            fC411FloorList.add(fc411Floor);
        }
        return fC411FloorList;
    }

    /**
     * 查找最多的层
     * @return
     */
    private int countMaxFloor(){
        int floorNumsMax = this.getCable01Nums();
        if(floorNumsMax < this.getCable02Nums())
            floorNumsMax = this.getCable02Nums();
        if(floorNumsMax < this.getCable03Nums())
            floorNumsMax = this.getCable03Nums();
        if(floorNumsMax < this.getCable04Nums())
            floorNumsMax = this.getCable04Nums();
        if(floorNumsMax < this.getCable05Nums())
            floorNumsMax = this.getCable05Nums();
        if(floorNumsMax < this.getCable06Nums())
            floorNumsMax = this.getCable06Nums();
        return floorNumsMax;
    }

    /**
     * 计算最高温
     * @return
     */
    private float countHigh(List<FC411Cable> FC411CableList){
        float high = -100;
        for (FC411Cable sc: FC411CableList
        ) {
            if(sc.getHigh() > high)
                high = sc.getHigh();
        }
        return high;
    }

    /**
     * 计算最低温
     * @param FC411CableList
     * @return
     */
    private float countLow(List<FC411Cable> FC411CableList){
        float low= 100;
        for (FC411Cable sc: FC411CableList
        ) {
            if(low > sc.getLow())
                low=sc.getLow();
        }
        return low;
    }

    /**
     * 计算平均温
     * @param FC411CableList
     * @return
     */
    private float countAvg(List<FC411Cable> FC411CableList){
        float avg = 0;
        float accum = 0;
        int icount = 0;
        for (FC411Cable sc: FC411CableList
        ) {
            if(sc.getAvg() > 0) {
                accum = accum + sc.getAvg();
                icount = icount + 1;
            }
        }
        if(accum > 0)
            avg = accum / icount;
        return DataConvertor.formatFloat(avg,1);
    }

}
