package akssmk.com.agriculturalapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.R;
import akssmk.com.agriculturalapp.modals.ItemHealthCard;

/**
 * Created by sukhbir on 6/8/16.
 */
public class SoilHealthCardAdapter extends RecyclerView.Adapter<SoilHealthCardAdapter.viewHolder> {
private ArrayList<ItemHealthCard> list=new ArrayList<>();
private Context context;
private int layout= R.layout.item_health_card;

    public SoilHealthCardAdapter(Context context, ArrayList<ItemHealthCard> items) {
            this.context = context;
            this.list=items;
    }


    public SoilHealthCardAdapter(Context context, ArrayList<ItemHealthCard> items, int layout) {
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
//        holder.linear.setBackgroundColor(Color.parseColor(list.get(position).getBackground()));
        holder.id.setText("LAB ID: "+list.get(position).getId());
        holder.name.setText(list.get(position).getName());
}

@Override
public int getItemCount() {
        return list.size();
        }

public static class viewHolder extends RecyclerView.ViewHolder{
    TextView id,name;
    LinearLayout linear;

    public viewHolder(View itemView) {
        super(itemView);
        linear=(LinearLayout)itemView.findViewById(R.id.linear);
        id= (TextView) itemView.findViewById(R.id.lab_id);
        name= (TextView) itemView.findViewById(R.id.lab_name);
    }
 }
}
