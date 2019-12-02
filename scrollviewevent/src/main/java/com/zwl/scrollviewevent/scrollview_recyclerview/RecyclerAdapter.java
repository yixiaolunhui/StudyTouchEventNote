package com.zwl.scrollviewevent.scrollview_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zwl.scrollviewevent.R;

import java.util.List;

/**
 * @author zwl
 * @date on 2019-11-30
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private List<MyData> mMyDataList;

    public RecyclerAdapter(List<MyData> mMyDataList) {
        this.mMyDataList = mMyDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_scroll_scroll, parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewHolder.getAdapterPosition();
                String name = mMyDataList.get(pos).name;
                Toast.makeText(parent.getContext(), "name=" + name, Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(mMyDataList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return mMyDataList != null ? mMyDataList.size() : 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_recycler_list_tv);
        }
    }

}
