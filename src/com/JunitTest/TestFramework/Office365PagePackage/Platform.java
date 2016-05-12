package com.JunitTest.TestFramework.Office365PagePackage;

public enum Platform {
    Android("Android"),
    DotNET("ASP.NET MVC"),
    iOS("iOS"),
    Node("Node.js"),
    PHP("PHP"),
    Python("Python"),
    Ruby("Ruby"),
    Angular("Angular"),
    WindowsUniversal("Universal Windows Platform");

    private String description;

    // 构造方法
    private Platform(String description) {
        this.description = description;
    }

    public static String getDescription(Platform platform) {
        for (Platform c : Platform.values()) {
            if (c.equals(platform)) {
                return c.description;
            }
        }
        return null;
    }

}
