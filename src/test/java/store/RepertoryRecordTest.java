package store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RepertoryRecordTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = listRepertoryRecord();
//            String result = updateRepertory();
//            String result = getRepertoryRecord();
            String result = listCurrentRepertoryRecord();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String listCurrentRepertoryRecord() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listCurrentRepertoryRecord" + CoreConstant.URL_SUFFIX;
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

    private static String getRepertoryRecord() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/getRepertoryRecord" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("recordId", "8cc618af34f24beaa2bcfd28a1862460");

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

    private static String updateRepertory() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateRepertory" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        JSONArray jArr = new JSONArray();
        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();

        json1.put("goodsId","f0c3df5bdb0a45aabf22464bb27dbb88");
        json1.put("goodsName","【畅消】4%中猪预混料 长势快 后劲强 适用于30~60KG");
        json1.put("standardId","4e3007c4db5d483bb9245743fa5c08eb");
        json1.put("standardName","10kg/袋");
        json1.put("standardCount","1000");
        json1.put("recordType","1");
        json1.put("recordReason","正常处理");

        json2.put("goodsId","f0c3df5bdb0a45aabf22464bb27dbb88");
        json2.put("goodsName","【畅消】4%中猪预混料 长势快 后劲强 适用于30~60KG");
        json2.put("standardId","e0841a5ee98a410c9f1fe4a786a6d6f0");
        json2.put("standardName","20kg/袋");
        json2.put("standardCount","2000");
        json2.put("recordType","1");
        json2.put("recordReason","正常处理");

        jArr.add(json1);
        jArr.add(json2);

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("branchId", "9e8d946ef94b4795bd9218795354e631");
        params.put("branchName", "总经办");
        params.put("recordRemark", "");
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

    private static String listRepertoryRecord() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listRepertoryRecord" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("branchId", "9e8d946ef94b4795bd9218795354e631");
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
