package akssmk.com.agriculturalapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.R;
import akssmk.com.agriculturalapp.modals.HorticultureDetailItem;

/**
 * Created by sukhbir on 6/8/16.
 */
public class HorticultureDetailAdapter extends RecyclerView.Adapter<HorticultureDetailAdapter.viewHolder> {
private ArrayList<HorticultureDetailItem> list=new ArrayList<>();
private Context context;
private int layout= R.layout.horticulture_detail_item;

private boolean check[];

public HorticultureDetailAdapter(Context context, ArrayList<HorticultureDetailItem> items) {
        this.context = context;
        this.list=items;
        check=new boolean[items.size()];
}

    public HorticultureDetailAdapter(Context context, ArrayList<HorticultureDetailItem> items, int layout) {
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
public void onBindViewHolder(final viewHolder holder, final int position) {
       // holder.linear.setBackgroundColor(Color.parseColor(list.get(position).getBackgroundColor()));
        holder.heading.setText(list.get(position).getHeading());
        holder.detail.setText(list.get(position).getDetail());
        holder.image.setImageResource(list.get(position).getImage());

        if(check[position]==false){
            holder.detail.setVisibility(View.GONE);

        }else{
            holder.detail.setVisibility(View.VISIBLE);
        }

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.detail.getVisibility()==View.GONE){
                    holder.detail.setVisibility(View.VISIBLE);
                    check[position]=true;

                }else{
                    holder.detail.setVisibility(View.GONE);
                    check[position]=false;

                }
            }
        });
}

@Override
public int getItemCount() {
        return list.size();
        }

public static class viewHolder extends RecyclerView.ViewHolder{

    TextView heading,detail;
    ImageView image;
    LinearLayout linear;

    public viewHolder(View itemView) {
        super(itemView);
        linear=(LinearLayout)itemView.findViewById(R.id.linear);
        image=(ImageView)itemView.findViewById(R.id.imageView);
        heading= (TextView) itemView.findViewById(R.id.heading);
        detail= (TextView) itemView.findViewById(R.id.detail);
    }
 }
}
