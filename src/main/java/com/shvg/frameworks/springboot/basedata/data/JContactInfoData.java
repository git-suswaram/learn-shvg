package com.shvg.frameworks.springboot.basedata.data;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JContactInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JContactInfoData {

    private JContactInfoData() {
        throw new IllegalStateException("Utility class");
    }


    private static final JContactInfo[] arrayOfContactInfoPayLoad =
            {
                    new JContactInfo("1001 Best St", "Suite 300", "Best", "CA", "32341", "US", "12172354891", "12357547963", 1001),
                    new JContactInfo("2001 Main St", "", "Main", "NY", "42342", "US", "13172354892", "", 2001),
                    new JContactInfo("3001 Good St", "", "Good", "IL", "52343", "US", "14172354893", "", 3001),
                    new JContactInfo("4001 Good Ln", "", "Good", "GA", "62344", "US", "15172354894", "", 4001),
                    new JContactInfo("5001 Good Tr", "", "Good", "TX", "72345", "US", "16172354895", "", 5001),
                    new JContactInfo("1011 Best St", "", "Best", "CA", "82346", "US", "17172354896", "", 1101),
                    new JContactInfo("2021 Main St", "", "Main", "NY", "92347", "US", "18172354897", "", 2102),
                    new JContactInfo("3031 Good St", "", "Good", "RI", "12348", "US", "19172354898", "", 3103),
                    new JContactInfo("4041 Good Ln", "", "Good", "MO", "22349", "US", "18272354869", "", 4104),
                    new JContactInfo("5051 Good Tr", "", "Good", "TN", "23450", "US", "19272354890", "", 5105),

            };
    private static final List<JContactInfo> immutableListOfContactInfos = Arrays.asList(arrayOfContactInfoPayLoad);

    private static final List<JContactInfo> mutableListOfContactInfos = new ArrayList<>();

    static {
        mutableListOfContactInfos.add(new JContactInfo("1001 Best St", "Suite 300", "Best", "CA", "32341", "US", "12172354891", "12357547963", 1001));
        mutableListOfContactInfos.add(new JContactInfo("2001 Main St", "", "Main", "NY", "42342", "US", "13172354892", "", 2001));
        mutableListOfContactInfos.add(new JContactInfo("3001 Good St", "", "Good", "IL", "52343", "US", "14172354893", "", 3001));
        mutableListOfContactInfos.add(new JContactInfo("4001 Good Ln", "", "Good", "GA", "62344", "US", "15172354894", "", 4001));
        mutableListOfContactInfos.add(new JContactInfo("5001 Good Tr", "", "Good", "TX", "72345", "US", "16172354895", "", 5001));
        mutableListOfContactInfos.add(new JContactInfo("1011 Best St", "", "Best", "CA", "82346", "US", "17172354896", "", 1101));
        mutableListOfContactInfos.add(new JContactInfo("2021 Main St", "", "Main", "NY", "92347", "US", "18172354897", "", 2102));
        mutableListOfContactInfos.add(new JContactInfo("3031 Good St", "", "Good", "RI", "12348", "US", "19172354898", "", 3103));
        mutableListOfContactInfos.add(new JContactInfo("4041 Good Ln", "", "Good", "MO", "22349", "US", "18272354869", "", 4104));
        mutableListOfContactInfos.add(new JContactInfo("5051 Good Tr", "", "Good", "TN", "23450", "US", "19272354890", "", 5105));
    }

    public static JContactInfo[] getArrayOfContactInfoPayLoad() {
        return arrayOfContactInfoPayLoad;
    }

    public static List<JContactInfo> getImmutableListOfContactInfos() {
        return immutableListOfContactInfos;
    }

    public static List<JContactInfo> getMutableListOfContactInfos() {
        return mutableListOfContactInfos;
    }

}
