package common;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PermissionModelTest
{
    public static void main(String[] args)
    {
        try
        {
            String result = listPermissionModel();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String listPermissionModel() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_listPermissionModel" + CoreConstant.URL_SUFFIX;
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
}
