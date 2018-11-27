package com.myapp.mvc_mvp_mvvm.ordinary.entry;

public class JobInfoBean {
    String jobName;
    String strengths;
    String shortcoming;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getShortcoming() {
        return shortcoming;
    }

    public void setShortcoming(String shortcoming) {
        this.shortcoming = shortcoming;
    }

    @Override
    public String toString() {
        return "职业信息{" +
                "jobName='" + jobName + '\'' +
                ", strengths='" + strengths + '\'' +
                ", shortcoming='" + shortcoming + '\'' +
                '}';
    }
}
