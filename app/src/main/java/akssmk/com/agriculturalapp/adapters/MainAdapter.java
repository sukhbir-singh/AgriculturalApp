package akssmk.com.agriculturalapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.modals.MainListItem;
import akssmk.com.agriculturalapp.R;

/**
 * Created by sukhbir on 6/8/16.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
private ArrayList<MainListItem> list=new ArrayList<>();
private Context context;
private int layout= R.layout.item_main;

public MainAdapter(Context context,ArrayList<MainListItem> items) {
        this.context = context;
        this.list=items;
}


    public MainAdapter(Context context,ArrayList<MainListItem> items,int layout) {
        this.context = context;
        this.list=items;
        this.layout=layout;
    }


@Override
public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent, false);
        return new viewHolder(view);
        }

@Override
public void onBindViewHolder(viewHolder holder, final int position) {
        holder.linear.setBackgroundColor(Color.parseColor(list.get(position).getBackgroundColor()));
        holder.englishText.setText(list.get(position).getEnglishText());
        holder.hindiText.setText(list.get(position).getHindiText());
        holder.imageView.setImageResource(list.get(position).getImageUrl());

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).getIntent()!=null)
                context.startActivity(list.get(position).getIntent());
            }
        });
}

@Override
public int getItemCount() {
        return list.size();
        }

public static class viewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView hindiText,englishText;
    LinearLayout linear;

    public viewHolder(View itemView) {
        super(itemView);
        linear=(LinearLayout)itemView.findViewById(R.id.linear);
        imageView= (ImageView) itemView.findViewById(R.id.imageView);
        hindiText= (TextView) itemView.findViewById(R.id.hindi_title);
        englishText= (TextView) itemView.findViewById(R.id.english_title);
    }
 }
}
