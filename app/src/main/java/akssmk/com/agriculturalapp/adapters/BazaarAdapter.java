package akssmk.com.agriculturalapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.modals.ItemBazaar;
import akssmk.com.agriculturalapp.R;

/**
 * Created by kharita on 7/8/16.
 */
public class BazaarAdapter extends RecyclerView.Adapter<BazaarAdapter.viewHolder>{
    private ArrayList<ItemBazaar> items;
    private Context context;

    public BazaarAdapter(Context context, ArrayList<ItemBazaar> items){
        this.context=context;
        this.items=items;
    }

    @Override
    public BazaarAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bazaar_recycler,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.market_view.setText(items.get(position).getMarket());
        holder.commodity_view.setText(items.get(position).getCommodity());
        holder.variety_view.setText(items.get(position).getVariety());
        holder.min_view.setText(items.get(position).getMin());
        holder.max_view.setText(items.get(position).getMax());
        holder.avg_view.setText(items.get(position).getAvg());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        private TextView market_view,commodity_view,variety_view;
        private TextView min_view,max_view,avg_view;

        public viewHolder(View itemView) {
            super(itemView);
            market_view=(TextView)itemView.findViewById(R.id.market);
            commodity_view=(TextView)itemView.findViewById(R.id.commodity);
            variety_view=(TextView)itemView.findViewById(R.id.variety);
            min_view=(TextView)itemView.findViewById(R.id.min);
            max_view=(TextView)itemView.findViewById(R.id.max);
            avg_view=(TextView)itemView.findViewById(R.id.avg);
        }
    }
}
