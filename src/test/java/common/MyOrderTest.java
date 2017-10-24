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
            String result = listMyOrderSelective();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String listMyOrderSelective() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_listMyOrderSelective" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("orderStatus", "41");
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
        goods1.put("goodsId","bae0a50f935248cfa03a0e0cbffd2dda");
        goods1.put("goodsNum","5");
        goods1.put("standardId","8e6aabae569e44ca80db3115372aa1a4");
        jArr.add(goods1);

        params.put("userId", "0bb4b24df33948cfb68e61c1d5c1c75d");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("freight", "1");
        params.put("paymentType", "10");
        params.put("userAddress", "133");
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
