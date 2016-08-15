package akssmk.com.agriculturalapp.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.R;

public class PolicyAdapter extends RecyclerView.Adapter<PolicyAdapter.viewHolder> {
    private ArrayList<String> list=new ArrayList<>();
    private Context context;

    public PolicyAdapter(Context context,ArrayList<String> list) {
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
    public void onBindViewHolder(viewHolder holder, int position) {
       // if(!list.get(position).title.isEmpty()&&list.get(position).title.length()!=0){
        holder.textView.setText(list.get(position));
        //}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public viewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.title);
        }
    }
}
