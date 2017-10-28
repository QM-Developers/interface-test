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
    private static String BASE_URL = CoreConstant.URL_BASE_LOCAL;
    
    public static void main(String[] args)
    {
        try
        {
//            String result = saveCustomerRecord();
//            String result = listCustomer();
//            String result = updateCustomer();
//            String result = getCustomer();
//            String result = saveRepertoryLevel();
//            String result = listMerchandiser();
//            String result = listPromoter();
//            String result = updateCustomerToPromoter();
//            String result = updateCustomerToMerchandiser();
//            String result = listAccountChecker();
//            String result = saveCustomerAccount();
//            String result = listCustomerAccountByProposer();
            String result = listCustomerAccountByChecker();
//            String result = getCustomerAccount();
//            String result = updateCustomerAccountRefuse();
//            String result = updateCustomerAccountAccept();
//            String result = updateCustomerFreeze();
//            String result = updateCustomerUnfreeze();
//            String result = listRepertoryLevel();

//            saveFrontImage();
//            saveBackImage();
//            saveHandImage();
//            getCustomerIDCard();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String listRepertoryLevel() throws IOException
    {
        String url = BASE_URL + "/s/listRepertoryLevel" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
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

    private static String getCustomerAccount() throws IOException
    {
        String url = BASE_URL + "/s/getCustomerAccount" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("requestId", "320cd46e93004f12890dba46bf0d2a4d");

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

    private static String updateCustomerUnfreeze() throws IOException
    {
        String url = BASE_URL + "/s/updateCustomerUnfreeze" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
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

    private static String updateCustomerFreeze() throws IOException
    {
        String url = BASE_URL + "/s/updateCustomerFreeze" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
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

    private static String updateCustomerAccountAccept() throws IOException
    {
        String url = BASE_URL + "/s/updateCustomerAccountAccept" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("requestId", "7c2c30d5d1ef49289f10f21de4e1ed5e");

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

    private static String updateCustomerAccountRefuse() throws IOException
    {
        String url = BASE_URL + "/s/updateCustomerAccountRefuse" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("requestId", "320cd46e93004f12890dba46bf0d2a4d");

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

    private static String listCustomerAccountByChecker() throws IOException
    {
        String url = BASE_URL + "/s/listCustomerAccountByChecker" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("requestStatus", "4");
        params.put("pageNum", "1");
        params.put("pageSize", "10");

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

    private static String listCustomerAccountByProposer() throws IOException
    {
        String url = BASE_URL + "/s/listCustomerAccountByProposer" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "03ef5797bae2466699d5efc970a8962f");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("requestStatus", "2");

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

    private static String saveCustomerAccount() throws IOException
    {
        String url = BASE_URL + "/s/saveCustomerAccount" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "03ef5797bae2466699d5efc970a8962f");
        params.put("token", IDGenerator.generator());
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
        params.put("customerName", "alisa");
        params.put("merchandiserId", "5a27d0f892cd48a482622f8b76fd239c");
        params.put("merchandiserName", "王舞欣");
        params.put("checkerId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("checkerName", "李思思");
        params.put("requestReason", "啊");

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

    private static String listAccountChecker() throws IOException
    {
        String url = BASE_URL + "/s/listAccountChecker" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "03ef5797bae2466699d5efc970a8962f");
        params.put("token", IDGenerator.generator());
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

    private static String updateCustomerToMerchandiser() throws IOException
    {
        String url = BASE_URL + "/s/updateCustomerToMerchandiser" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "03ef5797bae2466699d5efc970a8962f");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
        params.put("merchandiserId", "528832fa9cc54d0290f6ee2922b27256");

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

    private static String updateCustomerToPromoter() throws IOException
    {
        String url = BASE_URL + "/s/updateCustomerToPromoter" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "03ef5797bae2466699d5efc970a8962f");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
        params.put("promoterId", "d88e28c3a0e6429f9f1d03ad99fabc61");

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

    private static String listPromoter() throws IOException
    {
        String url = BASE_URL + "/s/listPromoter" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
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

    private static String listMerchandiser() throws IOException
    {
        String url = BASE_URL + "/s/listMerchandiser" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerType", "personal");

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

    private static String saveRepertoryLevel() throws IOException
    {
        String url = BASE_URL + "/s/saveRepertoryLevel" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerType", "personal");
        params.put("repertoryType", "1");

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

    private static String saveCustomerRecord() throws IOException
    {
        String url = BASE_URL + "/s/saveCustomerRecord" + CoreConstant.URL_SUFFIX;
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
        String url = BASE_URL + "/s/listCustomer" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("pageNum", "1");
        params.put("pageSize", "10");
        params.put("customerType", "personal");

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
        String url = BASE_URL + "/s/updateCustomer" + CoreConstant.URL_SUFFIX;
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
        String url = BASE_URL + "/s/getCustomer" + CoreConstant.URL_SUFFIX;
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
        String url = BASE_URL + "/s/saveBackImage" + CoreConstant.URL_SUFFIX;
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
        String url = BASE_URL + "/s/saveHandImage" + CoreConstant.URL_SUFFIX;
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
        String url = BASE_URL + "/s/getCustomerIDCard" + CoreConstant.URL_SUFFIX + "?" +
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
