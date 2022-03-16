package com.example.farmer_survey_frontend.SearchPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farmer_survey_frontend.R;
import com.example.farmer_survey_frontend.Respones.GetFarmerDataRespones;
import com.example.farmer_survey_frontend.Retrofit.RetrofitClient;
import com.example.farmer_survey_frontend.UserData.UserDataAdapter;
import com.example.farmer_survey_frontend.UserData.UserDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserDataAdapter userDataAdapter;
    private List<UserDataModel> userDataModelList;
    private ArrayList<String> recentSearches;
    private EditText searchPageET;
    private ImageView searchPageBackIV , Search;
    private  EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        edt = findViewById(R.id.searchPageET);
        Search = findViewById(R.id.SearchPP);
        recyclerView = findViewById(R.id.searchPageRV);

        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               // searchFilter(s.toString());
            }
        });



        searchPageBackIV = findViewById(R.id.searchPageBackIV);
        searchPageBackIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == event.ACTION_DOWN &&  keyCode == KeyEvent.KEYCODE_ENTER){
                    if ((edt.getText().toString().equals(""))) {
                        Toast.makeText(
                                getBaseContext(),
                                "Whoa! You haven't entered anything in the search box.",
                                Toast.LENGTH_SHORT).show();

                    }
                    else {
                        recyclerView.setLayoutManager(new LinearLayoutManager(SearchPageActivity.this));

                        String p = edt.getText().toString();
                        String url = "/api/user/?search="+p;

                        Call<GetFarmerDataRespones> call = RetrofitClient.getInstance().getApi().getsearch(url);
                        call.enqueue(new Callback<GetFarmerDataRespones>() {
                            @Override
                            public void onResponse(Call<GetFarmerDataRespones> call, Response<GetFarmerDataRespones> response) {
                                try{
                                    userDataModelList = response.body().getData();
                                    userDataAdapter = new UserDataAdapter(userDataModelList,SearchPageActivity.this);
                                    recyclerView.setAdapter(userDataAdapter);
                                    findViewById(R.id.textForSearch).setVisibility(View.VISIBLE);
                                    TextView txt = findViewById(R.id.textForSearch);
                                    txt.setText("search for "+ p);
                                }catch (Exception e){
                                    Toast.makeText(SearchPageActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<GetFarmerDataRespones> call, Throwable t) {

                            }
                        });
                    }
                    return true;
                }
                return false;
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((edt.getText().toString().equals(""))) {
                    Toast.makeText(
                            getBaseContext(),
                            "Whoa! You haven't entered anything in the search box.",
                            Toast.LENGTH_SHORT).show();

                }
                else {
                    recyclerView.setLayoutManager(new LinearLayoutManager(SearchPageActivity.this));

                    String p = edt.getText().toString();
                    String url = "/api/user/?search="+p;

                    Call<GetFarmerDataRespones> call = RetrofitClient.getInstance().getApi().getsearch(url);
                    call.enqueue(new Callback<GetFarmerDataRespones>() {
                        @Override
                        public void onResponse(Call<GetFarmerDataRespones> call, Response<GetFarmerDataRespones> response) {
                            try{
                                userDataModelList = response.body().getData();
                                userDataAdapter = new UserDataAdapter(userDataModelList,SearchPageActivity.this);
                                recyclerView.setAdapter(userDataAdapter);
                                findViewById(R.id.textForSearch).setVisibility(View.VISIBLE);
                                TextView txt = findViewById(R.id.textForSearch);
                                txt.setText("search for "+ p);
                            }catch (Exception e){
                                Toast.makeText(SearchPageActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<GetFarmerDataRespones> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }


}