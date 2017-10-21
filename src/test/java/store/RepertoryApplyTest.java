package store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RepertoryApplyTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = getRepertoryApply();
//            String result = listRepertoryApplyByProposer();
//            String result = listRepertoryApply();
//            String result = saveRepertoryApply();
//            String result = listRepertoryApplyByApprover();
//            String result = listRepertoryChecker();
//            String result = updateRepertoryApplyAccept();
            String result = updateRepertoryApplyFinish();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String updateRepertoryApplyFinish() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateRepertoryApplyFinish" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("applyId", "6f2688117af64bff81edd3994314c225");

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

    private static String updateRepertoryApplyAccept() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateRepertoryApplyAccept" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "5a27d0f892cd48a482622f8b76fd239c");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("applyId", "6f2688117af64bff81edd3994314c225");

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

    private static String listRepertoryChecker() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listRepertoryChecker" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "5a27d0f892cd48a482622f8b76fd239c");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");

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

    private static String listRepertoryApplyByApprover() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listRepertoryApplyByApprover" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "5a27d0f892cd48a482622f8b76fd239c");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("pageNum", "1");
        params.put("pageSize", "10");
        params.put("createDate", "2017-1-1");
        params.put("finishDate", "2017-12-12");

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

    private static String saveRepertoryApply() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/saveRepertoryApply" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject jo1 = new JSONObject();

        jo1.put("goodsId", "bae0a50f935248cfa03a0e0cbffd2dda");
        jo1.put("goodsName", "【哼哼动保】10%酸化阿莫西林可溶性粉 100g/袋");
        jo1.put("standardId", "8e6aabae569e44ca80db3115372aa1a4");
        jo1.put("standardName", "100g/袋");
        jo1.put("standardCount", "10");
        jsonArray.add(jo1);

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("branchId", "0f3965187f1d4bbf963453b7a2ae0b20");
        params.put("branchName", "鹤山销售点");
        params.put("proposerId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("proposerName", "李思思");
        params.put("approverId", "5a27d0f892cd48a482622f8b76fd239c");
        params.put("approverName", "王舞欣");
        params.put("applyRemark", "备注");
        params.put("goodsInfo", jsonArray.toJSONString());

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

    private static String listRepertoryApply() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listRepertoryApply" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("pageNum", "1");
        params.put("pageSize", "10");
        params.put("createDate", "2017-1-1");
        params.put("finishDate", "2017-12-12");

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

    private static String listRepertoryApplyByProposer() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listRepertoryApplyByProposer" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
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

    private static String getRepertoryApply() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/getRepertoryApply" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("applyId", "dac29c84ff574042add0305a2ce1e1ef");

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
