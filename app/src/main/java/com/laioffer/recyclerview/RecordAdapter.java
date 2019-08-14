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
    private static final int STEAM = 1;
    private static final int AMAZON = 2;
    private static final int EBAY = 3;
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
        return new ViewHolder(view);
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
                return STEAM;
            case "Amazon":
                return AMAZON;
            case "Ebay":
                return EBAY;
            default:
                return -1;
        }
    }
    int tempid=0;
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtAddress;
        private ImageView logo;
        private View itemView ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            logo = itemView.findViewById(R.id.logo);
            this.itemView=itemView;
        }

        private void setDetails(Record record) {
            txtName.setText(record.getShopName());
            txtAddress.setText(record.getItemName());
            logo.setImageResource(record.getLogo());

            switch(record.getShopName()){
                case "Steam":
                    txtName.setPaddingRelative(10,10,10,10);
                    break;
                case "Amazon":
                    logo.getLayoutParams().height = 200;
                    logo.getLayoutParams().width = 200;
                    logo.requestLayout();
                    break;
                case "Ebay":
                    txtName.setText(record.getShopName()+"                           "+record.getPrice());
                    break;
            }
        }
    }

}
