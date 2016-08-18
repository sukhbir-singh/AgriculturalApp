package akssmk.com.agriculturalapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.R;
import akssmk.com.agriculturalapp.modals.MainListItem;

/**
 * Created by sukhbir on 6/8/16.
 */
public class HorticultureAdapter extends RecyclerView.Adapter<HorticultureAdapter.viewHolder> {
private ArrayList<MainListItem> list=new ArrayList<>();
private Context context;
private int layout= R.layout.item_horticulture_card;

public HorticultureAdapter(Context context, ArrayList<MainListItem> items) {
        this.context = context;
        this.list=items;
}


    public HorticultureAdapter(Context context, ArrayList<MainListItem> items, int layout) {
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

        holder.englishText.setText(list.get(position).getEnglishText());
        holder.imageView.setImageResource(list.get(position).getImageUrl());

        holder.card.setOnClickListener(new View.OnClickListener() {
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
    TextView englishText;
    CardView card;

    public viewHolder(View itemView) {
        super(itemView);
        card=(CardView) itemView.findViewById(R.id.card);
        imageView= (ImageView) itemView.findViewById(R.id.imageView);
        englishText= (TextView) itemView.findViewById(R.id.english_title);
    }
 }
}
