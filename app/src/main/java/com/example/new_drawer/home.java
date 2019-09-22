package com.example.new_drawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.app.ProgressDialog.show;

public class home extends Fragment {

    SearchView searchView;
    RecyclerView recyclerView;
    order_adapter adapter;
    List<fruits_model> fruitsList = new ArrayList<>();
    String[] name = {"The Apple Carmicheal", "Apple Sentiyago", "Apple Jugarnut", "Apple Sitosi",
            "Mango Sinthiya", "Mango Lusiana", "Mango AlfanZo", "Mango Seniorita",
            "Pears Loveable", "Pears Scarlett", "Pears Megenta", "Pears Memorina",
            "Promegranate BomB", "Promegranate Picasso", "Promegranate Witch", "Promegranate Ninja"};
    String[] country = {"America AC", "Norway NR", "Atlenta AL", "Oceana OC",
            "New Jersy NJ", "Oklahoma OK", "Texex TX", "Brooklyn BK",
            "Columbia CB", "Greenland GL", "Spain SP", "Tokya TK",
            "Huwai HW", "Brazil BZ", "Moroco MC", "Oakland OK"};
    String[] netWeight = {"Net Wt. 10Kg", "Net Wt. 20Kg", "Net Wt. 30Kg", "Net Wt. 10Kg",
            "Net Wt. 30Kg", "Net Wt. 30Kg", "Net Wt. 30Kg", "Net Wt. 30Kg",
            "Net Wt. 30Kg", "Net Wt. 30Kg", "Net Wt. 30Kg", "Net Wt. 30Kg",
            "Net Wt. 30Kg", "Net Wt. 30Kg", "Net Wt. 30Kg", "Net Wt. 30Kg"};
    String[] price1 = {"    135's - INR 2700 / Box", "    135's - INR 2700 / Box", "    135's - INR 2700 / Box", "    135's - INR 2700 / Box",
            "    135's - INR 2700 / Box", "    135's - INR 2700 / Box", "    135's - INR 2700 / Box", "    135's - INR 2700 / Box",
            "    135's - INR 2700 / Box", "    135's - INR 2700 / Box", "    135's - INR 2700 / Box", "    135's - INR 2700 / Box",
            "    135's - INR 2700 / Box", "    135's - INR 2700 / Box", "    135's - INR 2700 / Box", "    135's - INR 2700 / Box"};
    String[] price2 = {"   120's - INR 2800 / Box", "   120's - INR 2800 / Box", "   120's - INR 2800 / Box", "   120's - INR 2800 / Box",
            "   120's - INR 2800 / Box", "   120's - INR 2800 / Box", "   120's - INR 2800 / Box", "   120's - INR 2800 / Box",
            "   120's - INR 2800 / Box", "   120's - INR 2800 / Box", "   120's - INR 2800 / Box", "   120's - INR 2800 / Box",
            "   120's - INR 2800 / Box", "   120's - INR 2800 / Box", "   120's - INR 2800 / Box", "   120's - INR 2800 / Box"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container,false);
        recyclerView = view.findViewById(R.id.homerecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new order_adapter(getActivity(), fruitsList);
        recyclerView.setAdapter(adapter);
        populatedata();
        adapter.notifyDataSetChanged();

        searchView = view.findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }

    public List<fruits_model> populatedata() {
        for (int i = 0; i < name.length; i++) {
            fruits_model fruit = new fruits_model();
            fruit.setFruit_name(name[i]);
            fruit.setFruit_country(country[i]);
            fruit.setFruit_net(netWeight[i]);
            fruit.setPrice1(price1[i]);
            fruit.setPrice2(price2[i]);

            fruitsList.add(fruit);
        }
        return fruitsList;
    }

}
