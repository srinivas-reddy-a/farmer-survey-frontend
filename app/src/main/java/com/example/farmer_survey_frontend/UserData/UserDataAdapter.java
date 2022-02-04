package com.example.farmer_survey_frontend.UserData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmer_survey_frontend.R;

import java.util.List;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.ViewHolder> {

    private List<UserDataModel> userDataModels;


    public UserDataAdapter(List<UserDataModel> userDataModels) {
        this.userDataModels = userDataModels;
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
        int number = userDataModels.get(position).getNumber();
        String village = userDataModels.get(position).getVillage();
        int pinCode = userDataModels.get(position).getPinCode();
        String problems = userDataModels.get(position).getProblem();
        String need = userDataModels.get(position).getNeeds();
        holder.SetData(name,number,village,pinCode,problems,need);
    }

    @Override
    public int getItemCount() {
        return userDataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView UserNameData,UserNumberData,UserVillageData,UserPinCodeData,
                UserProblemData,UserNeedsData ,User_S_no;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UserNameData = itemView.findViewById(R.id.UserNameData);
            UserNumberData = itemView.findViewById(R.id.UserNumberData);
            UserVillageData = itemView.findViewById(R.id.UserVillageData);
            UserPinCodeData = itemView.findViewById(R.id.UserPinCodeData);
            UserProblemData = itemView.findViewById(R.id.UserProblemData);
            UserNeedsData = itemView.findViewById(R.id.UserNeedsData);
            User_S_no = itemView.findViewById(R.id.User_S_no);


        }
        private void SetData(String name,int number,String village,int pinCode,String Problems,String needs){
            int i=getAdapterPosition();
            String p = Integer.toString(i);
            User_S_no.setText(p);

            UserNameData.setText(name);
            UserNumberData.setText(number);
            UserVillageData.setText(village);
            UserPinCodeData.setText(pinCode);
            UserProblemData.setText(Problems);
            UserNeedsData.setText(needs);
        }

    }
}
