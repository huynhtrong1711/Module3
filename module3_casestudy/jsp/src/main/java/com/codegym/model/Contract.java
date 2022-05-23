package com.codegym.model;

public class Contract {
    private int contractId;
    private String startDateContract;
    private String endDateContract;
    private double depositContract;
    private double moneyTotalContract;
    private int idEmployee;
    private int idCustomer;
    private int idService;

    public Contract() {
    }

    public Contract(int contractId, String startDateContract, String endDateContract, Double depositContract,
                    Double moneyTotalContract, int idEmployee, int idCustomer, int idService) {
        this.contractId = contractId;
        this.startDateContract = startDateContract;
        this.endDateContract = endDateContract;
        this.depositContract = depositContract;
        this.moneyTotalContract = moneyTotalContract;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int idContract) {
        this.contractId = idContract;
    }

    public String getStartDateContract() {
        return startDateContract;
    }

    public void setStartDateContract(String startDateContract) {
        this.startDateContract = startDateContract;
    }

    public String getEndDateContract() {
        return endDateContract;
    }

    public void setEndDateContract(String endDateContract) {
        this.endDateContract = endDateContract;
    }

    public Double getDepositContract() {
        return depositContract;
    }

    public void setDepositContract(Double depositContract) {
        this.depositContract = depositContract;
    }

    public Double getMoneyTotalContract() {
        return moneyTotalContract;
    }

    public void setMoneyTotalContract(Double moneyTotalContract) {
        this.moneyTotalContract = moneyTotalContract;
    }

    public void setDepositContract(double depositContract) {
        this.depositContract = depositContract;
    }

    public void setMoneyTotalContract(double moneyTotalContract) {
        this.moneyTotalContract = moneyTotalContract;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }
}
