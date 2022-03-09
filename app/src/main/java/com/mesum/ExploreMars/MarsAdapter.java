package com.mesum.ExploreMars;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import ExploreMars.R;
import ExploreMars.databinding.MarsItemBinding;


public class MarsAdapter extends ListAdapter<MarsModel, MarsAdapter.MarsViewHolder> {


    public Context context;
    public static final DiffUtil.ItemCallback<MarsModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<MarsModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull MarsModel oldItem, @NonNull MarsModel newItem) {

            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull MarsModel oldItem, @NonNull MarsModel newItem) {
            return oldItem.equals(newItem);
        }
    };

    protected MarsAdapter(@NonNull DiffUtil.ItemCallback<MarsModel> diffCallback, Context cn) {
        super(diffCallback);
        context = cn;
    }




    public class MarsViewHolder extends RecyclerView.ViewHolder  {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView typetextview;
        public ImageView marsimage;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public MarsViewHolder(MarsItemBinding binding) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(binding.getRoot());

            typetextview = binding.type;
            marsimage = binding.marsimage;
        }
        public void bind(MarsModel mars){

            typetextview.setText(mars.getType());
            String blogName = mars.getImg_src();
            //Adds s to http url to make it https
            //To make it work with glide image load library
            char c = 's';
            // Calling the method 1 to
            // add character to a string

            // Custom string, character and position passed
            String imageurl
                    = addCharToString(blogName, c, 4);

            // Print and display th above string
            Glide.with(context)
                    .load(imageurl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(marsimage);


        }


    }

    // Method to add a character at certain position in a string
    public static String addCharToString(String str, char c,
                                         int pos)
    {
        // Creating an object of StringBuffer class
        StringBuffer stringBuffer = new StringBuffer(str);
        // insert() method where position of character to be
        // inserted is specified as in arguments
        stringBuffer.insert(pos, c);
        // Return the updated string
        // Concatenated string
        return stringBuffer.toString();
    }

    @NonNull
    @Override
    public MarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MarsViewHolder(MarsItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull MarsAdapter.MarsViewHolder holder, int position) {
        holder.bind(getItem(position));

    }






}
