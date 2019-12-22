package tw.org.iii.appps.p_fragment_recycleview_adpadter;
//目的:在Main加入tab,裡面內容物用ViewPager去裝Fragemnt做到滑動頁面
//1.加入api
//2.main.xml布局
//3.創建三個Fragemtn
//4.寫一個自訂的繼承FragmentPagerAdapter,名字叫ViewPagerAdapter

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import tw.org.iii.appps.p_fragment_recycleview_adpadter.Adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter fragmentPagerAdapter; //自己寫的繼承FragmentPagerAdapter,名字叫ViewPagerAdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.init
        tableLayout = findViewById(R.id.table_layout_id);
        viewPager =findViewById(R.id.viewpager_id);
        fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        //ViewPager.setAdapter(PagerAdapter adapter) ://ViewPager.設定條便器
        //com.google.android.material.tabs.setupWithViewPager(ViewPager viewPager) //Tablelayout.設定要裝的ViewPager
        //TabLayout.Tab.getTabAt(int index)://抓取tab位置(int位置)(回傳TabLayout.Tab)
        //TabLayout.Tab.setIcon(@Nullable Drawable icon)://設定圖案(回傳TabLayout.Tab)
        //2.將Fragment用條便器加入
        fragmentPagerAdapter.addFragment(new CallFragment(),"Call");//新增Fragemnt跟title進去
        fragmentPagerAdapter.addFragment(new ContactFragment(),"Contact");
        fragmentPagerAdapter.addFragment(new FavFragment(),"Far");
        viewPager.setAdapter(fragmentPagerAdapter);//設定條便器
        tableLayout.setupWithViewPager(viewPager);//Tablelayout.設定要裝的ViewPager

        tableLayout.getTabAt(0).setIcon(R.drawable.ic_call_black_24dp);
        tableLayout.getTabAt(1).setIcon(R.drawable.ic_group_add_black_24dp);
        tableLayout.getTabAt(2).setIcon(R.drawable.ic_star_black_24dp);



    }
}
