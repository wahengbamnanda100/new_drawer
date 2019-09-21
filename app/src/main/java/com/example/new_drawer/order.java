package com.example.new_drawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class order extends Fragment {

    Button btApple, btPears, btMango, btPro;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);
        recyclerView = view.findViewById(R.id.orderrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new order_adapter(getActivity(), fruitsList);
        recyclerView.setAdapter(adapter);

        btApple = view.findViewById(R.id.btapple);
        btMango = view.findViewById(R.id.btmango);
        btPears = view.findViewById(R.id.btpears);
        btPro = view.findViewById(R.id.btpromegranate);

        btApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fruitsList.clear();
                apple();
                adapter.notifyDataSetChanged();
            }
        });

        btMango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fruitsList.clear();
                mango();
                adapter.notifyDataSetChanged();
            }
        });

        btPears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fruitsList.clear();
                pears();
                adapter.notifyDataSetChanged();
            }
        });

        btPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fruitsList.clear();
                pro();
                adapter.notifyDataSetChanged();
            }
        });
       /* btMango.setOnClickListener(this);
        btPro.setOnClickListener(this);
        btPears.setOnClickListener(this);
*/
        populatedata();
        adapter.notifyDataSetChanged();


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

   /* @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btapple :
                apple();
                Toast.makeText(getActivity(), "Apple", Toast.LENGTH_LONG).show();
                break;

            case R.id.btmango :
                mango();
                Toast.makeText(getActivity(), "Mango", Toast.LENGTH_LONG).show();
                break;

            case R.id.btpears :
                pears();
                Toast.makeText(getActivity(), "Pears", Toast.LENGTH_LONG).show();
                break;

            case R.id.btpromegranate :
                pro();
                Toast.makeText(getActivity(), "Promegranate", Toast.LENGTH_LONG).show();
                break;
        }
    }*/

    private List<fruits_model> apple() {
        for (int i = 0; i < 4; i++) {
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

    private List<fruits_model> mango() {
        for (int i = 4; i < 8; i++) {
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

    private List<fruits_model> pears() {
        for (int i = 8; i < 12; i++) {
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

    private List<fruits_model> pro() {
        for (int i = 12; i < 16; i++) {
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
