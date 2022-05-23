package com.codegym.model;

public class Service {
    private int idService;
    private String codeService;
    private String nameService;
    private int areaService;
    private double costService;
    private int maxPeopleService;
    private int rentTypeId;
    private int serviceTypeId;
    private String standardRoom;
    private String descriptionConvenienceService;
    private double PoolAreaService;
    private double numberFloorsService;


    public Service() {
    }

    public Service(int idService, String codeService, String nameService, int areaService, double costService,
                   int maxPeopleService, String standardRoom, String descriptionConvenienceService, double poolAreaService,
                   double numberFloorsService, int rentTypeId, int serviceTypeId) {
        this.idService = idService;
        this.codeService = codeService;
        this.nameService = nameService;
        this.areaService = areaService;
        this.costService = costService;
        this.maxPeopleService = maxPeopleService;
        this.standardRoom = standardRoom;
        this.descriptionConvenienceService = descriptionConvenienceService;
        this.PoolAreaService = poolAreaService;
        this.numberFloorsService = numberFloorsService;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getAreaService() {
        return areaService;
    }

    public void setAreaService(int areaService) {
        this.areaService = areaService;
    }

    public double getCostService() {
        return costService;
    }

    public void setCostService(double costService) {
        this.costService = costService;
    }

    public int getMaxPeopleService() {
        return maxPeopleService;
    }

    public void setMaxPeopleService(int maxPeopleService) {
        this.maxPeopleService = maxPeopleService;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionConvenienceService() {
        return descriptionConvenienceService;
    }

    public void setDescriptionConvenienceService(String descriptionConvenienceService) {
        this.descriptionConvenienceService = descriptionConvenienceService;
    }

    public double getPoolAreaService() {
        return PoolAreaService;
    }

    public void setPoolAreaService(double poolAreaService) {
        PoolAreaService = poolAreaService;
    }

    public double getNumberFloorsService() {
        return numberFloorsService;
    }

    public void setNumberFloorsService(double numberFloorsService) {
        this.numberFloorsService = numberFloorsService;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
