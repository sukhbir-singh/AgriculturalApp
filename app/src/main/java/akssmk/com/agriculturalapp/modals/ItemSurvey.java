package akssmk.com.agriculturalapp.modals;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by kharita on 7/8/16.
 */
public class ItemSurvey implements Parcelable,Serializable{
    private String year,area,production;

    protected ItemSurvey(Parcel in) {
        year = in.readString();
        area = in.readString();
        production = in.readString();
    }

    public ItemSurvey() {
    }


    public static final Creator<ItemSurvey> CREATOR = new Creator<ItemSurvey>() {
        @Override
        public ItemSurvey createFromParcel(Parcel in) {
            return new ItemSurvey(in);
        }

        @Override
        public ItemSurvey[] newArray(int size) {
            return new ItemSurvey[size];
        }
    };

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(year);
        dest.writeString(area);
        dest.writeString(production);
    }
}
