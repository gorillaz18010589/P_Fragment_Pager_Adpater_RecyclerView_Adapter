package tw.org.iii.appps.p_fragment_recycleview_adpadter.Adapter;
//1.繼承RecyclerView.Adapter後
//2.寫一個自己定義的MyViewHolder extends RecyclerView.ViewHolder,建構式後,放入資料結構中
//3.RecyclerView.Adapter,實作方法
//4.//1.這邊準備Contxt讓LayoutInfalter.from
//5. onCreateViewHolder(@NonNull ViewGroup parent, int viewType)時,設定讓抓取要指定的View,可以玩指定View的物件
//6. 在getItemCount取得List<Context> mData的大小
//7.public static class MyViewHolder extends RecyclerView.ViewHolder ://設定元件初始化
//8.public void onBindViewHolder(@NonNull MyViewHolder holder, int position):////5.指定元件設定(1.傳回來的Holder物件,2.物件裡的位置int)
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tw.org.iii.appps.p_fragment_recycleview_adpadter.Model.Contact;
import tw.org.iii.appps.p_fragment_recycleview_adpadter.R;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    Context mCntext;
    List<Contact> mData; //Contact自己定義的Model,為了要把自己陣列資料灌進來

    //1.這邊準備Contxt讓LayoutInfalter.from  (1.Context,因為Fragemt要知道是哪個,List<自己寫的物件>,要掛上的陣列資料)
    public RecycleViewAdapter(Context mCntext, List<Contact> mData) {
        this.mCntext = mCntext;
        this.mData = mData;
    }


    //2.負責設定要指定的View,可以玩指定View的物件,負責將抓到的View設定到MyViewHolder傳出去(第二個被呼叫,傳到onBindViewHolder)
    //View.LayoutInflater from(Context context):要浮現Layout從哪個Content取得
    //Inflate.inflate(int resource, @Nullable ViewGroup root, boolean attachToRoot)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v =  LayoutInflater.from(mCntext).inflate(R.layout.item_contact,parent,false);///抓取指定頁面
        MyViewHolder myViewHolder = new MyViewHolder(v); //物件實體化將View放入建構式初始化


        Log.v("hank","onCreateViewHolder");
        return myViewHolder;//回傳以抓好的View可以玩物件,然後將myViewJolder傳到onBindViewHolder
    }

    //5.指定元件設定處理(1.傳回來的Holder物件,2.物件裡的位置int一開始item是0再來1)(最後被叫再來循環)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_contact_name.setText(mData.get(position).getName());  //設定姓名為(mData物件裡的.地int筆.取得姓名)
        holder.txt_contact_phone.setText(mData.get(position).getPhone());
        holder.img_contact_photo.setImageResource(mData.get(position).getPhoto());
        Log.v("hank","onBindViewHolder => postion:" + position);
    }

    //3.取得List<Context> mData的大小
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //4.負責將View的原件初始化設定(第一被呼叫負責初始化)
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_contact_name, txt_contact_phone;
        private ImageView img_contact_photo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

         txt_contact_name =   itemView.findViewById(R.id.txt_contact_name);
         txt_contact_phone =   itemView.findViewById(R.id.txt_conttact_phone_number);
         img_contact_photo =    itemView.findViewById(R.id.img_contact_photo);

         Log.v("hank","MyViewHolder => itemView" + itemView.toString());

        }
    }

}
