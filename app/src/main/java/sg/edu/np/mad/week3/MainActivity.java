package sg.edu.np.mad.week3;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private static final String video = "rabbid";
    private VideoView videoview;

    private Uri getMedia(String medianame)
    {
        return Uri.parse("android.resource://" + getPackageName() + "/raw/" + medianame);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoview = findViewById(R.id.videoView);

//        For the pause and play button
//        MediaController controller = new MediaController(this);
//        controller.setMediaPlayer(videoview);
//        videoview.setMediaController(controller);
    }

    private void initializePlayer()
    {
        Uri videouri = getMedia(video);
        videoview.setVideoURI(videouri);
        videoview.start();

        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Playback Complpeted", Toast.LENGTH_SHORT).show();
                videoview.seekTo(3);
            }
        });
    }

    private void releasePlayer()
    {
        videoview.stopPlayback();
    }

    @Override
    protected void onStart(){
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        releasePlayer();
    }


}
