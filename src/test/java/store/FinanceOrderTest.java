package store;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FinanceOrderTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = listFinanceOrderSelective();
//            String result = listFinanceOrderByKeyword();
            String result = getFinanceOrder();
//            String result = updateFinancePass();
//            String result = updateFinanceFail();
//            String result = updateRefundMoney();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String listFinanceOrderByKeyword() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listFinanceOrderByKeyword" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("keyword", "70126108");
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

    private static String updateRefundMoney() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateRefundMoney" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
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

    private static String updateFinanceFail() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateFinanceFail" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderId", "86ecddac993a4220961f805ac6c0d26c");

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

    private static String updateFinancePass() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateFinancePass" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
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

    private static String listFinanceOrderSelective() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listFinanceOrderSelective" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("departmentId", "dc89587b44ff4652b44f81da12589175");
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

    private static String getFinanceOrder() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/getFinanceOrder" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("memberId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("orderId", "86ecddac993a4220961f805ac6c0d26c");
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
