package store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RepertoryIncomeTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = saveRepertoryIncome();
//            String result = listCurrentRepertoryIncome();
//            String result = listRepertoryIncome();
            String result = getRepertoryIncome();
//            String result = listRepertoryApply();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String listRepertoryApply() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listRepertoryApply" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
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

    private static String getRepertoryIncome() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/getRepertoryIncome" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("recordId", "d99e5e828ef142a39feda16a724c3119");

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

    private static String listRepertoryIncome() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listRepertoryIncome" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("branchId", "0f8ad87fcb564f358d287c39749362d4");
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

    private static String listCurrentRepertoryIncome() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listCurrentRepertoryIncome" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
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

    private static String saveRepertoryIncome() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/saveRepertoryIncome" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONArray jArr = new JSONArray();
        JSONObject json1 = new JSONObject();

        json1.put("goodsId", "bae0a50f935248cfa03a0e0cbffd2dda");
        json1.put("goodsName", "【哼哼动保】10%酸化阿莫西林可溶性粉 100g/袋");
        json1.put("standardId", "8e6aabae569e44ca80db3115372aa1a4");
        json1.put("standardName", "100g/袋");
        json1.put("standardCount", "256");

        jArr.add(json1);

        JSONObject params = new JSONObject();

        params.put("userId", "5a27d0f892cd48a482622f8b76fd239c");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("branchId", "0f8ad87fcb564f358d287c39749362d4");
        params.put("branchName", "总经办");
        params.put("applyRemark", "1");
        params.put("goodsInfo", jArr.toJSONString());

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
