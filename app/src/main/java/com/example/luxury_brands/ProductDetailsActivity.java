package com.example.luxury_brands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AppCompatActivity {

    private TextView tvName, tvDescription, tvAddress, tvCategory, tvPhone;
    private ImageView ivPhoto;

      /*
        private String address;
    private RestCat category;
    private String photo;
    private String phone;
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        connectComponents();
        Intent i = this.getIntent();
        Product contractor = (Product) i.getSerializableExtra("contractor");

        tvName.setText(contractor.getProductName());
        tvDescription.setText(contractor.getDescription());
        tvAddress.setText(contractor.getAddress());
        tvCategory.setText(contractor.getSog().toString());
        tvPhone.setText(contractor.getPhone());
        Picasso.get().load(contractor.getPhoto()).into(ivPhoto);
    }
    private void connectComponents() {
        tvName = findViewById(R.id.tvNameRestDetails);
        tvDescription = findViewById(R.id.tvDescriptionRestDetails);
        tvAddress = findViewById(R.id.tvAddressRestDetails);
        tvCategory = findViewById(R.id.tvCategoryRestDetails);
        tvPhone = findViewById(R.id.tvPhoneRestDetails);
        ivPhoto = findViewById(R.id.ivPhotoRestDetails);
    }
}