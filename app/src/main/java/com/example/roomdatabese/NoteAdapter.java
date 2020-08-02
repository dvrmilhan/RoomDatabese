package com.example.roomdatabese;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    //Initialize variables
    private List<Note> DataList;
    private Activity context;
    private NoteDatabase NoteDatabase;

    //Create constructor
    public NoteAdapter(Activity context, List<Note> list){
        this.context = context;
        this.DataList = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize variable
        TextView  text_view;
        Button bt_edit, bt_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variables
            text_view = itemView.findViewById(R.id.text_view);
            bt_edit = itemView.findViewById(R.id.bt_edit);
            bt_delete =itemView.findViewById(R.id.bt_delete);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        //Initialize main data
        Note data= DataList.get(position);
        //Initialize database
        NoteDatabase = com.example.roomdatabese.NoteDatabase.getInstance(context);
        //Set text on textview
        holder.text_view.setText(data.getDescription());

        holder.bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initialize main data
                Note d= DataList.get(holder.getAdapterPosition());
                //get text
                String sText= d.getDescription();

                //create dialog
                Dialog dialog = new Dialog(context);

                //set content view
                dialog.setContentView(R.layout.dialog_update);

            }
        });
    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }


}
