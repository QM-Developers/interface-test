package common;

import com.alibaba.fastjson.JSONObject;
import constant.CoreConstant;
import okhttp3.*;
import util.IDGenerator;
import util.RequestUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class MyOrderProofTest
{
    public static void main(String[] args)
    {
        try
        {
//            String result = saveOrderProof();
            String result = removeOrderProof();
//            String result = listOrderProof();
//            getProofImage();

            System.out.println(result);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String removeOrderProof() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_removeOrderProof" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("proofId", "9f2a3f850d17408fa82884678e13bb12");

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

    private static void getProofImage() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_getProofImage" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();
        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("proofUrl", "/upload/img/user/order_proof/9f6bc79d769342f1b90ed0b532b870f2/359bb432377840cd9556b17bbe4724ef.jpg");

        url = RequestUtil.getUrlWithParams(url,params);
        System.out.println(url);

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
            }

            @Override
            public void onResponse(Call call, Response response)
            {
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream = null;
                try
                {
                    fileOutputStream = new FileOutputStream(new File("C:\\1.jpg"));
                    byte[] buffer = new byte[2048];
                    int len = 0;
                    while ((len = inputStream.read(buffer)) != -1)
                    {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    fileOutputStream.flush();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }finally
                {
                    if (fileOutputStream != null)
                        try
                        {
                            fileOutputStream.close();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                }
            }
        });
    }

    private static String listOrderProof() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_listOrderProof" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).build();

        JSONObject params = new JSONObject();

        params.put("userId", "89d9317fb3834353bcf2a507bee2eb82");
        params.put("myTeamId", "10001");
        params.put("token", "1");
        params.put("orderId", "580e6b11712d481ba38b307bf47b6966");

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

    private static String saveOrderProof() throws IOException
    {
        String url = CoreConstant.URL_BASE_LOCAL + "/user_saveOrderProof" + CoreConstant.URL_SUFFIX;
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\wallhaven-513297.jpg");

        JSONObject params = new JSONObject();
        params.put("userId", "9f6bc79d769342f1b90ed0b532b870f2");
        params.put("token", IDGenerator.generator());
        params.put("myTeamId", "10001");
        params.put("orderId", "40649b0e97864417915fcc8cadcd331f");
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
}
