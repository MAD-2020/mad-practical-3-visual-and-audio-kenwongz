package sg.edu.np.mad.week3;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.baby_laughing);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100, 100);
        mediaPlayer.start();
        Toast.makeText(MainActivity.this, "Playing Music", Toast.LENGTH_SHORT).show();
        mediaPlayer.release();
        mediaPlayer = null;


        final VideoView view = findViewById(R.id.videoView);
        view.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rabbid));
        view.start();
        view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Playback Completed", Toast.LENGTH_SHORT).show();
                view.seekTo(3);
            }
        });

        //For the pause and play button
//        MediaController controller = new MediaController(this);
//        controller.setMediaPlayer(view);
//        view.setMediaController(controller);
    }
}
