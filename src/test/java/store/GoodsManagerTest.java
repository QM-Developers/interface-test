package store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoodsManagerTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = findGoodsTypeByPid();
//            String result = findTypeAndParents();
//            String result = findGoodsList();
//            String result = findGoodsListByKeyword();
//            String result = findGoodsInfo();
//            String result = findGoodsDescribe();
//            String result = findImages();
//            String result = uploadToImgSpace();
//            String result = goodsRelease();
//            String result = updateGoods();
            String result = deleteGoods();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String deleteGoods() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/deleteGoods" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("goodsId", "b1d2379b6812430482d78a536441f0b2");

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

    private static String updateGoods() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateGoods" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        JSONArray jArr = new JSONArray();
        JSONObject st1 = new JSONObject();
        st1.put("standardId", "9e5e7bbb97194c6a95aae84e838fba1e");
        st1.put("standardName", "80g/袋");
        st1.put("standardWeight", "60");
        st1.put("standardPrice", "900");
        jArr.add(st1);

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("goodsId", "b1d2379b6812430482d78a536441f0b2");
        params.put("goodsTypeId", "945ecca898284c2187ef6a5475a1363e");
        params.put("goodsName", "【呵呵动保】10%酸化阿莫西林可溶性粉 80g/袋");
        params.put("goodsCode", "R179");
        params.put("goodsAttr", "品牌?呵呵动保|");
        params.put("standards", jArr.toJSONString());

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

    private static String goodsRelease() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/goodsRelease" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        JSONArray jArr = new JSONArray();
        JSONObject st1 = new JSONObject();
        st1.put("standardName", "60g/袋");
        st1.put("standardWeight", "60");
        st1.put("standardPrice", "100");
        jArr.add(st1);

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("goodsTypeId", "945ecca898284c2187ef6a5475a1363e");
        params.put("goodsName", "【呵呵动保】10%酸化阿莫西林可溶性粉 60g/袋");
        params.put("goodsCode", "R178");
        params.put("goodsAttr", "品牌?呵呵|");
        params.put("goodsImages", "eedad265f3624c0eb2c6f9ac890989aa|f0c3df5bdb0a45aabf22464bb27dbb88|");
        params.put("goodsDescribe", "35aa7507390f4ead9d64dc55cc2aa768|ee33de9884e243488d3c3c79da6ac173|");
        params.put("standards", jArr.toJSONString());

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

    private static String uploadToImgSpace() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/uploadToImgSpace" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\wallhaven-513297.jpg");

        JSONObject params = new JSONObject();
        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("img", "图片");

        System.out.println(params.toJSONString());
        params.remove("img");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String key : params.keySet())
            builder.addFormDataPart(key, params.get(key).toString());

        builder.addFormDataPart("img", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder().url(url).post(requestBody).build();

        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    private static String findImages() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findImages" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");

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

    private static String findGoodsDescribe() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findGoodsDescribe" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("goodsDescribe", "4fb2d3accff24ba4a9dec5d2a38e5b25|7bc2d9bfafc744c8a6ecabfb7c6e9ce2|7ea010df01dd4e88847daf5c3e3a5002|cb4e6691e9dc46b980576492cc5567d3|eedad265f3624c0eb2c6f9ac890989aa|");

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

    private static String findGoodsInfo() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findGoodsInfo" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("goodsId", "bae0a50f935248cfa03a0e0cbffd2dda");

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

    private static String findGoodsListByKeyword() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findGoodsListByKeyword" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("goodsName", "哼哼");
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

    private static String findGoodsList() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findGoodsList" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("pageNum", "1");
        params.put("pageSize", "1");

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

    private static String findTypeAndParents() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findTypeAndParents" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("goodsTypeId", "0b49ef854bb74ff9b9317132dba053d7");

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

    private static String findGoodsTypeByPid() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findGoodsTypeByPid" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("goodsTypePid", "2267430251874ea69ea82834c558977a");

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
