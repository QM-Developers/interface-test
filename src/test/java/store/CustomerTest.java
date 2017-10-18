package store;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class CustomerTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = saveCustomerRecord();
//            String result = listCustomer();
//            String result = updateCustomer();
//            String result = getCustomer();
//            saveFrontImage();
//            saveBackImage();
//            saveHandImage();
            getCustomerIDCard();

//            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String saveCustomerRecord() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/saveCustomerRecord" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("userName", "jackson");
        params.put("userPhone", "13598765678");
        params.put("userAddress", "鹤山市");
        params.put("userSex", "男");
        params.put("customerType", "personal");
//        params.put("businessAddress", "10001");
//        params.put("station", "10001");

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

    private static String listCustomer() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listCustomer" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("pageNum", "1");
        params.put("pageSize", "10");
//        params.put("customerType", "鹤山市");

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

    private static String updateCustomer() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateCustomer" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
        params.put("userName", "alisa");
        params.put("userSex", "女");

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

    private static String getCustomer() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/getCustomer" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");

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

    private static void saveBackImage() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/saveBackImage" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\wallhaven-513297.jpg");

        JSONObject params = new JSONObject();
        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
        params.put("img", "图片");

        System.out.println(params.toJSONString());
        params.remove("img");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String key : params.keySet())
            builder.addFormDataPart(key, params.get(key).toString());

        builder.addFormDataPart("img", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
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

    private static void saveHandImage() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/saveHandImage" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\wallhaven-513297.jpg");

        JSONObject params = new JSONObject();
        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
        params.put("img", "图片");

        System.out.println(params.toJSONString());
        params.remove("img");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String key : params.keySet())
            builder.addFormDataPart(key, params.get(key).toString());

        builder.addFormDataPart("img", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
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

    private static void getCustomerIDCard() throws IOException
    {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = CoreConstant.URL_BASE_LOCAL + "/s/getCustomerIDCard" + CoreConstant.URL_SUFFIX + "?" +
                "userId=d88e28c3a0e6429f9f1d03ad99fabc61&token=" + IDGenerator.generator() + "&myTeamId=10001&" +
                "path=/WEB-INF/upload/img/id_card/d88e28c3a0e6429f9f1d03ad99fabc61/07308795030843e88749b0a31932a543.jpg";

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
            }

            @Override
            public void onResponse(Call call, Response response)
            {
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream = null;
                try
                {
                    fileOutputStream = new FileOutputStream(new File("D:\\wangshu.jpg"));
                    byte[] buffer = new byte[2048];
                    int len = 0;
                    while ((len = inputStream.read(buffer)) != -1)
                    {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    fileOutputStream.flush();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
