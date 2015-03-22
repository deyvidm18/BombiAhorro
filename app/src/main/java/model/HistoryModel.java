package model;

import java.sql.Date;

public class HistoryModel {
    private int id;
    private float resultConsumption;
    private Date created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getResultConsumption() {
        return resultConsumption;
    }

    public void setResultConsumption(float resultConsumption) {
        this.resultConsumption = resultConsumption;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
