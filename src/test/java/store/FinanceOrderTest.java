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
            String result = updateFinancePass();
//            String result = updateFinanceFail();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String updateFinanceFail() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateFinanceFail" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0420cb22c06b43a488c39967779eecec");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderId", "7538ab258b784300868a111021de674b");

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
        params.put("orderStatus", "90");
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
