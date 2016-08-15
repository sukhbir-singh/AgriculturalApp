package akssmk.com.agriculturalapp.modals;

import android.content.Intent;

/**
 * Created by sukhbir on 7/8/16.
 */
public class MainListItem {
    private int imageUrl;
    private int hindiText,englishText;
    private String backgroundColor;
    private Intent intent;

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getHindiText() {
        return hindiText;
    }

    public void setHindiText(int hindiText) {
        this.hindiText = hindiText;
    }

    public int getEnglishText() {
        return englishText;
    }

    public void setEnglishText(int englishText) {
        this.englishText = englishText;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
