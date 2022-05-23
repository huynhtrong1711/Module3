package com.codegym.model;

public class Employee {
    private int idEmployee;
    private String nameEmployee;
    private String birthdayEmployee;
    private String cardEmployee;
    private double salaryEmployee;
    private String phoneEmployee;
    private String emailEmployee;
    private String addressEmployee;
    private int positionId;
    private int educationDegreeId;
    private int divisionId;
    private String usernameCustomer;

    public Employee() {
    }

    public Employee(int idEmployee, String nameEmployee, String birthdayEmployee, String cardEmployee,
                    Double salaryEmployee, String phoneEmployee, String emailEmployee, String addressEmployee, int positionId,
                    int educationDegreeId, int divisionId, String usernameCustomer) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.birthdayEmployee = birthdayEmployee;
        this.cardEmployee = cardEmployee;
        this.salaryEmployee = salaryEmployee;
        this.phoneEmployee = phoneEmployee;
        this.emailEmployee = emailEmployee;
        this.addressEmployee = addressEmployee;
        this.positionId = positionId;
        this.divisionId = divisionId;
        this.educationDegreeId = educationDegreeId;
        this.usernameCustomer = usernameCustomer;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getBirthdayEmployee() {
        return birthdayEmployee;
    }

    public void setBirthdayEmployee(String birthdayEmployee) {
        this.birthdayEmployee = birthdayEmployee;
    }

    public String getCardEmployee() {
        return cardEmployee;
    }

    public void setCardEmployee(String cardEmployee) {
        this.cardEmployee = cardEmployee;
    }

    public Double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(Double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getUsernameCustomer() {
        return usernameCustomer;
    }

    public void setUsernameCustomer(String usernameCustomer) {
        this.usernameCustomer = usernameCustomer;
    }
}
