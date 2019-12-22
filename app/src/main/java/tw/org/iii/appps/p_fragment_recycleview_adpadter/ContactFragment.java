package tw.org.iii.appps.p_fragment_recycleview_adpadter;
//目的RecycleView作呈現
//1.加入api
//2.在頁面加入RecycleView
//3.Model物件 (Name,Phone,Photo)

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tw.org.iii.appps.p_fragment_recycleview_adpadter.Adapter.RecycleViewAdapter;
import tw.org.iii.appps.p_fragment_recycleview_adpadter.Model.Contact;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {
    private RecyclerView recycleView;
    private List<Contact> listContact;
    private View view;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_contact, container, false);
        recycleView = view.findViewById(R.id.contact_recycleview);
        RecycleViewAdapter adapter = new RecycleViewAdapter(getContext(),listContact); //建構式Adapter(1.取得這個Fragment.Context,2.掛上填好資料的)
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));//recycleview.設定要裝入的LayoutManger,(因為item用LinearLayout用這個經理人)
        recycleView.setAdapter(adapter);

        Log.v("hank","onCreateView");
        return  view;
    }

    //1.初始化只做一次
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();
        if(listContact != null){
            for(int i=0; i<10; i++){
                listContact.add(new Contact("hank","0493020",R.drawable.ic_star_black_24dp));
            }
        }
        Log.v("hank","onCreate");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.v("hank","onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("hank","onDetach");
    }
}
