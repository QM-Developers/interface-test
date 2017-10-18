package common;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExperienceTest
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(registerExperience());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String registerExperience() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/registerExperience" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("company", "青麦科技");
        params.put("contacts", "张三");
        params.put("phone", "13688888888");
        params.put("position", "经理");

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
