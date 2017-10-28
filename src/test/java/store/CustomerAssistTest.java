package store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CustomerAssistTest
{
    private static String BASE_URL = CoreConstant.URL_BASE_LOCAL;
    
    public static void main(String[] args)
    {
        try
        {
//            String result = saveCustomerAssist();
//            String result = saveAssistImage();
            String result = listCustomerAssistByProposer();
//            String result = updateCustomerAssistResult();
//            String result = listCustomerAssistByHelper();
//            String result = getCustomerAssist();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String getCustomerAssist() throws IOException
    {
        String url = BASE_URL + "/s/getCustomerAssist" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("assistId", "ec763147d35c4ab285fbcba67ca57a30");

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

    private static String listCustomerAssistByHelper() throws IOException
    {
        String url = BASE_URL + "/s/listCustomerAssistByHelper" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "03ef5797bae2466699d5efc970a8962f");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("pageNum", "1");
        params.put("pageSize", "10");
        params.put("status", "1");

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

    private static String updateCustomerAssistResult() throws IOException
    {
        String url = BASE_URL + "/s/updateCustomerAssistResult" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("assistId", "ec763147d35c4ab285fbcba67ca57a30");
        params.put("assistResult", "122130");

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

    private static String listCustomerAssistByProposer() throws IOException
    {
        String url = BASE_URL + "/s/listCustomerAssistByProposer" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
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

    private static String saveAssistImage() throws IOException
    {
        String url = BASE_URL + "/s/saveAssistImage" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\wallhaven-513297.jpg");

        JSONObject params = new JSONObject();
        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("img", "图片");

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

    private static String saveCustomerAssist() throws IOException
    {
        String url = BASE_URL + "/s/saveCustomerAssist" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();
        JSONArray customer = new JSONArray();
        JSONArray user = new JSONArray();
        JSONArray image = new JSONArray();
        JSONObject c1 = new JSONObject();
        JSONObject u1 = new JSONObject();
        JSONObject i1 = new JSONObject();

        u1.put("userId","0420cb22c06b43a488c39967779eecec");
        u1.put("userName","王五");
        u1.put("departmentName","departmentName");
        user.add(u1);

        c1.put("customerId","94a397ea0eae4632994108c02fe3b762");
        c1.put("customerName","alisa");
        customer.add(c1);

        i1.put("imageId","85bec1897c8e4abcb7faed0e1e3c88d9");
        image.add(i1);

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("assistTitle", "10001");
        params.put("assistReason", "10001");
        params.put("customer", customer);
        params.put("user", user);
        params.put("image", image);

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
