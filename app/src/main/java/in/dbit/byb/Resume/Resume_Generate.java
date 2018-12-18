package in.dbit.byb.Resume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import in.dbit.byb.R;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class Resume_Generate extends AppCompatActivity {
    private Socket mSocket;
    private Emitter.Listener onGenerated = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String url;
                    try {
                        url = data.getString("generated");
                        Toast.makeText(Resume_Generate.this, "Resume URL: " + url,
                                Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        return;
                    }

                }
            });
        }
    };

    {
        try {
            mSocket = IO.socket("http://192.168.31.230:3000");
        } catch (URISyntaxException e) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_generate);
        mSocket.on("generated", onGenerated);
        mSocket.connect();

        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("resumeJSON", "test");
            mSocket.emit("generate", jsonObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSocket.disconnect();
        mSocket.off("generate", onGenerated);
    }
}
