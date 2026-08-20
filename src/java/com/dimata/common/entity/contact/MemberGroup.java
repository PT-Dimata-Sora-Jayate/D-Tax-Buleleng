
/* Created on 	:  [date] [time] AM/PM 
 * 
 * @author	 :
 * @version	 :
 */

/*******************************************************************
 * Class Description 	: [project description ... ] 
 * Imput Parameters 	: [input parameter ...] 
 * Output 		: [output ...] 
 *******************************************************************/

package com.dimata.common.entity.contact; 
 
/* package java */ 
import java.util.Date;

/* package qdep */
import com.dimata.qdep.entity.*;

public class MemberGroup extends Entity { 

	private long discountTypeId;
	private long priceTypeId;
	private String code = "";
	private String name = "";
	private String description = "";

        /** Holds value of property groupType. */
        private int groupType = 1;
        
	public long getDiscountTypeId(){ 
		return discountTypeId; 
	} 

	public void setDiscountTypeId(long discountTypeId){ 
		this.discountTypeId = discountTypeId; 
	} 

	public long getPriceTypeId(){ 
		return priceTypeId; 
	} 

	public void setPriceTypeId(long priceTypeId){ 
		this.priceTypeId = priceTypeId; 
	} 

	public String getCode(){ 
		return code; 
	} 

	public void setCode(String code){ 
		if ( code == null ) {
			code = ""; 
		} 
		this.code = code; 
	} 

	public String getName(){ 
		return name; 
	} 

	public void setName(String name){ 
		if ( name == null ) {
			name = ""; 
		} 
		this.name = name; 
	} 

	public String getDescription(){ 
		return description; 
	} 

	public void setDescription(String description){ 
		if ( description == null ) {
			description = ""; 
		} 
		this.description = description; 
	} 

        /** Getter for property groupType.
         * @return Value of property groupType.
         *
         */
        public int getGroupType() {
            return this.groupType;
        }
        
        /** Setter for property groupType.
         * @param groupType New value of property groupType.
         *
         */
        public void setGroupType(int groupType) {
            this.groupType = groupType;
        }
        
}
