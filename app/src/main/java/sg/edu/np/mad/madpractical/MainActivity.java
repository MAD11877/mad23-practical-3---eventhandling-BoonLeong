package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.leongsapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button followButton = (Button) findViewById(R.id.btnFollow);
        TextView userName = (TextView) findViewById(R.id.userName);
        TextView userDesc = (TextView) findViewById(R.id.userDesc);

        User testUser = new User("Hello World!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                0,
                false);

        String name = testUser.getName();
        String description = testUser.getDescription();

        userName.setText(name);
        userDesc.setText(description);

        if (testUser.isFollowed()) {
            followButton.setText(R.string.button_text_unfollow);
        }
        else {
            followButton.setText(R.string.button_text_follow);
        }

        followButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testUser.changeFollowStatus();
                if (testUser.isFollowed()) {
                    followButton.setText(R.string.button_text_unfollow);
                }
                else {
                    followButton.setText(R.string.button_text_follow);
                }
            }
        });
    }
}