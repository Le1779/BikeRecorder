package le1779.bikerecorder.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import le1779.bikerecorder.R;

public class MainActivity extends AppCompatActivity {

    Button button_goto_drawer_type, button_goto_bottom_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_goto_drawer_type = findViewById(R.id.button_goto_drawer_type);
        button_goto_drawer_type.setOnClickListener(onClickListener);
        button_goto_bottom_type = findViewById(R.id.button_goto_bottom_type);
        button_goto_bottom_type.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button_goto_drawer_type:
                    startActivity(new Intent(MainActivity.this, DrawerTypeActivity.class));
                    finish();
                    break;
                case R.id.button_goto_bottom_type:
                    startActivity(new Intent(MainActivity.this, BottomTypeActivity.class));
                    finish();
                    break;
            }
        }
    };
}
