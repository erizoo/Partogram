package com.boiko.app.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsePatient {

    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("count_pregnancy")
    @Expose
    private Integer countPregnancy;
    @SerializedName("count_childbirth")
    @Expose
    private Integer countChildbirth;
    @SerializedName("history_number")
    @Expose
    private Integer historyNumber;
    @SerializedName("time_of_hospitalization")
    @Expose
    private String timeOfHospitalization;
    @SerializedName("duration_of_waterless_period")
    @Expose
    private Integer durationOfWaterlessPeriod;
    @SerializedName("blood_group")
    @Expose
    private String bloodGroup;
    @SerializedName("rhesus_blood")
    @Expose
    private String rhesusBlood;
    @SerializedName("time_start_of_parogram")
    @Expose
    private String timeStartOfParogram;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("midwife_id")
    @Expose
    private Integer midwifeId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountPregnancy() {
        return countPregnancy;
    }

    public void setCountPregnancy(Integer countPregnancy) {
        this.countPregnancy = countPregnancy;
    }

    public Integer getCountChildbirth() {
        return countChildbirth;
    }

    public void setCountChildbirth(Integer countChildbirth) {
        this.countChildbirth = countChildbirth;
    }

    public Integer getHistoryNumber() {
        return historyNumber;
    }

    public void setHistoryNumber(Integer historyNumber) {
        this.historyNumber = historyNumber;
    }

    public String getTimeOfHospitalization() {
        return timeOfHospitalization;
    }

    public void setTimeOfHospitalization(String timeOfHospitalization) {
        this.timeOfHospitalization = timeOfHospitalization;
    }

    public Integer getDurationOfWaterlessPeriod() {
        return durationOfWaterlessPeriod;
    }

    public void setDurationOfWaterlessPeriod(Integer durationOfWaterlessPeriod) {
        this.durationOfWaterlessPeriod = durationOfWaterlessPeriod;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getRhesusBlood() {
        return rhesusBlood;
    }

    public void setRhesusBlood(String rhesusBlood) {
        this.rhesusBlood = rhesusBlood;
    }

    public String getTimeStartOfParogram() {
        return timeStartOfParogram;
    }

    public void setTimeStartOfParogram(String timeStartOfParogram) {
        this.timeStartOfParogram = timeStartOfParogram;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMidwifeId() {
        return midwifeId;
    }

    public void setMidwifeId(Integer midwifeId) {
        this.midwifeId = midwifeId;
    }

}
