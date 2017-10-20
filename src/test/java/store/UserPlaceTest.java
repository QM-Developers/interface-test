package store;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UserPlaceTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = saveUserPlace();
            String result = listUserPlace();
//            String result = updateUserPlace();
//            String result = uploadPlaceEnvironment();
//            String result = uploadPlaceCertificate();
//            String result = getUserPlace();
//            String result = removePlaceImage();
//            String result = removeUserPlace();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String removeUserPlace() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/removeUserPlace" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("userPlaceId", "582c2eecfffc42ac939ad146247c0f3f");

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

    private static String removePlaceImage() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/removePlaceImage" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("imgId", "5c4151870c3b4551a37191b934e2e483");

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

    private static String getUserPlace() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/getUserPlace" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("userPlaceId", "582c2eecfffc42ac939ad146247c0f3f");

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

    private static String uploadPlaceEnvironment() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/uploadPlaceEnvironment" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\wallhaven-513297.jpg");

        JSONObject params = new JSONObject();
        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("img", "图片");
        params.put("userPlaceId", "daab4edac0fa48d5b62f6c241f5dd590");

        System.out.println(params.toJSONString());
        params.remove("img");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String key : params.keySet())
            builder.addFormDataPart(key, params.get(key).toString());

        builder.addFormDataPart("img", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder().url(url).post(requestBody).build();

        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    private static String uploadPlaceCertificate() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/uploadPlaceCertificate" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\wallhaven-513297.jpg");

        JSONObject params = new JSONObject();
        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("img", "图片");
        params.put("userPlaceId", "582c2eecfffc42ac939ad146247c0f3f");

        System.out.println(params.toJSONString());
        params.remove("img");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String key : params.keySet())
            builder.addFormDataPart(key, params.get(key).toString());

        builder.addFormDataPart("img", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder().url(url).post(requestBody).build();

        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    private static String updateUserPlace() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateUserPlace" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("userPlaceId", "582c2eecfffc42ac939ad146247c0f3f");
        params.put("userAlreadyUse", "12");
        params.put("certificate", "ebb4f011d992416d90a54e74c74ef355");

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

    private static String saveUserPlace() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/saveUserPlace" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
        params.put("userPlaceArea", "鹤山");
        params.put("userPlaceAcreage", "142");

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

    private static String listUserPlace() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listUserPlace" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
        params.put("customerId", "94a397ea0eae4632994108c02fe3b762");
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
}
