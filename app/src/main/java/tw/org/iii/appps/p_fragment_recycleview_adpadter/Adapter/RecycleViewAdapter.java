package tw.org.iii.appps.p_fragment_recycleview_adpadter.Adapter;
//1.繼承RecyclerView.Adapter後
//2.寫一個自己定義的MyViewHolder extends RecyclerView.ViewHolder,建構式後,放入資料結構中
//3.RecyclerView.Adapter,實作方法
//4.//1.這邊準備Contxt讓LayoutInfalter.from
//5. onCreateViewHolder(@NonNull ViewGroup parent, int viewType)時,設定讓抓取要指定的View,可以玩指定View的物件
//6. 在getItemCount取得List<Context> mData的大小
//7.public static class MyViewHolder extends RecyclerView.ViewHolder ://設定元件初始化
//8.public void onBindViewHolder(@NonNull MyViewHolder holder, int position):////5.指定元件設定(1.傳回來的Holder物件,2.物件裡的位置int)

//===================

//6.1:開始做item Onclick事件叫出Diralog


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tw.org.iii.appps.p_fragment_recycleview_adpadter.Model.Contact;
import tw.org.iii.appps.p_fragment_recycleview_adpadter.R;

import static android.graphics.Color.TRANSPARENT;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    Context mCntext;
    List<Contact> mData; //Contact自己定義的Model,為了要把自己陣列資料灌進來
    Dialog mdialog;

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
        final MyViewHolder myViewHolder = new MyViewHolder(v); //物件實體化將View放入建構式初始化

        //8.呼叫且init自訂的Dialog
        mdialog = new Dialog(mCntext);
        mdialog.setContentView(R.layout.dialog_contact); //指定Dialog的View為
        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT)); //把dialog裡的.取得window.設定背景res(新的顏色())


        //7.自訂測試item是否有抓取正確int位置,這邊抓到item int位置
        myViewHolder.LineaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mCntext,"Test Click" + String.valueOf(myViewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                //9.從指定的Dialog設定的xml肚子裡抓元件初始化
                TextView dialog_txt_name_id =  mdialog.findViewById(R.id.dialog_name_id);
                TextView dialog_txt_phone_id =  mdialog.findViewById(R.id.dialog_phone_id);
                ImageView dialog_img_contact =  mdialog.findViewById(R.id.dialog_img);

                //10.設定因為是來電,所以取得資料一樣時同個資料mData取得,設定名字跟圖片進去
                //取mdata裡面的第.viewjolder物件的.的第幾筆位置.取得他的名字
                dialog_txt_name_id.setText(mData.get(myViewHolder.getAdapterPosition()).getName());
                dialog_txt_phone_id.setText(mData.get(myViewHolder.getAdapterPosition()).getName());
                dialog_img_contact.setImageResource(mData.get(myViewHolder.getAdapterPosition()).getPhoto());

                mdialog.show();;
            }
        });

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
        private LinearLayout LineaItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

         //6.1第二段在寫好item的onclick的xml後初始化layout,這邊是一攔一攔的資料
            LineaItem = itemView.findViewById(R.id.linear_item_contact);

         //4.1第一段的
         txt_contact_name =   itemView.findViewById(R.id.txt_contact_name);
         txt_contact_phone =   itemView.findViewById(R.id.txt_conttact_phone_number);
         img_contact_photo =    itemView.findViewById(R.id.img_contact_photo);

         Log.v("hank","MyViewHolder => itemView" + itemView.toString());

        }
    }

}
