package util;


import java.util.UUID;

public class IDGenerator
{
    public static final String generator()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
