package com.kainos.ea.resources;

public class Job {
    public int id = 0;
    public String jobname = "Job name";
    public String description = "Job description";
    public int salary = 00_00;

    public Job(){
    }
    public Job(int id, String jobname, String description, int salary){
        this.id = id;
        this.jobname =jobname;
        this.description = description;
        this.salary = salary;
    }
}