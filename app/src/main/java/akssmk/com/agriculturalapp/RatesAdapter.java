package akssmk.com.agriculturalapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.unbescape.html.HtmlEscape;

import java.util.ArrayList;

public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.viewHolder> {
    private ArrayList<NewsItem> list=new ArrayList<>();
    private Context context;

    public RatesAdapter(Context context) {
        this.context = context;
    }

    public  void  refresh(ArrayList<NewsItem> list){
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
if(!list.get(position).title.isEmpty()&&list.get(position).title.length()!=0){
    holder.textView.setText(HtmlEscape.unescapeHtml(list.get(position).title));
}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public viewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.image_item_category);
            textView= (TextView) itemView.findViewById(R.id.title_item_category);
        }
    }
}
