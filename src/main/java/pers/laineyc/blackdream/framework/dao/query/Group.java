package pers.laineyc.blackdream.framework.dao.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LaineyC
 */
public class Group implements Serializable {

    private List<GroupItem> groupItemList = new ArrayList<>();

    public Group(String property){
        this.by(property);
    }

    public void by(String property){
        groupItemList.add(new Group.GroupItem(property));
    }

    public List<GroupItem> getGroupItemList() {
        return groupItemList;
    }

    public static class GroupItem{

        private String property;

        public GroupItem(String property) {
            this.property = property;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

    }

}
