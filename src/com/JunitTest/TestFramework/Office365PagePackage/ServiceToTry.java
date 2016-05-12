package com.JunitTest.TestFramework.Office365PagePackage;

public enum ServiceToTry {
    GetMessages("messages", 0),
    GetEvents("events", 1),
    GetContacts("contacts", 2),
    GetFiles("GetFiles", 3),
    GetUsers("GetUsers", 4),
    GetGroups("GetGroups", 5);

    private String description;
    private int index;

    // 构造方法
    private ServiceToTry(String description, int index) {
        this.description = description;
        this.index = index;
    }

    public static String getDescription(ServiceToTry service) {
        for (ServiceToTry c : ServiceToTry.values()) {
            if (c.equals(service)) {
                return c.description;
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }
}
