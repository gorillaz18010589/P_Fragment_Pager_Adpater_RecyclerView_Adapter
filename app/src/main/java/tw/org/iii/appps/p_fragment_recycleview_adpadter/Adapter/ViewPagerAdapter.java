package tw.org.iii.appps.p_fragment_recycleview_adpadter.Adapter;
//是Viewpager的一種Adpater
//1.繼承FragmentPagerAdapter
//2.2個實作,1個建構式
//3.因為到時有方法要新增Fragemtn,所以List<Fragment>,還有要設定Title所以List<String>
//4.自己家爸爸的Pager.Adapter的方法,取得Pa取得Pager的Title,改寫成回傳這個tiltle的int位置
//5.自己寫的新增一個Fragment,加入Fragemtn跟Title

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment = new ArrayList<>();
    private List<String> listFragmentTitle = new ArrayList<>();

    //建構式
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    //1.發揚光大,改成傳送這個Fragment的int位置  (1.實作方法)
    @NonNull
    @Override
    public Fragment getItem(int i) {
        return listFragment.get(i);
    }

    //2.發揚光大,改成傳送這個Titile的大小
    @Override
    public int getCount() {
        return listFragmentTitle.size();
    }

    //3.自己家爸爸的Pager.Adapter的方法,取得Pa取得Pager的Title,改寫成回傳這個tiltle的int位置
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listFragmentTitle.get(position);
    }

    //4.自己寫的新增Fragement加入到Viewpager裡面的條便器方法
    public void addFragment(Fragment fragment ,String title){
        listFragment.add(fragment);
        listFragmentTitle.add(title);
    }
}
