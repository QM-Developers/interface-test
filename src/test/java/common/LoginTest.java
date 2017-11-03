package common;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.CryptographyUtil;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest
{
    public static void main(String[] args)
    {
        try
        {
            String result = login();
//            String result = loginOnBrowser();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String loginOnBrowser() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/login_on_browser" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userPhone", "13311112222");
        params.put("userPassword", CryptographyUtil.md5("dggadmin", null));
        params.put("myTeamId", "10001");

        System.out.println(params.toJSONString());

        FormBody.Builder builder = new FormBody.Builder();

        for (String key : params.keySet())
            builder.add(key, params.get(key).toString());

        Request request = new Request.Builder().post(builder.build()).url(url).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful())
            return response.body().string();
        else
            return String.valueOf(response.code());
    }

    private static String login() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/login" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userPhone", "13598765678");
        params.put("userPassword", CryptographyUtil.md5("dggadmin", null));
        params.put("myTeamId", "10001");
        params.put("deviceToken", IDGenerator.generator());

        System.out.println(params.toJSONString());

        FormBody.Builder builder = new FormBody.Builder();

        for (String key : params.keySet())
            builder.add(key, params.get(key).toString());

        Request request = new Request.Builder().post(builder.build()).url(url).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful())
            return response.body().string();
        else
            return String.valueOf(response.code());
    }
}
