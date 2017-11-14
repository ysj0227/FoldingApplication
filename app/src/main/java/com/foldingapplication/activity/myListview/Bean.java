package com.foldingapplication.activity.myListview;

/**
 * Created by shijie.yang on 2017/11/3.
 */

public class Bean {
//            "time": "2017-09-25 14:58:09",
//             "price": 100,
//             "imageId": "http://t.winttp.com:80/is/imgUpload/852b34d8-befe-4967-b233-664024f202d3_mini.jpg",
//             "activityid": "47",
//             "name": "刘烨",
//             "userid": "1045",
//             "state": "0",
//             "quantity": "1",
//             "origPrice": 200,
//             "productName": "农舟行10g*10包*12小盒*5中盒"

    private String id;
    private String time;
    private String price;
    private String imageId;
    private String activityid;
    private String name;
    private String userid;
    private String state;
    private String quantity;
    private String origPrice;
    private String productName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOrigPrice() {
        return origPrice;
    }

    public void setOrigPrice(String origPrice) {
        this.origPrice = origPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
