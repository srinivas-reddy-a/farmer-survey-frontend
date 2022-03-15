package com.example.farmer_survey_frontend.UserData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmer_survey_frontend.R;

import java.util.List;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.ViewHolder> {

    private List<UserDataModel> userDataModels;
    Context context;

    public UserDataAdapter(List<UserDataModel> userDataModels, Context context) {
        this.userDataModels = userDataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_data_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = userDataModels.get(position).getName();
        String number = userDataModels.get(position).getNumber();
        String village = userDataModels.get(position).getVillage();
        String pinCode = userDataModels.get(position).getPincode();
        String problems = userDataModels.get(position).getProblems();
        String need = userDataModels.get(position).getNeeds();

        //call
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String uriText = "tel:+91"+number;
                try {
                    intent.setData(Uri.parse(uriText));
                    context.startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.SetData(name,number,village,pinCode,problems,need);
    }

    @Override
    public int getItemCount() {
        return userDataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView UserNameData,UserNumberData,UserVillageData,UserPinCodeData,
                UserProblemData,UserNeedsData ,User_S_no;
        private ImageView call;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UserNameData = itemView.findViewById(R.id.UserNameData);
            UserNumberData = itemView.findViewById(R.id.UserNumberData);
            UserVillageData = itemView.findViewById(R.id.UserVillageData);
            UserPinCodeData = itemView.findViewById(R.id.UserPinCodeData);
            UserProblemData = itemView.findViewById(R.id.UserProblemData);
            UserNeedsData = itemView.findViewById(R.id.UserNeedsData);
            User_S_no = itemView.findViewById(R.id.User_S_no);
            call = itemView.findViewById(R.id.call);


        }
        private void SetData(String name,String number,String village,String pinCode,String Problems,String needs){
            int i=getAdapterPosition();
            String p = Integer.toString(i);
            User_S_no.setText(p);

            UserNameData.setText(name);
            UserNumberData.setText(number);
            UserVillageData.setText(village);
            UserPinCodeData.setText("pinCode "+pinCode);
            UserProblemData.setText(Problems);
            UserNeedsData.setText(needs);
        }

    }
}
