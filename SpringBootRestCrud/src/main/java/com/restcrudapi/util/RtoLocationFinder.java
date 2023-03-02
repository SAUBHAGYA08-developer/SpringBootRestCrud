package com.restcrudapi.util;

import java.util.HashMap;

public class RtoLocationFinder {

    // Map RTO codes to city and state names
    private static final HashMap<String, String[]> rtoLocations = new HashMap<>();
    
    // Initialize the RTO locations map with sample data
    static {
    	rtoLocations.put("AP02", new String[] { "Andhra Pradesh", "Adilabad" });
    	rtoLocations.put("AP03", new String[] { "Andhra Pradesh", "Anantapur" });
    	rtoLocations.put("AP04", new String[] { "Andhra Pradesh", "Chittoor" });
    	rtoLocations.put("AP05", new String[] { "Andhra Pradesh", "Kadapa" });
    	rtoLocations.put("AP06", new String[] { "Andhra Pradesh", "East Godavari" });
    	rtoLocations.put("AP07", new String[] { "Andhra Pradesh", "Guntur" });
    	rtoLocations.put("AP08", new String[] { "Andhra Pradesh", "Hyderabad" });
    	rtoLocations.put("AP09", new String[] { "Andhra Pradesh", "Karimnagar" });
    	rtoLocations.put("AP10", new String[] { "Andhra Pradesh", "Khammam" });
    	rtoLocations.put("AP11", new String[] { "Andhra Pradesh", "Krishna" });
    	rtoLocations.put("AP12", new String[] { "Andhra Pradesh", "Kurnool" });
    	rtoLocations.put("AP13", new String[] { "Andhra Pradesh", "Mahbubnagar" });
    	rtoLocations.put("AP14", new String[] { "Andhra Pradesh", "Medak" });
    	rtoLocations.put("AP15", new String[] { "Andhra Pradesh", "Nalgonda" });
    	rtoLocations.put("AP16", new String[] { "Andhra Pradesh", "Nellore" });
    	rtoLocations.put("AP17", new String[] { "Andhra Pradesh", "Nizamabad" });
    	rtoLocations.put("AP18", new String[] { "Andhra Pradesh", "Prakasam" });
    	rtoLocations.put("AP19", new String[] { "Andhra Pradesh", "Rangareddy" });
    	rtoLocations.put("AP20", new String[] { "Andhra Pradesh", "Srikakulam" });
    	rtoLocations.put("AP21", new String[] { "Andhra Pradesh", "Visakhapatnam" });
    	rtoLocations.put("AP22", new String[] { "Andhra Pradesh", "Vizianagaram" });
    	rtoLocations.put("AP23", new String[] { "Andhra Pradesh", "Warangal" });
    	rtoLocations.put("AP24", new String[] { "Andhra Pradesh", "West Godavari" });
    	rtoLocations.put("AP25", new String[] { "Andhra Pradesh", "Y.S.R." });
        
    	//Mahdya pradesh
    	rtoLocations.put("MP02", new String[] { "Madhya Pradesh", "Bhopal" });
    	rtoLocations.put("MP03", new String[] { "Madhya Pradesh", "Shivpuri" });
    	rtoLocations.put("MP04", new String[] { "Madhya Pradesh", "Gwalior" });
    	rtoLocations.put("MP05", new String[] { "Madhya Pradesh", "Hoshangabad" });
    	rtoLocations.put("MP06", new String[] { "Madhya Pradesh", "Morena" });
    	rtoLocations.put("MP08", new String[] { "Madhya Pradesh", "Guna" });
    	rtoLocations.put("MP09", new String[] { "Madhya Pradesh", "Indore" });
    	rtoLocations.put("MP10", new String[] { "Madhya Pradesh", "Khargone" });
    	rtoLocations.put("MP11", new String[] { "Madhya Pradesh", "Dhar" });
    	rtoLocations.put("MP12", new String[] { "Madhya Pradesh", "Khandwa" });
    	rtoLocations.put("MP13", new String[] { "Madhya Pradesh", "Ujjain" });
    	rtoLocations.put("MP14", new String[] { "Madhya Pradesh", "Mandsaur" });
    	rtoLocations.put("MP15", new String[] { "Madhya Pradesh", "Sagar" });
    	rtoLocations.put("MP16", new String[] { "Madhya Pradesh", "Chhatarpur" });
    	rtoLocations.put("MP17", new String[] { "Madhya Pradesh", "Rewa" });
    	rtoLocations.put("MP18", new String[] { "Madhya Pradesh", "Shahdol" });
    	rtoLocations.put("MP19", new String[] { "Madhya Pradesh", "Satna" });
    	rtoLocations.put("MP20", new String[] { "Madhya Pradesh", "Jabalpur" });
    	rtoLocations.put("MP21", new String[] { "Madhya Pradesh", "Katni" });
    	rtoLocations.put("MP22", new String[] { "Madhya Pradesh", "Seoni" });
    	rtoLocations.put("MP23", new String[] { "Madhya Pradesh", "Raipur" });
    	rtoLocations.put("MP24", new String[] { "Madhya Pradesh", "Durg" });
    	rtoLocations.put("MP25", new String[] { "Madhya Pradesh", "Jagdalpur" });
    	rtoLocations.put("MP26", new String[] { "Madhya Pradesh", "Bilaspur" });
    	rtoLocations.put("MP27", new String[] { "Madhya Pradesh", "Ambikapur" });
    	rtoLocations.put("MP28", new String[] { "Madhya Pradesh", "Chhindwara" });
    	rtoLocations.put("MP29", new String[] { "Madhya Pradesh", "Rajnandgaon" });
    	rtoLocations.put("MP30", new String[] { "Madhya Pradesh", "Bhind" });
    	rtoLocations.put("MP32", new String[] { "Madhya Pradesh", "Datia" });
    	rtoLocations.put("MP34", new String[] { "Madhya Pradesh", "Damoh" });
    	rtoLocations.put("MP35", new String[] { "Madhya Pradesh", "Panna" });
    	rtoLocations.put("MP37", new String[] { "Madhya Pradesh", "Sehore" });
    }

    /**
     * Given an RTO code, returns an array of strings containing the associated city and state.
     * @param rtoCode the RTO code to look up
     * @return an array of two strings containing the city and state associated with the RTO code
     * @throws IllegalArgumentException if the RTO code is not found in the RTO locations map
     */
    public static String[] getLocationFromRtoCode(String rtoCode) {
        if (!rtoLocations.containsKey(rtoCode)) {
            throw new IllegalArgumentException("Unknown RTO code: " + rtoCode);
        }
        return rtoLocations.get(rtoCode);
    }
}

