package common;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.CryptographyUtil;
import util.IDGenerator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterTest
{
    public static void main(String[] args)
    {
        insertCardFront();
//        try
//        {
//            String result = registerGetVerify();
//            String result = registerVerify();
//            String result = register();
//
//
//            System.out.println(result);
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
    }

    private static String registerGetVerify() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/registerGetVerify" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userPhone", "13688888888");
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

    private static String registerVerify() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/registerVerify" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userPhone", "13688888888");
        params.put("myTeamId", "10001");
        params.put("verify", "10001");

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

    private static String register() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/register" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
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

    private static void insertCardFront()
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/insertCardFront" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\wallhaven-513297.jpg");

        JSONObject params = new JSONObject();
        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("cardFront", "图片");

        System.out.println(params.toJSONString());
        params.remove("cardFront");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String key : params.keySet())
            builder.addFormDataPart(key, params.get(key).toString());

        builder.addFormDataPart("cardFront", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                System.out.println(response.body().string());
            }
        });
    }
}
