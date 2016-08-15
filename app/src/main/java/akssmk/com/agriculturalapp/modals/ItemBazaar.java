package akssmk.com.agriculturalapp.modals;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by kharita on 7/8/16.
 */
public class ItemBazaar implements Parcelable,Serializable{
    private String market,commodity,variety,min,max,avg;

    protected ItemBazaar(Parcel in) {
        market = in.readString();
        commodity = in.readString();
        variety = in.readString();
        min = in.readString();
        max = in.readString();
        avg = in.readString();
    }

    public ItemBazaar() {
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public static final Creator<ItemBazaar> CREATOR = new Creator<ItemBazaar>() {
        @Override
        public ItemBazaar createFromParcel(Parcel in) {
            return new ItemBazaar(in);
        }

        @Override
        public ItemBazaar[] newArray(int size) {
            return new ItemBazaar[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(market);
        dest.writeString(commodity);
        dest.writeString(variety);
        dest.writeString(min);
        dest.writeString(max);
        dest.writeString(avg);
    }
}
