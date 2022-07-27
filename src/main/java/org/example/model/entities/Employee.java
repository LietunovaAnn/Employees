package org.example.model.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private LocalDate hiredate;
    private float sal;
    private float comm;
    private int depno;

    public Employee() {
        super();
    }

    public Employee(int empno, String ename, String job, int mgr,
                    LocalDate hiredate, float sal, float comm, int depno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.depno = depno;
    }


    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public float getComm() {
        return comm;
    }

    public void setComm(float comm) {
        this.comm = comm;
    }

    public int getDepno() {
        return depno;
    }

    public void setDepno(int depno) {
        this.depno = depno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empno == employee.empno && mgr == employee.mgr && sal == employee.sal && Float.compare(employee.comm, comm) == 0 && depno == employee.depno && Objects.equals(ename, employee.ename) && Objects.equals(job, employee.job) && Objects.equals(hiredate, employee.hiredate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, ename, job, mgr, hiredate, sal, comm, depno);
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "номер " + empno + "\n" +
                "имя='" + ename + "'\n" +
                "должность ='" + job + "'\n" +
                "его менеджер = " + mgr + "\n" +
                "дата приема на работу = " + hiredate + "\n" +
                "зарплата = " + sal + "\n" +
                "коммисионные = " + comm + "\n" +
                "номер департамента = " + depno;
    }

}
