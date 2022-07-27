package org.example.model.entities;

public class SalaryGrade {
    private int grade;
    private float minsal;
    private float hisal;


    public SalaryGrade(int grade, float minsal, float hisal) {
        this.grade = grade;
        this.minsal = minsal;
        this.hisal = hisal;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public float getMinsal() {
        return minsal;
    }

    public void setMinsal(float minsal) {
        this.minsal = minsal;
    }

    public float getHisal() {
        return hisal;
    }

    public void setHisal(float hisal) {
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        return "SalaryGrade{" +
                "grade=" + grade +
                ", minsal=" + minsal +
                ", hisal=" + hisal +
                '}';
    }
}
