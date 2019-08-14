package com.laioffer.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_CALL = 1;
    private static int TYPE_EMAIL = 2;
    private List<Record> records;
    private Context context;

    public RecordAdapter(Context context, List<Record> records){
        this.context=context;
        this.records = records;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_CALL) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.item_call, parent, false);
            return new CallViewHolder(view);

        } else { // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.item_email, parent, false);
            return new EmailViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_CALL) {
            ((CallViewHolder) holder).setCallDetails(records.get(position));
        } else {
            ((EmailViewHolder) holder).setEmailDetails(records.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (records.get(position).getDate()==null) {
            return TYPE_CALL;

        } else {
            return TYPE_EMAIL;
        }
    }

    class CallViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtAddress;

        CallViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }

        private void setCallDetails(Record record) {
            txtName.setText(record.getShopName());
            txtAddress.setText(record.getItemName());
        }
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtAddress;

        EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }
        private void setEmailDetails(Record record) {
            txtName.setText(record.getShopName());
            txtAddress.setText(record.getItemName());
        }
    }
}
