package com.test.model;

public class Weather {
    private String date;
    private String message;
    private String status;
    private String city;
    private String count;
    private Data data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", city='" + city + '\'' +
                ", count='" + count + '\'' +
                ", data=" + data +
                '}';
    }
}
