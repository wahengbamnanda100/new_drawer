package com.example.new_drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class order_adapter extends RecyclerView.Adapter<order_adapter.ViewHolder> {

    Context ctx;
    List<fruits_model> list;

    public order_adapter(Context context, List<fruits_model> list) {
        ctx = context;
        this.list = list;
    }

    @NonNull
    @Override
    public order_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.order_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull order_adapter.ViewHolder holder, int position) {

        fruits_model model = list.get(position);
        holder.tvname.setText(model.getFruit_name());
        holder.tvcountry.setText(model.getFruit_country());
        holder.tvnet.setText(model.getFruit_net());
        holder.tvprice1.setText(model.getPrice1());
        holder.tvprice2.setText(model.getPrice2());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivfruit;
        TextView tvname, tvcountry, tvnet, tvprice1, tvprice2;
        Button btadd1, btadd2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivfruit = itemView.findViewById(R.id.orderImage);
            tvname = itemView.findViewById(R.id.tvappleName);
            tvcountry = itemView.findViewById(R.id.tvCountryName);
            tvnet = itemView.findViewById(R.id.tvweight);
            tvprice1 = itemView.findViewById(R.id.tvRupee1);
            tvprice2 = itemView.findViewById(R.id.tvRupee2);

            btadd1 = itemView.findViewById(R.id.btAdd1);
            btadd2 = itemView.findViewById(R.id.btAdd2);
        }
    }
}
