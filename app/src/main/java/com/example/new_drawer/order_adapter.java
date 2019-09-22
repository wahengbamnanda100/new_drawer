package com.example.new_drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class order_adapter extends RecyclerView.Adapter<order_adapter.ViewHolder> implements Filterable {

    Context ctx;
    List<fruits_model> list;
    ArrayList<fruits_model> full_list;



    public order_adapter(Context context, List<fruits_model> listitems) {
        ctx = context;
        this.list = listitems;

    }

    @NonNull
    @Override
    public order_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.order_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        this.full_list = new ArrayList<>();
        full_list.addAll(list);

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

    @Override
    public Filter getFilter() {
        return Filter_list;
    }

    private Filter Filter_list = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<fruits_model> filtered_list = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filtered_list.addAll(full_list);
            } else {
                String searchPattren = charSequence.toString().toLowerCase().trim();

                /*for (fruits_model model: full_list ) {
                    if (model.getFruit_name().toLowerCase().contains(searchPattren)) {
                        filtered_list.add(model);
                    }
                }*/
                for (fruits_model fruits : full_list) {
                    if (fruits.getFruit_name().toLowerCase().contains(searchPattren)) {
                        filtered_list.add(fruits);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filtered_list;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            list.clear();
            list.addAll((List) results.values);
            notifyDataSetChanged();
        }

    };


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

