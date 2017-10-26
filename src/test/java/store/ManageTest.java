package store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.CryptographyUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ManageTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = login();
//            String result = findTeamAndMemberCount();
//            String result = findDepartmentList();
//            String result = findMemberList();
//            String result = findDepartmentInfo();
//            String result = findMemberInfo();
            String result = addDepartment();
//            String result = listQmPermission();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String listQmPermission() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listQmPermission" + CoreConstant.URL_SUFFIX;
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

    private static String addDepartment() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/addDepartment" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        JSONArray position = new JSONArray();
        JSONArray permission = new JSONArray();
        JSONObject pos1 = new JSONObject();
        JSONObject per1 = new JSONObject();

        pos1.put("positionName", "测试主任");
        per1.put("permissionId", "a9f8a72b6b8548049569d81db3a56c36");

        permission.add(per1);
        pos1.put("permission", permission.toJSONString());
        position.add(pos1);


        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("departmentName", "测试部");
        params.put("createDate", "2017-12-12");
        params.put("position", position.toJSONString());

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

    private static String findMemberInfo() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findMemberInfo" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("memberId", "9f6bc79d769342f1b90ed0b532b870f2");

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

    private static String findDepartmentInfo() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findDepartmentInfo" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("departmentId", "4bc0ec2d68a444e7a584b9f8d03cbc44");

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

    private static String findMemberList() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findMemberList" + CoreConstant.URL_SUFFIX;
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

    private static String findDepartmentList() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findDepartmentList" + CoreConstant.URL_SUFFIX;
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

    private static String findTeamAndMemberCount() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findTeamAndMemberCount" + CoreConstant.URL_SUFFIX;
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

    private static String login() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/login" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("userPassword", CryptographyUtil.md5("dggadmin"));

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
