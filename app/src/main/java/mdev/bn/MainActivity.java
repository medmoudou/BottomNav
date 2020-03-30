package mdev.bn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    FragOne fragOne;
    FragTwo fragTwo;
    FragThree fragThree;
    BottomNavigationView BottomNavigationView;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.container);

        BottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);


        BottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_like:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.nav_share:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.nav_comment:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    BottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                BottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = BottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragOne=new FragOne();
        fragTwo=new FragTwo();
        fragThree=new FragThree();
        adapter.addFragment(fragOne);
        adapter.addFragment(fragTwo);
        adapter.addFragment(fragThree);
        viewPager.setAdapter(adapter);
    }


}
