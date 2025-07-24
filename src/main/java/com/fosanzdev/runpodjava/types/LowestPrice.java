package com.fosanzdev.runpodjava.types;

import java.util.List;

public class LowestPrice {
    private String gpuName;
    private String gpuTypeId;
    private Float minimumBidPrice;
    private Float uninterruptablePrice;
    private Integer minMemory;
    private Integer minVcpu;
    private Float rentalPercentage;
    private Integer rentedCount;
    private Integer totalCount;
    private String stockStatus;
    private Integer minDownload;
    private Integer minDisk;
    private Integer minUpload;
    private String countryCode;
    private Boolean supportPublicIp;
    private List<String> compliance; // Assuming Compliance is a string enum
    private Integer maxGpuCount;
    private Integer maxUnreservedGpuCount;
    private List<Integer> availableGpuCounts;

    // Constructors
    public LowestPrice() {}

    // Getters and setters
    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public String getGpuTypeId() {
        return gpuTypeId;
    }

    public void setGpuTypeId(String gpuTypeId) {
        this.gpuTypeId = gpuTypeId;
    }

    public Float getMinimumBidPrice() {
        return minimumBidPrice;
    }

    public void setMinimumBidPrice(Float minimumBidPrice) {
        this.minimumBidPrice = minimumBidPrice;
    }

    public Float getUninterruptablePrice() {
        return uninterruptablePrice;
    }

    public void setUninterruptablePrice(Float uninterruptablePrice) {
        this.uninterruptablePrice = uninterruptablePrice;
    }

    public Integer getMinMemory() {
        return minMemory;
    }

    public void setMinMemory(Integer minMemory) {
        this.minMemory = minMemory;
    }

    public Integer getMinVcpu() {
        return minVcpu;
    }

    public void setMinVcpu(Integer minVcpu) {
        this.minVcpu = minVcpu;
    }

    public Float getRentalPercentage() {
        return rentalPercentage;
    }

    public void setRentalPercentage(Float rentalPercentage) {
        this.rentalPercentage = rentalPercentage;
    }

    public Integer getRentedCount() {
        return rentedCount;
    }

    public void setRentedCount(Integer rentedCount) {
        this.rentedCount = rentedCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Integer getMinDownload() {
        return minDownload;
    }

    public void setMinDownload(Integer minDownload) {
        this.minDownload = minDownload;
    }

    public Integer getMinDisk() {
        return minDisk;
    }

    public void setMinDisk(Integer minDisk) {
        this.minDisk = minDisk;
    }

    public Integer getMinUpload() {
        return minUpload;
    }

    public void setMinUpload(Integer minUpload) {
        this.minUpload = minUpload;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getSupportPublicIp() {
        return supportPublicIp;
    }

    public void setSupportPublicIp(Boolean supportPublicIp) {
        this.supportPublicIp = supportPublicIp;
    }

    public List<String> getCompliance() {
        return compliance;
    }

    public void setCompliance(List<String> compliance) {
        this.compliance = compliance;
    }

    public Integer getMaxGpuCount() {
        return maxGpuCount;
    }

    public void setMaxGpuCount(Integer maxGpuCount) {
        this.maxGpuCount = maxGpuCount;
    }

    public Integer getMaxUnreservedGpuCount() {
        return maxUnreservedGpuCount;
    }

    public void setMaxUnreservedGpuCount(Integer maxUnreservedGpuCount) {
        this.maxUnreservedGpuCount = maxUnreservedGpuCount;
    }

    public List<Integer> getAvailableGpuCounts() {
        return availableGpuCounts;
    }

    public void setAvailableGpuCounts(List<Integer> availableGpuCounts) {
        this.availableGpuCounts = availableGpuCounts;
    }

    @Override
    public String toString() {
        return "com.fosanzdev.runpodjava.types.LowestPrice{" +
                "gpuName='" + gpuName + '\'' +
                ", gpuTypeId='" + gpuTypeId + '\'' +
                ", minimumBidPrice=" + minimumBidPrice +
                ", uninterruptablePrice=" + uninterruptablePrice +
                ", minMemory=" + minMemory +
                ", minVcpu=" + minVcpu +
                ", rentalPercentage=" + rentalPercentage +
                ", rentedCount=" + rentedCount +
                ", totalCount=" + totalCount +
                ", stockStatus='" + stockStatus + '\'' +
                ", minDownload=" + minDownload +
                ", minDisk=" + minDisk +
                ", minUpload=" + minUpload +
                ", countryCode='" + countryCode + '\'' +
                ", supportPublicIp=" + supportPublicIp +
                ", compliance=" + compliance +
                ", maxGpuCount=" + maxGpuCount +
                ", maxUnreservedGpuCount=" + maxUnreservedGpuCount +
                ", availableGpuCounts=" + availableGpuCounts +
                '}';
    }
}