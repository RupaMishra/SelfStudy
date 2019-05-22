package com.example.selfstudy.model;

public class SubjectList{
    int icon;
    String subject_name;
    String progress;
    String pb;
    @Override
    public String toString() {
        return "SubjectList{" +
                "icon='" + icon + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", pb='" + pb + '\'' +
                ", progress=" + progress +
                '}';
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public SubjectList(int icon, String subject_name, String pb, String progress) {
        this.icon = icon;
        this.subject_name = subject_name;
        this.pb = pb;
        this.progress = progress;
    }


}
