package com.example.luxury_brands;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AllProductActivity extends AppCompatActivity {

    private RecyclerView rvAllContractor;
    ProductAdapter adapter;
    FirebaseServices fbs;
    ArrayList<Product> products;
    MyCallBack myCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        fbs = FirebaseServices.getInstance();
        products = new ArrayList<Product>();
        readData();
        myCallback = new MyCallBack() {
            @Override
            public void onCallback(List<Product> contractorsList) {
                RecyclerView recyclerView = findViewById(R.id.rvConAllProducts);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new ProductAdapter(getApplicationContext(), products);
                recyclerView.setAdapter(adapter);
            }
        };

        int i = 0;
        // set up the RecyclerView
        /*
        RecyclerView recyclerView = findViewById(R.id.rvConAllProduct);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterRestaurant(this, contractors);
        recyclerView.setAdapter(adapter);*/
    }
    private void readData() {
        try {

            fbs.getFire().collection("Contractors")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @SuppressLint("LongLogTag")
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    products.add(document.toObject(Product.class));
                                }

                                myCallback.onCallback(products);
                            } else {
                                Log.e("AllProductActivity: readData()", "Error getting documents.", task.getException());
                            }
                        }
                    });

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "error reading!" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}