package com.example.recyclerveiw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewinterface {

    ArrayList<dbz_Model> dbzModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private DBZ_RecyclerViewAdapter itemadapter;
    private SearchView searchView;

    ArrayList<dbz_Model> filteredList = new ArrayList<>();


    int[] dbzImages = {R.drawable.ic_goku2,R.drawable.ic_gohan2,R.drawable.ic_vageta2
            ,R.drawable.ic_krilin2,R.drawable.ic_pikolo2,R.drawable.ic_cell2,R.drawable.ic_frieza2,
            R.drawable.ic_a16 ,R.drawable.ic_a17,R.drawable.ic_android18};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterList(newText);
                return false;
            }
        });

        recyclerView = findViewById(R.id.mRecycleView);

        setUpDbzModels();

        itemadapter = new DBZ_RecyclerViewAdapter(this,dbzModels,this);
        recyclerView.setAdapter(itemadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void filterList(String text) {

        filteredList = new ArrayList<>();
        for (dbz_Model item : dbzModels){
            if(item.getDbz_names().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }


        if(filteredList.isEmpty()){
            Toast.makeText(this,"No Data found",Toast.LENGTH_SHORT).show();
        }else{
            itemadapter.setFilteredList(filteredList);
        }
    }

    private void setUpDbzModels(){

        String[] dbzNames = getResources().getStringArray(R.array.dbz_fighters);
        String[] dbzRaces = getResources().getStringArray(R.array.dbz_races);
        String[] dbzPower = getResources().getStringArray(R.array.dbz_power);
        String[] dbz_Description = getResources().getStringArray(R.array.dbz_Description);


        for (int i = 0; i <dbzNames.length ; i++) {
            dbzModels.add(new dbz_Model(dbzNames[i],dbzRaces[i],dbzPower[i],dbzImages[i],dbz_Description[i]));
        }
    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(MainActivity.this,MainActivity2.class);

        if(filteredList.isEmpty()) {

            intent.putExtra("NAME", dbzModels.get(position).getDbz_names());
            intent.putExtra("ABBR_BIG", dbzModels.get(position).getDbz_races());
            intent.putExtra("ABBR_SMALL", dbzModels.get(position).getDbz_power());
            intent.putExtra("DESCRIPTION", dbzModels.get(position).getDescription());
            intent.putExtra("IMAGE", dbzModels.get(position).getImage());

            startActivity(intent);
        }else{
            intent.putExtra("NAME", filteredList.get(position).getDbz_names());
            intent.putExtra("ABBR_BIG", filteredList.get(position).getDbz_races());
            intent.putExtra("ABBR_SMALL", filteredList.get(position).getDbz_power());
            intent.putExtra("DESCRIPTION", filteredList.get(position).getDescription());
            intent.putExtra("IMAGE", filteredList.get(position).getImage());

            startActivity(intent);


        }

    }
}