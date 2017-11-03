package common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyOrderTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = saveMyOrder();
//            String result = listMyOrderSelective();
//            String result = updateSign();
//            String result = listFreightTemp();
//            String result = updateRefund();
//            String result = updateRefundCancel();
            String result = getMyOrder();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String updateRefundCancel() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_updateRefundCancel" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
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

    private static String getMyOrder() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_getMyOrder" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
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

    private static String updateRefund() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_updateRefund" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        JSONArray jArr = new JSONArray();
        JSONObject obj1 = new JSONObject();
        obj1.put("standardId","8e6aabae569e44ca80db3115372aa1a4");
        obj1.put("goodsNum","5");
        jArr.add(obj1);

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("orderId", "1ee46bbd9f9b4462b2256aac46f0d3e1");
        params.put("refundMessage", "不想买了");
        params.put("goods", jArr.toJSONString());

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

    private static String listFreightTemp() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_listFreightTemp" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
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

    private static String updateSign() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_updateSign" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
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

    private static String listMyOrderSelective() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_listMyOrderSelective" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
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

    private static String saveMyOrder() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_saveMyOrder" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        JSONArray jArr = new JSONArray();
        JSONObject goods1 = new JSONObject();
        JSONObject address = new JSONObject();
        address.put("contact","name");
        address.put("address","地址");
        address.put("phone","电话");

        goods1.put("goodsId","bae0a50f935248cfa03a0e0cbffd2dda");
        goods1.put("goodsNum","5");
        goods1.put("standardId","8e6aabae569e44ca80db3115372aa1a4");
        jArr.add(goods1);

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("freight", "1");
        params.put("paymentType", "20");
        params.put("shoppingAddress", address);
        params.put("buyerMessage", "12112");
        params.put("goods", jArr.toJSONString());

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
