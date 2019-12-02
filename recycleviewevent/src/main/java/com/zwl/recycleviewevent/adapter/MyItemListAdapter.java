package com.zwl.recycleviewevent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zwl.recycleviewevent.R;
import com.zwl.recycleviewevent.data.MyData;

import java.util.List;

/**
 * @author zwl
 * @date on 2019-12-02
 */
public class MyItemListAdapter extends RecyclerView.Adapter<MyItemListAdapter.NameHolder> {

    private Context mContext;
    private List<MyData> myDataList;

    public MyItemListAdapter(Context context, List<MyData> dataList) {
        this.myDataList = dataList;
        this.mContext = context;
    }


    /**
     * name item
     */
    class NameHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public NameHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_item_name);
        }
    }


    @NonNull
    @Override
    public MyItemListAdapter.NameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_item, parent, false);
        return new NameHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemListAdapter.NameHolder holder, int position) {
        holder.textView.setText(myDataList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return myDataList == null ? 0 : myDataList.size();
    }
}
