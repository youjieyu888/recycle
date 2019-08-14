package com.laioffer.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    enum Company{
        STEAM(0), AMAZON(1), EBAY(2);

        private final int type;
        private Company(int type){
            this.type=type;
        }
        public int getType(){
            return this.type;
        }
    }
    private List<Record> records;
    private Context context;

    public RecordAdapter(Context context, List<Record> records){
        this.context=context;
        this.records = records;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        if(viewType==Company.STEAM.getType()){
            return new SteamViewHolder(view);
        }else if(viewType==Company.AMAZON.getType()){
            return new AmazonViewHolder(view);
        }else if(viewType==Company.EBAY.getType()){
            return new EbaySteamViewHolder(view);
        }else{
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).setDetails(records.get(position));
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch(records.get(position).getShopName()){
            case "Steam":
                return Company.STEAM.getType();
            case "Amazon":
                return Company.AMAZON.getType();
            case "Ebay":
                return Company.EBAY.getType();
            default:
                return -1;
        }
    }
    int tempid=0;
    class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtName;
        protected TextView txtAddress;
        protected ImageView logo;
        protected View itemView ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            logo = itemView.findViewById(R.id.logo);
            this.itemView=itemView;
        }

        protected void setDetails(Record record) {
            txtName.setText(record.getShopName());
            txtAddress.setText(record.getItemName());
            logo.setImageResource(record.getLogo());
        }
    }

    class SteamViewHolder extends ViewHolder{
        public SteamViewHolder(@NonNull View itemView){
            super(itemView);
        }

        @Override
        protected void setDetails(Record record) {
            super.setDetails(record);
            txtName.setPaddingRelative(10,10,10,10);
        }
    }
    class AmazonViewHolder extends ViewHolder{
        public AmazonViewHolder(@NonNull View itemView){
            super(itemView);
        }

        @Override
        protected void setDetails(Record record) {
            super.setDetails(record);
            logo.getLayoutParams().height = 200;
            logo.getLayoutParams().width = 200;
            logo.requestLayout();
        }
    }
    class EbaySteamViewHolder extends ViewHolder{
        public EbaySteamViewHolder(@NonNull View itemView){
            super(itemView);
        }

        @Override
        protected void setDetails(Record record) {
            super.setDetails(record);
            txtName.setText(record.getShopName()+"                           "+record.getPrice());
        }
    }
}
