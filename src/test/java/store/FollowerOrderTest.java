package store;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FollowerOrderTest
{
    private static final String BASE_URL = CoreConstant.URL_BASE_LOCAL;

    public static void main(String[] args)
    {
        try
        {
//            String result = listSalesOrderSelective();
//            String result = listSalesOrderByKeyword();
            String result = getSalesOrder();
//            String result = updateSalesmanPass();
//            String result = updateDelivered();
//            String result = updateRefundPass();
//            String result = updateRefundReceive();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String getSalesOrder() throws IOException
    {
        String url = BASE_URL + "/s/getSalesOrder" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "528832fa9cc54d0290f6ee2922b27256");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderId", "86ecddac993a4220961f805ac6c0d26c");
        params.put("memberId", "0bb4b24df33948cfb68e61c1d5c1c75d");

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

    private static String listSalesOrderByKeyword() throws IOException
    {
        String url = BASE_URL + "/s/listSalesOrderByKeyword" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "528832fa9cc54d0290f6ee2922b27256");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("pageNum", "1");
        params.put("pageSize", "10");
        params.put("keyword", "69741360");

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

    private static String updateRefundReceive() throws IOException
    {
        String url = BASE_URL + "/s/updateRefundReceive" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderId", "1ee46bbd9f9b4462b2256aac46f0d3e1");

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

    private static String updateRefundPass() throws IOException
    {
        String url = BASE_URL + "/s/updateRefundPass" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderId", "1ee46bbd9f9b4462b2256aac46f0d3e1");

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

    private static String updateDelivered() throws IOException
    {
        String url = BASE_URL + "/s/updateDelivered" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderId", "1ee46bbd9f9b4462b2256aac46f0d3e1");

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

    private static String updateSalesmanPass() throws IOException
    {
        String url = BASE_URL + "/s/updateSalesmanPass" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderId", "1ee46bbd9f9b4462b2256aac46f0d3e1");

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

    private static String listSalesOrderSelective() throws IOException
    {
        String url = BASE_URL + "/s/listSalesOrderSelective" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "528832fa9cc54d0290f6ee2922b27256");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderStatus", "92");
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
