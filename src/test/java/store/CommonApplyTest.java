package store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonApplyTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = findDepartmentList();
//            String result = findMemberList();
//            String result = saveCommonApply();
//            String result = saveCommonApplyImage();
//            String result = listCommonApplyByProposer();
//            String result = listCommonApplyByApprove();
//            String result = updateCommonApplyAccept();
            String result = updateCommonApplyRefuse();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String updateCommonApplyRefuse() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateCommonApplyRefuse" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("applyId", "223b5684a88c4875a69291f38a3e3fa1");
        params.put("approveAdvice", "建议");
        params.put("approveSequence", "2");

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

    private static String listCommonApplyByApprove() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listCommonApplyByApprove" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
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

    private static String updateCommonApplyAccept() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/updateCommonApplyAccept" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "5a27d0f892cd48a482622f8b76fd239c");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("applyId", "223b5684a88c4875a69291f38a3e3fa1");
        params.put("approveAdvice", "意见");
        params.put("approveSequence", "1");

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

    private static String listCommonApplyByProposer() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/listCommonApplyByProposer" + CoreConstant.URL_SUFFIX;
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

    private static String saveCommonApplyImage() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/saveCommonApplyImage" + CoreConstant.URL_SUFFIX;
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

    private static String saveCommonApply() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/saveCommonApply" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        JSONArray approve = new JSONArray();
        JSONArray img = new JSONArray();
        JSONObject app1 = new JSONObject();
        JSONObject app2 = new JSONObject();
        JSONObject img1 = new JSONObject();

        app1.put("approveId","5a27d0f892cd48a482622f8b76fd239c");
        app1.put("approveName","王舞欣");
        app1.put("approveSequence","1");
        app2.put("approveId","9f6bc79d769342f1b90ed0b532b870f2");
        app2.put("approveName","李思思");
        app2.put("approveSequence","2");
        img1.put("imageId","a3ad0592c5324e2b8f9fe46aa8047f31");
        approve.add(app1);
        approve.add(app2);
        img.add(img1);

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("applyTitle", "1");
        params.put("beginDate", "1");
        params.put("endDate", "1");
        params.put("applyReason", "1");
        params.put("commonApplyApprove", approve.toJSONString());
        params.put("commonApplyImage", img.toJSONString());

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

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
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

    private static String findDepartmentList() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/s/findDepartmentList" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
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
}
