package akssmk.com.agriculturalapp.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.R;
import akssmk.com.agriculturalapp.activities.WebActivity;

public class PolicyAdapter extends RecyclerView.Adapter<PolicyAdapter.viewHolder> {
    private String[] links;
    private ArrayList<String> list=new ArrayList<>();
    private Context context;

    public PolicyAdapter(Context context,ArrayList<String> list,String[] links) {
        this.links=links;
        this.context = context;
        this.list=list;
    }

    public  void  refresh(ArrayList<String> list){
        this.list=list;
        notifyItemRangeChanged(0,list.size());
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
        holder.textView.setText(list.get(position));


        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser =new Intent(context, WebActivity.class);
                browser.putExtra("link",links[position]);
                context.startActivity(browser);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CardView card;
        public viewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.title);
            card= (CardView) itemView.findViewById(R.id.card);
        }
    }
}
