package common;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoodsBrowseTest
{
    public static void main(String[] args)
    {
        try
        {
            String result = findGoodsType();
//            String result = findGoodsList();
//            String result = findGoodsDetail();
//            String result = findGoodsByKeyword();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String findGoodsByKeyword() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_findGoodsByKeyword" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("keyword", "畅消");
        params.put("orderBy", "goodsSales");
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

    private static String findGoodsType() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_findGoodsType" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("goodsTypePid", "0b49ef854bb74ff9b9317132dba053d7");

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

    private static String findGoodsList() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_findGoodsList" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("goodsTypeId", "0b49ef854bb74ff9b9317132dba053d7");
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

    private static String findGoodsDetail() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_findGoodsDetail" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("goodsId", "f0c3df5bdb0a45aabf22464bb27dbb88");

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
