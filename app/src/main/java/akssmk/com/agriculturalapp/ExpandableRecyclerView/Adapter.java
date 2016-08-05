package akssmk.com.agriculturalapp.ExpandableRecyclerView;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.List;

import akssmk.com.agriculturalapp.R;

/**
 * Created by Ramola on 8/5/2016.
 */
public class Adapter extends ExpandableRecyclerAdapter<Adapter.ParentHolder,Adapter.ChildHolder>{


    /**
     * Primary constructor. Sets up {@link #mParentItemList} and {@link #mItemList}.
     * <p/>
     * Changes to {@link #mParentItemList} should be made through add/remove methods in
     * {@link ExpandableRecyclerAdapter}
     *
     * @param parentItemList List of all {@link ParentListItem} objects to be
     *                       displayed in the RecyclerView that this
     *                       adapter is linked to
     */
    public Adapter(@NonNull List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
    }

    @Override
    public ParentHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View v= LayoutInflater.from(parentViewGroup.getContext()).inflate(R.layout.item_crop_parent,parentViewGroup,false);
        return new ParentHolder(v);
    }

    @Override
    public ChildHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View v= LayoutInflater.from(childViewGroup.getContext()).inflate(R.layout.item_crop_child,childViewGroup,false);
        return new ChildHolder(v);
    }

    @Override
    public void onBindParentViewHolder(ParentHolder parentViewHolder, int position, ParentListItem parentListItem) {
        ParentHeading parentHeading=(ParentHeading) parentListItem;
        parentViewHolder.mainHeading.setText(parentHeading.getHeading());
        parentViewHolder.subHeading.setText("Ok");


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
            childView= (ExpandableTextView) itemView.findViewById(R.id.expand_text_view);
        }
    }
    public static class ParentHolder extends ParentViewHolder{

        /**
         * Default constructor.
         *
         * @param itemView The {@link View} being hosted in this ViewHolder
         */
        TextView mainHeading,subHeading;
        public ParentHolder(View itemView) {

            super(itemView);
            mainHeading= (TextView) itemView.findViewById(R.id.text_main_parent);
            subHeading= (TextView) itemView.findViewById(R.id.text_sub_parent);
        }
    }
}
