package common;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.CryptographyUtil;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PasswordTest
{
    public static void main(String[] args)
    {
        try
        {
//            System.out.println(retrieveGetPasswordVerify());
//            System.out.println(retrievePasswordVerify());
//            System.out.println(updatePassword());
            System.out.println(verifyPassword());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String verifyPassword() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/verifyPassword" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", IDGenerator.generator());
        params.put("userPassword", CryptographyUtil.md5("dgcgadmin", null));

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

    private static String retrieveGetPasswordVerify() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/retrieveGetPasswordVerify" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userPhone", "13597165115");
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

    private static String retrievePasswordVerify() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/retrievePasswordVerify" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userPhone", "13597165115");
        params.put("myTeamId", "10001");
        params.put("verify", "1356");

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

    private static String updatePassword() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/updatePassword" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", IDGenerator.generator());
        params.put("userPassword", CryptographyUtil.md5("dggadmin", null));

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
