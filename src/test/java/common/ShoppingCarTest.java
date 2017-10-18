package common;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ShoppingCarTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = saveGoodsToCart();
//            String result = listGoodsFromCart();
//            String result = updateGoodsInCart();
            String result = removeGoodsFromCart();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String updateGoodsInCart() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_updateGoodsInCart" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("goodsId", "f0c3df5bdb0a45aabf22464bb27dbb88");
        params.put("goodsNum", "15");
        params.put("standardId", "4e3007c4db5d483bb9245743fa5c08eb");

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

    private static String removeGoodsFromCart() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_removeGoodsFromCart" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("goodsId", "f0c3df5bdb0a45aabf22464bb27dbb88");
        params.put("standardId", "4e3007c4db5d483bb9245743fa5c08eb");

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

    private static String saveGoodsToCart() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_saveGoodsToCart" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("goodsId", "f0c3df5bdb0a45aabf22464bb27dbb88");
        params.put("goodsNum", "10");
        params.put("standardId", "4e3007c4db5d483bb9245743fa5c08eb");

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

    private static String listGoodsFromCart() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_listGoodsFromCart" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "d88e28c3a0e6429f9f1d03ad99fabc61");
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
}
