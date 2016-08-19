package akssmk.com.agriculturalapp.adapters;

import android.content.Context;
import android.content.Intent;
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
public class ProblemShowAdapter extends RecyclerView.Adapter<ProblemShowAdapter.viewHolder> {
    private String[] array;
    private Intent[] links;
    private Context context;
    private int layout= R.layout.item_category;

    public ProblemShowAdapter(Context context, String[] array,Intent[] links) {
        this.context = context;
        this.array=array;
        this.links=links;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {

        holder.textView.setText(array[position]);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               context.startActivity(links[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CardView card;

        public viewHolder(View itemView) {
            super(itemView);
            card=(CardView) itemView.findViewById(R.id.card);
            textView= (TextView) itemView.findViewById(R.id.title);
        }
    }
}
