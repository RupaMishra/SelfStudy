package com.example.selfstudy.model;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.selfstudy.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private int progressStatus = 0;
    private Handler handler = new Handler();

    private SubjectList[] listdata;

    // RecyclerView recyclerView;
    public MyAdapter(SubjectList[] listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem= layoutInflater.inflate(R.layout.subject_list_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        progressStatus = 0;

        viewHolder.subject_icon.setImageResource(listdata[i].getIcon());
        viewHolder.subject_name.setText(listdata[i].getSubject_name());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus < 100){
                    progressStatus +=1;

                    try{
                        Thread.sleep(20);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    // Update the progress bar
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            viewHolder.pb.setProgress(progressStatus);
                            // Show the progress on TextView
                            viewHolder.progress.setText(progressStatus+"");
                        }
                    });
                }
            }
        }).start();

        final SubjectList mySubjectList = listdata[i];


    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView subject_icon;
        TextView subject_name,progress;
        ProgressBar pb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject_icon = itemView.findViewById(R.id.subject_icon);
            subject_name = itemView.findViewById(R.id.subject_name);
            progress = itemView.findViewById(R.id.progress);
            pb = itemView.findViewById(R.id.pb);
        }
    }
}
