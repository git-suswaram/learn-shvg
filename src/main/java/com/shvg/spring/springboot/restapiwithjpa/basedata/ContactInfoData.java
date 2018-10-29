package com.shvg.spring.springboot.restapiwithjpa.basedata;

import com.shvg.spring.springboot.restapiwithjpa.beans.ContactInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactInfoData {

    private ContactInfoData() {
        throw new IllegalStateException("Utility class");
    }


    private static final ContactInfo[] arrayOfContactInfoPayLoad =
            {
                    new ContactInfo(1001, "1001 Best St", "Suite 300", "Best", "CA", "32341", "US", "12172354891", "12357547963", 1001),
                    new ContactInfo(2001, "2001 Main St", "", "Main", "NY", "42342", "US", "13172354892", "", 2001),
                    new ContactInfo(3001, "3001 Good St", "", "Good", "IL", "52343", "US", "14172354893", "", 3001),
                    new ContactInfo(4001, "4001 Good Ln", "", "Good", "GA", "62344", "US", "15172354894", "", 4001),
                    new ContactInfo(5001, "5001 Good Tr", "", "Good", "TX", "72345", "US", "16172354895", "", 5001),
                    new ContactInfo(1101, "1011 Best St", "", "Best", "CA", "82346", "US", "17172354896", "", 1101),
                    new ContactInfo(2102, "2021 Main St", "", "Main", "NY", "92347", "US", "18172354897", "", 2102),
                    new ContactInfo(3103, "3031 Good St", "", "Good", "RI", "12348", "US", "19172354898", "", 3103),
                    new ContactInfo(4104, "4041 Good Ln", "", "Good", "MO", "22349", "US", "18272354869", "", 4104),
                    new ContactInfo(5105, "5051 Good Tr", "", "Good", "TN", "23450", "US", "19272354890", "", 5105),

            };
    private static final List<ContactInfo> immutableListOfContactInfos = Arrays.asList(arrayOfContactInfoPayLoad);

    private static final List<ContactInfo> mutableListOfContactInfos = new ArrayList<>();

    static {
        mutableListOfContactInfos.add(new ContactInfo(1001, "1001 Best St", "Suite 300", "Best", "CA", "32341", "US", "12172354891", "12357547963", 1001));
        mutableListOfContactInfos.add(new ContactInfo(2001, "2001 Main St", "", "Main", "NY", "42342", "US", "13172354892", "", 2001));
        mutableListOfContactInfos.add(new ContactInfo(3001, "3001 Good St", "", "Good", "IL", "52343", "US", "14172354893", "", 3001));
        mutableListOfContactInfos.add(new ContactInfo(4001, "4001 Good Ln", "", "Good", "GA", "62344", "US", "15172354894", "", 4001));
        mutableListOfContactInfos.add(new ContactInfo(5001, "5001 Good Tr", "", "Good", "TX", "72345", "US", "16172354895", "", 5001));
        mutableListOfContactInfos.add(new ContactInfo(1101, "1011 Best St", "", "Best", "CA", "82346", "US", "17172354896", "", 1101));
        mutableListOfContactInfos.add(new ContactInfo(2102, "2021 Main St", "", "Main", "NY", "92347", "US", "18172354897", "", 2102));
        mutableListOfContactInfos.add(new ContactInfo(3103, "3031 Good St", "", "Good", "RI", "12348", "US", "19172354898", "", 3103));
        mutableListOfContactInfos.add(new ContactInfo(4104, "4041 Good Ln", "", "Good", "MO", "22349", "US", "18272354869", "", 4104));
        mutableListOfContactInfos.add(new ContactInfo(5105, "5051 Good Tr", "", "Good", "TN", "23450", "US", "19272354890", "", 5105));
    }

    public static ContactInfo[] getArrayOfContactInfoPayLoad() {
        return arrayOfContactInfoPayLoad;
    }

    public static List<ContactInfo> getImmutableListOfContactInfos() {
        return immutableListOfContactInfos;
    }

    public static List<ContactInfo> getMutableListOfContactInfos() {
        return mutableListOfContactInfos;
    }

}
