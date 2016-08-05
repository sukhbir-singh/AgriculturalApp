package akssmk.com.agriculturalapp.ExpandableRecyclerView;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by Ramola on 8/5/2016.
 */
public class ParentHeading implements ParentListItem{
    private String Heading;
    private List<ChildHeading> childList;

    public ParentHeading(String heading, List<ChildHeading> childList) {
        Heading = heading;
        this.childList = childList;
    }

    @Override
    public List<?> getChildItemList() {
        return childList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public String getHeading() {
        return Heading;
    }
}
