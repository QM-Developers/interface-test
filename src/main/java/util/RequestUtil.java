package util;

import java.util.Map;

public class RequestUtil
{
    public static String getUrlWithParams(String url, Map params)
    {
        StringBuilder value = new StringBuilder();
        value.append(url);

        if (!url.endsWith("?"))
            value.append("?");

        for (Object key : params.keySet())
        {
            value.append(key.toString()).append("=");
            value.append(params.get(key)).append("&");
        }

        return value.substring(0, value.length() - 1);
    }
}
