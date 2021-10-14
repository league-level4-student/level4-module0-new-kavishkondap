package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

    /*
     * itemsReceived cannot negative. All negative parameters should set
     * itemsReceived to 0.
     */

    private int itemsReceived;
    public void setItemsReceived (int items) {
    	if (items < 0) {
    		itemsReceived = 0;
    	}else {
    		itemsReceived = items;
    	}
    }
    
    public int getItemsReceived () {
    	return itemsReceived;
    }
    /*
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */

    private double degreesTurned;

    public void setDegreesTurned (double degrees) {
    	if (degrees < 0) {
    		degreesTurned = 0;
    	}else if (degrees > 360) {
    		degreesTurned = 360;
    	}else {
    		degreesTurned = degrees;
    	}
    }
    
    public double getDegreesTurned () {
    	return degreesTurned;
    }
    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    private String nomenclature;
    
    public void setNomenclature (String s) {
    	if (s.equals("")) {
    		nomenclature = " ";
    	}else {
    		nomenclature = s;
    	}
    }
    
    public String getNomenclature () {
    	return nomenclature;
    }
    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    private Object memberObj;
    public void setMemberObj (Object obj) {
    	if (obj instanceof String) {
    		memberObj = new Object ();
    	}else {
    		memberObj = obj;
    	}
    }
    
    public Object getMemberObj () {
    	return memberObj;
    }
}
