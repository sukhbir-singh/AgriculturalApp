package akssmk.com.agriculturalapp.ExpandableRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.List;

import akssmk.com.agriculturalapp.activities.CropDetailActivity;
import akssmk.com.agriculturalapp.R;

/**
 * Created by Ramola on 8/5/2016.
 */
public class Adapter extends ExpandableRecyclerAdapter<Adapter.ParentHolder,Adapter.ChildHolder>{

    private Context context;
    public Adapter(Context context,@NonNull List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        this.context=context;

    }

    @Override
    public ParentHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View v= LayoutInflater.from(parentViewGroup.getContext()).inflate(R.layout.item_crop_parent,parentViewGroup,false);
        return new ParentHolder(v);
    }

    @Override
    public ChildHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        //View v= LayoutInflater.from(childViewGroup.getContext()).inflate(R.layout.item_crop_child,childViewGroup,false);
        return null;
    }

    @Override
    public void onBindParentViewHolder(ParentHolder parentViewHolder, int position, ParentListItem parentListItem) {
        ParentHeading parentHeading=(ParentHeading) parentListItem;
        parentViewHolder.mainHeading.setText(parentHeading.getHeading());


        parentViewHolder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if(list.get(position).getIntent()!=null)
               context.startActivity(new Intent(context, CropDetailActivity.class));
            }
        });
    }

    @Override
    public void onBindChildViewHolder(ChildHolder childViewHolder, int position, Object childListItem) {
        ChildHeading childHeading= (ChildHeading) childListItem;
        childViewHolder.childView.setText(childHeading.getText());

    }

    public static class ChildHolder extends ChildViewHolder{

        /**
         * Default constructor.
         *
         * @param itemView The {@link View} being hosted in this ViewHolder
         */
         ExpandableTextView childView;
        public ChildHolder(View itemView) {
            super(itemView);
            //childView= (ExpandableTextView) itemView.findViewById(R.id.expand_text_view);;
        }
    }
    public static class ParentHolder extends ParentViewHolder{

        /**
         * Default constructor.
         *
         * @param itemView The {@link View} being hosted in this ViewHolder
         */
        TextView mainHeading,subHeading;
        LinearLayout linear;

        public ParentHolder(View itemView) {

            super(itemView);
            mainHeading= (TextView) itemView.findViewById(R.id.text_main_parent);
            subHeading= (TextView) itemView.findViewById(R.id.text_sub_parent);
            linear=(LinearLayout)itemView.findViewById(R.id.linear);
        }
    }
}
