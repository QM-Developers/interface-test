package rewrite;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadImageCallback implements Callback
{
    private String url;

    public ReadImageCallback(String url)
    {
        this.url = url;
    }

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
            fileOutputStream = new FileOutputStream(new File(url));
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
        } finally
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
}
