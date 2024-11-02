package ntu.nlqh.midtermtestrun;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        TextView youtubeText = findViewById(R.id.youtubeText);
        TextView facebookText = findViewById(R.id.facebookText);
        TextView twitterText = findViewById(R.id.twitterText);

        youtubeText.setOnClickListener(v -> openLink("https://www.youtube.com"));
        facebookText.setOnClickListener(v -> openLink("https://www.facebook.com"));
        twitterText.setOnClickListener(v -> openLink("https://twitter.com"));
    }

    private void openLink(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    public void Return(View v) {
        Intent iMainActivity = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(iMainActivity);
    }
}
