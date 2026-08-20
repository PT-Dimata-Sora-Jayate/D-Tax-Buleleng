
/* Created on 	:  [date] [time] AM/PM
 *
 * @author  	: karya
 * @version  	: 01
 */
/*******************************************************************
 * Class Description 	: [project description ... ]
 * Imput Parameters 	: [input parameter ...]
 * Output 		: [output ...]
 *******************************************************************/
package com.dimata.common.entity.location;

/* package java */
import java.io.*;

/* package qdep */
import com.dimata.qdep.entity.*;

public class Location extends Entity implements Serializable {

    private String name = "";
    private long contactId = 0;
    private String description = "";
    private String code = "";
    private String address = "";
    private String telephone = "";
    private String fax = "";
    private String person = "";
    private String email = "";
    private int type = 0;
    private long parentLocationId = 0;
    private String website = "";
    private long vendorId;
    
    //add prochain 13-06-2012
    private double servicePersen = 0.0;
    private double taxPersen = 0.0;

    private long departmentId = 0;
    private double serviceValue = 0.0;
    private double taxValue = 0.0;
    private double serviceValueUsd = 0.0;
    private double taxValueUsd = 0.0;
    private int reportGroup = 0;
    private int typeBase = 0;
    private int locIndex = 0;

    //add opie 13-06-2012
    private int taxSvcDefault=0;
    private double persentaseDistributionPurchaseOrder=0.0;
      //add fitra 29-01-2014
    private long companyId =0;
    
    //update by fitra
    private String companyName;

    public int getLocIndex(){
        return locIndex;
    }

    public void setLocIndex(int locIndex) {
        this.locIndex = locIndex;
    }

    public int getTypeBase() {
        return typeBase;
    }

    public void setTypeBase(int typeBase) {
        this.typeBase = typeBase;
    }

    public double getServicePersen() {
        return servicePersen;
    }

    public void setServicePersen(double servicePersen) {
        this.servicePersen = servicePersen;
    }

    public double getTaxPersen() {
        return taxPersen;
    }

    public void setTaxPersen(double taxPersen) {
        this.taxPersen = taxPersen;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public double getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(double serviceValue) {
        this.serviceValue = serviceValue;
    }

    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }

    public double getServiceValueUsd() {
        return serviceValueUsd;
    }

    public void setServiceValueUsd(double serviceValueUsd) {
        this.serviceValueUsd = serviceValueUsd;
    }

    public double getTaxValueUsd() {
        return taxValueUsd;
    }

    public void setTaxValueUsd(double taxValueUsd) {
        this.taxValueUsd = taxValueUsd;
    }

    public int getReportGroup() {
        return reportGroup;
    }

    public void setReportGroup(int reportGroup) {
        this.reportGroup = reportGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            name = "";
        }
        this.name = name;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) {
            description = "";
        }
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null) {
            code = "";
        }
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) {
            address = "";
        }
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone == null) {
            telephone = "";
        }
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        if (fax == null) {
            fax = "";
        }
        this.fax = fax;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        if (person == null) {
            person = "";
        }
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            email = "";
        }
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getParentLocationId() {
        return parentLocationId;
    }

    public void setParentLocationId(long parentLocationId) {
        this.parentLocationId = parentLocationId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        if (website == null) {
            website = "";
        }
        this.website = website;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public String getPstClassName() {
        return "com.dimata.common.entity.location.PstLocation";
    }

    /**
     * @return the taxSvcDefault
     */
    public int getTaxSvcDefault() {
        return taxSvcDefault;
}

    /**
     * @param taxSvcDefault the taxSvcDefault to set
     */
    public void setTaxSvcDefault(int taxSvcDefault) {
        this.taxSvcDefault = taxSvcDefault;
    }

    /**
     * @return the persentaseDistributionPurchaseOrder
     */
    public double getPersentaseDistributionPurchaseOrder() {
        return persentaseDistributionPurchaseOrder;
    }

    /**
     * @param persentaseDistributionPurchaseOrder the persentaseDistributionPurchaseOrder to set
     */
    public void setPersentaseDistributionPurchaseOrder(double persentaseDistributionPurchaseOrder) {
        this.persentaseDistributionPurchaseOrder = persentaseDistributionPurchaseOrder;
    }

    /**
     * @return the companyName
     */


    /**
     * @return the companyId
     */
    public long getCompanyId() {
        return companyId;
}

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
